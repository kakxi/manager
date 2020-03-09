package xft.abscloud.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.Event;

import java.util.List;

@Repository
public interface EventMapper extends MyMapper<Event> {

    int add(Event event);

    int update(Event event);

    int increaseNumUsed(Integer id);
    int reduceNumUsed(Integer id);

    int updateStatus(@Param("id") Integer id, @Param("status") String status);

    List<Event> queryList(Event event);
}