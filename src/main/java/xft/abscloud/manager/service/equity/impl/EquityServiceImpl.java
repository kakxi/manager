package xft.abscloud.manager.service.equity.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import xft.abscloud.manager.exception.BusinessException;
import xft.abscloud.manager.mapper.EquityMapper;
import xft.abscloud.manager.pojo.Equity;
import xft.abscloud.manager.service.equity.EquityService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class EquityServiceImpl implements EquityService {

    @Resource
    private EquityMapper equityMapper;

    @Override
    public int add(Equity equity) {
        // 判断是否已存在对应权益code的记录
        Equity old = equityMapper.queryByCode(equity.getEquityCode());
        if (old != null) {
            throw new BusinessException("系统中已存在相同编码的权益");
        }
//        equity.setState("1");
        equity.setCreateTime(new Date());
        return equityMapper.add(equity);
    }

    @Override
    public int update(Equity equity) {
        // 判断是否已存在对应权益code的记录
        Equity old = equityMapper.queryByCodeAndId(equity.getEquityId(),equity.getEquityCode());
        if (old != null) {
            throw new BusinessException("系统中已存在相同编码的权益");
        }
        return equityMapper.update(equity);
    }

    @Override
    public int delete(Integer equityId) {
        return equityMapper.deleteByPrimaryKey(equityId);
    }

    @Override
    public Equity query(Integer equityId) {
        return equityMapper.selectByPrimaryKey(equityId);
    }

    @Override
    public PageInfo<Equity> queryPage(Equity equity, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Equity> list = equityMapper.queryList(equity);
        PageInfo<Equity> result = new PageInfo<>(list);
        return result;
    }

    @Override
    public List<Equity> queryAll() {
        Equity equity = new Equity();
        equity.setState("1");
        return equityMapper.queryList(equity);
    }
}
