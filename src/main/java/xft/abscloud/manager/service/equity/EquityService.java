package xft.abscloud.manager.service.equity;

import xft.abscloud.manager.pojo.Equity;

import java.util.List;

public interface EquityService {

    int add(Equity equity);

    int update(Equity equity);

    List<Equity> queryList(Equity equity);

    Equity queryByCode(String spendCode);

    Equity queryByCodeAndId(Integer equityId,String spendCode);
}
