package xft.abscloud.manager.service.equity.impl;

import org.springframework.stereotype.Service;
import xft.abscloud.manager.exception.BusinessException;
import xft.abscloud.manager.mapper.EquitySpendMapper;
import xft.abscloud.manager.mapper.EventSigninMapper;
import xft.abscloud.manager.pojo.EquitySpend;
import xft.abscloud.manager.pojo.EventSignin;
import xft.abscloud.manager.service.equity.EquitySpendService;
import xft.abscloud.manager.service.equity.EventSigninService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class EventSigninServiceImpl implements EventSigninService {

    @Resource
    private EventSigninMapper eventSigninMapper;

    @Resource
    private EquitySpendService equitySpendService;

    @Override
    public int add(EventSignin eventSignin) {
        eventSignin.setSigninTime(new Date());
        return eventSigninMapper.add(eventSignin);
    }

    @Override
    public List<Map<String, Object>> queryListByEventId(Integer eventId) {
        return eventSigninMapper.queryListByEventId(eventId);
    }

    @Override
    public List<Map<String, Object>> queryListByMemberId(String memberId) {
        return eventSigninMapper.queryListByMemberId(memberId);
    }

    /**
     * 通过扫描二维码签到
     * @param spendId
     * @return
     */
    @Override
    public int signinByQrcode(Integer spendId) {
        EquitySpend equitySpend = equitySpendService.query(spendId);
        if(equitySpend == null){
            throw new BusinessException("异常，找不到对应的消费记录，签到失败!");
        }
        EventSignin eventSignin = new EventSignin();
        eventSignin.setMemberId(equitySpend.getMemberId());
        eventSignin.setEventId(equitySpend.getEventId());
        return add(eventSignin);
    }
}
