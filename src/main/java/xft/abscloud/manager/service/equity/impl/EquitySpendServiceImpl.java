package xft.abscloud.manager.service.equity.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xft.abscloud.manager.enums.EventStatus;
import xft.abscloud.manager.enums.SpendStatus;
import xft.abscloud.manager.enums.YesOrNo;
import xft.abscloud.manager.exception.BusinessException;
import xft.abscloud.manager.mapper.EquitySpendMapper;
import xft.abscloud.manager.pojo.EquitySpend;
import xft.abscloud.manager.pojo.Event;
import xft.abscloud.manager.pojo.MemberEquity;
import xft.abscloud.manager.service.equity.EquitySpendService;
import xft.abscloud.manager.service.equity.EventService;
import xft.abscloud.manager.service.equity.MemberEquityService;
import xft.abscloud.manager.util.DateUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class EquitySpendServiceImpl implements EquitySpendService {

    @Resource
    private EquitySpendMapper equitySpendMapper;

    @Resource
    private EventService eventService;

    @Resource
    private MemberEquityService memberEquityService;

    @Override
    public int add(EquitySpend equitySpend) {
        return equitySpendMapper.add(equitySpend);
    }

    /**
     * 保存预约
     *
     * @param memberId
     * @param eventId
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int saveReserve(String memberId, Integer eventId) {
        // 获取活动信息
        Event event = eventService.query(eventId);
        if (event == null) {
            throw new BusinessException("未查询到对应的活动信息!");
        }
        // 判断是否是重复预约
        EquitySpend es = equitySpendMapper.queryByMemberIdAndEventId(memberId, eventId);
        if (es != null) {
            if (es.getStatus().equals(SpendStatus.FINISHED.getCode())) {
                throw new BusinessException("您已经预约过此活动，请勿重复预约!");
            }
        }
        // 判断活动状态
        if (!event.getStatus().equals(EventStatus.ISSUED.getCode())) {
            throw new BusinessException("当前活动无法预约，请联系管理员!");
        }
        // 判断活动的预约截止时间 yyyy-MM-dd,是否过期
        String reserveEndDateStr = event.getReserveEndDate();
        if (DateUtils.judgeExpired(reserveEndDateStr) == true) {
            throw new BusinessException("当前活动的预约截止时间已过，无法完成预约!");
        }
        // 判断活动人数是否已达到限制人数
        if (event.getNumUsed() > event.getNumLimit()) {
            throw new BusinessException("当前活动的预约人数已满，无法完成预约!");
        }
        // 保存消费记录
        EquitySpend equitySpend = new EquitySpend();
        // 判断活动是否消费权益
        String needEquity = event.getNeedEquity();
        // 判断是否限定权益
        if (needEquity.equals(YesOrNo.YES.getCode())) {
            // 查询会员是否拥有对应权益，及数量不为0
            String spendCode = event.getSpendCode();
            // 根据会员id和消费标识查询会员的权益信息
            MemberEquity memberEquity = memberEquityService.query(memberId, spendCode);
            if (memberEquity == null) {
                throw new BusinessException("您当前没有对应的权益，无法预约此活动!");
            }
            // 剩余消费次数
            int balanceCounter = memberEquity.getBalanceCounter();
            if (balanceCounter < 1) {
                throw new BusinessException("您当前的权益消费次数为0，无法预约此活动!");
            }
            // 扣除对应的权益数量
            memberEquityService.reduceSpendCounter(memberEquity.getId());
            // 设置权益id和名称
            equitySpend.setEquityId(memberEquity.getId());
            equitySpend.setEquityName(memberEquity.getEquityName());
        }
        // 更新活动的预约人数 +1
        eventService.increaseNumUsed(eventId);
        equitySpend.setEventId(eventId);
        equitySpend.setMemberId(memberId);
        equitySpend.setCreateTime(new Date());
        equitySpend.setStatus(SpendStatus.FINISHED.getCode());
        // 如果存在预约记录，则更新为已完成
        if (es != null) {
            return equitySpendMapper.updateStatus(es.getId(), SpendStatus.FINISHED.getCode());
        }
        return equitySpendMapper.add(equitySpend);
    }

    @Override
    public EquitySpend query(Integer id) {
        return equitySpendMapper.selectByPrimaryKey(id);
    }

    /**
     * 取消预约
     *
     * @param id 预约记录id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int cancelReserve(Integer id) {
        // 根据id查询权益消费信息
        EquitySpend equitySpend = equitySpendMapper.selectByPrimaryKey(id);
        if (equitySpend == null) {
            throw new BusinessException("未查询到对应的预约记录!");
        }
        if (equitySpend.getStatus().equals(SpendStatus.CANCELED.getCode())) {
            throw new BusinessException("您已经取消了此活动，请勿重复操作!");
        }

        // 查询活动信息
        Integer eventId = equitySpend.getEventId();
        // 获取活动信息
        Event event = eventService.query(eventId);
        if (event == null) {
            throw new BusinessException("未查询到对应的活动信息!");
        }
        // 判断活动的取消截止时间 yyyy-MM-dd,是否过期
        String cancelEndDateStr = event.getCancelEndDate();
        if (DateUtils.judgeExpired(cancelEndDateStr) == true) {
            throw new BusinessException("当前活动的取消截止时间已过，无法完成取消预约的操作!");
        }
        // 判断活动是否消费了权益
        String needEquity = event.getNeedEquity();
        // 判断是否限定权益
        if (needEquity.equals(YesOrNo.YES.getCode())) {
            // 增加对应的权益数量
            memberEquityService.increaseSpendCounter(equitySpend.getEquityId());
        }
        // 更新活动的预约人数 -1
        eventService.reduceNumUsed(eventId);
        // 无论是否消费权益，最终都需要，更新消费记录的状态为已取消
        return equitySpendMapper.updateStatus(id, SpendStatus.CANCELED.getCode());
    }

    /**
     * 根据活动id查询 预约人员列表
     *
     * @param eventId
     * @return
     */
    @Override
    public List<Map<String, Object>> queryListByEventId(Integer eventId) {
        return equitySpendMapper.queryListByEventId(eventId);
    }

    /**
     * 根据会员id查询 权益消费记录
     *
     * @param memberId
     * @return
     */
    @Override
    public List<Map<String, Object>> queryListByMemberId(String memberId) {
        return equitySpendMapper.queryListByMemberId(memberId);
    }
}
