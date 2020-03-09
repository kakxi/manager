package xft.abscloud.manager.service.equity;

import xft.abscloud.manager.pojo.EquitySpend;

import java.util.List;
import java.util.Map;

/**
 * 权益消费
 */
public interface EquitySpendService {

    int add(EquitySpend equitySpend);

    // 预约
    int saveReserve(String memberId,Integer eventId);

    EquitySpend query(Integer id);

    // 取消预约
    int cancelReserve(Integer id);

    // 根据活动id查看消费记录（预约人员列表）
    List<Map<String,Object>> queryListByEventId(Integer eventId);

    // 根据会员id查看消费记录
    List<Map<String,Object>> queryListByMemberId(String memberId);

}
