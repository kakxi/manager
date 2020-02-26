package xft.abscloud.manager.service.equity;

import xft.abscloud.manager.pojo.LevelEquity;

import java.util.List;
import java.util.Map;

public interface LevelEquityService {

    int save(Integer levelId, List<LevelEquity> list);

    List<Map<String, Object>> query(Integer levelId);

    int delete(Integer levelId);
}
