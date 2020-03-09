package xft.abscloud.manager.service.equity.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xft.abscloud.manager.mapper.LevelEquityMapper;
import xft.abscloud.manager.pojo.LevelEquity;
import xft.abscloud.manager.service.equity.LevelEquityService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LevelEquityServiceImpl implements LevelEquityService {

    @Resource
    private LevelEquityMapper levelEquityMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int save(String levelId, List<LevelEquity> list) {
        // 保存套餐之前，先删除原有的
        levelEquityMapper.deleteByLevelId(levelId);
        return levelEquityMapper.insertForeach(list);
    }

    @Override
    public List<Map<String, Object>> query(String levelId) {
        return levelEquityMapper.queryEquityList(levelId);
    }

    @Override
    public int delete(String levelId) {
        return levelEquityMapper.deleteByLevelId(levelId);
    }
}
