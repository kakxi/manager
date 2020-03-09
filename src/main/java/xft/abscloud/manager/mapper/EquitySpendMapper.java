package xft.abscloud.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.EquitySpend;

import java.util.List;
import java.util.Map;

@Repository
public interface EquitySpendMapper extends MyMapper<EquitySpend> {

    int add(EquitySpend equitySpend);

    int updateStatus(@Param("id") Integer id, @Param("status") String status);

    // 根据活动id查看消费记录（预约人员列表）
    List<Map<String, Object>> queryListByEventId(Integer eventId);

    // 根据会员id查看消费记录
    List<Map<String, Object>> queryListByMemberId(String memberId);

    EquitySpend queryByMemberIdAndEventId(@Param("memberId") String memberId, @Param("eventId") Integer eventId);

}