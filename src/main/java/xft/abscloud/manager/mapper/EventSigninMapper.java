package xft.abscloud.manager.mapper;

import org.springframework.stereotype.Repository;
import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.EventSignin;

import java.util.List;
import java.util.Map;

@Repository
public interface EventSigninMapper extends MyMapper<EventSignin> {

    int add(EventSignin eventSignin);

    // 根据活动id查看
    List<Map<String, Object>> queryListByEventId(Integer eventId);

    // 根据会员id查看
    List<Map<String, Object>> queryListByMemberId(String memberId);

}