package xft.abscloud.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xft.abscloud.manager.dto.EquityVo;
import xft.abscloud.manager.dto.PackEquityDto;
import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.LevelEquity;

import java.util.List;
import java.util.Map;

@Repository
public interface LevelEquityMapper extends MyMapper<LevelEquity> {

    int insertForeach(List<LevelEquity> list);

    List<Map<String,Object>> queryEquityList(String levelId);

    int deleteByLevelId(String levelId);

    /**
     * 查询所有套餐
     * @return
     */
    public List<PackEquityDto> queryLevelEquityPage();

    public List<EquityVo> queryEquityVoList(@Param("levelId") String levelId);

}