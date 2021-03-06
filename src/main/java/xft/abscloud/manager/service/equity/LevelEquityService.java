package xft.abscloud.manager.service.equity;

import xft.abscloud.manager.dto.PackEquityDto;
import xft.abscloud.manager.pojo.LevelEquity;

import java.util.List;
import java.util.Map;

public interface LevelEquityService {

    int save(String levelId, List<LevelEquity> list);

    List<Map<String, Object>> query(String levelId);

    int delete(String levelId);

    /**
     * 查询套餐
     * @return
     */
    public List<PackEquityDto> queryLevelEquityPage();

}
