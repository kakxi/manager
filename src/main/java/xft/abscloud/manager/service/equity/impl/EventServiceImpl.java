package xft.abscloud.manager.service.equity.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xft.abscloud.manager.enums.EventStatus;
import xft.abscloud.manager.enums.YesOrNo;
import xft.abscloud.manager.exception.BusinessException;
import xft.abscloud.manager.mapper.EventMapper;
import xft.abscloud.manager.mapper.MemberEquityMapper;
import xft.abscloud.manager.pojo.Event;
import xft.abscloud.manager.pojo.MemberEquity;
import xft.abscloud.manager.service.equity.EquitySpendService;
import xft.abscloud.manager.service.equity.EventService;
import xft.abscloud.manager.service.equity.MemberEquityService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

    @Resource
    private EventMapper eventMapper;

    @Resource
    private MemberEquityMapper memberEquityMapper;

    @Resource
    private MemberEquityService memberEquityService;

    @Resource
    private EquitySpendService equitySpendService;

    @Override
    public int add(Event event) {
        // 默认未发布
        event.setStatus(EventStatus.UN_ISSUE.getCode());
        return eventMapper.add(event);
    }

    @Override
    public int update(Event event) {
        return eventMapper.update(event);
    }

    @Override
    public Event query(Integer id) {
        return eventMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Integer id) {
        Event event = eventMapper.selectByPrimaryKey(id);
        if (event == null) {
            throw new BusinessException("异常，找不到对应的记录!");
        }
        // 判断活动状态为已发布时，不允许删除
        if(event.getStatus().equals(EventStatus.ISSUED.getCode())){
            throw new BusinessException("活动已发布，请先取消活动后再删除!");
        }
        return eventMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateStatus(Integer id, String status) {
        return eventMapper.updateStatus(id, status);
    }

    @Override
    public PageInfo<Event> queryPage(Event event, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Event> list = eventMapper.queryList(event);
        PageInfo<Event> result = new PageInfo<>(list);
        return result;
    }

    // 发布活动
    @Override
    public int issueEvent(Integer id) {
        Event event = eventMapper.selectByPrimaryKey(id);
        if (event == null) {
            throw new BusinessException("异常，找不到对应的记录!");
        }
        String needEquity = event.getNeedEquity();
        // 判断是否限定权益
        if (needEquity.equals(YesOrNo.YES.getCode())) {
            String spendCode = event.getSpendCode();
            // 更新活动状态:已发布
            int result = updateStatus(id, EventStatus.ISSUED.getCode());
            // 查询拥有消费标识的会员列表
            List<String> memberIdList = memberEquityService.queryMemberListBySpendCode(spendCode);
            // 给会员发送通知
            // TODO
            return result;
        }
        return 0;
    }

    // 取消活动
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int cancelEvent(Integer id) {
        Event event = eventMapper.selectByPrimaryKey(id);
        if (event == null) {
            throw new BusinessException("异常，找不到对应的记录!");
        }
        String needEquity = event.getNeedEquity();
        // 判断是否限定权益
        if (needEquity.equals(YesOrNo.YES.getCode())) {
            String spendCode = event.getSpendCode();

            // 查询已经预约的人员列表，发送提醒，并更新对应的消费次数
            // TODO 查询出消费记录列表
            // List<Map<String,Object>> equitySpendList = equitySpendService.queryListByEventId(id);

            // 活动取消时，批量更新会员权益的消费次数 +1
            int res = memberEquityMapper.updateBalanceCounterForCancelEvent(id);
            log.info("取消活动，更新会员权益的消费次数 +1, 结果:"+res);
        }
        // 更新活动状态:已取消
        int result = updateStatus(id, EventStatus.CANCELED.getCode());
        return result;
    }

    @Override
    public int increaseNumUsed(Integer id) {
        return eventMapper.increaseNumUsed(id);
    }

    @Override
    public int reduceNumUsed(Integer id) {
        return eventMapper.reduceNumUsed(id);
    }
}
