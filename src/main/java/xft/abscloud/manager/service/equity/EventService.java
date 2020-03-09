package xft.abscloud.manager.service.equity;

import com.github.pagehelper.PageInfo;
import xft.abscloud.manager.pojo.Event;

public interface EventService {

    int add(Event event);

    int update(Event event);

    Event query(Integer id);

    int delete(Integer id);

    int updateStatus(Integer id, String status);

    PageInfo<Event> queryPage(Event event, int pageNum, int pageSize);

    // 发布活动
    int issueEvent(Integer id);

    // 取消活动
    int cancelEvent(Integer id);

    // 更新已预约人数 +1
    int increaseNumUsed(Integer id);
    // 更新已预约人数 -1
    int reduceNumUsed(Integer id);
}
