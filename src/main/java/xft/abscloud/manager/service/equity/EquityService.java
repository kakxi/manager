package xft.abscloud.manager.service.equity;

import com.github.pagehelper.PageInfo;
import xft.abscloud.manager.pojo.Equity;

import java.util.List;

public interface EquityService {

    int add(Equity equity);

    int update(Equity equity);

    int delete(Integer equityId);

    Equity query(Integer equityId);

    PageInfo<Equity> queryPage(Equity equity, int pageNum, int pageSize);

    List<Equity> queryAll();
}
