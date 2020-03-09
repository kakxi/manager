package xft.abscloud.manager.service.equity;

import xft.abscloud.manager.pojo.EventSignin;

import java.util.List;
import java.util.Map;

public interface EventSigninService {

    int add(EventSignin eventSignin);

    // 根据活动id查看
    List<Map<String,Object>> queryListByEventId(Integer eventId);

    // 根据会员id查看
    List<Map<String,Object>> queryListByMemberId(String memberId);

    int signinByQrcode(Integer spendId);
}
