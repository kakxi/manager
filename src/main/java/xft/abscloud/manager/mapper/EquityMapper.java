package xft.abscloud.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.Equity;

import java.util.List;

@Repository
public interface EquityMapper extends MyMapper<Equity> {

    int add(Equity equity);

    int update(Equity equity);

    List<Equity> queryList(Equity equity);

    Equity queryByCode(String spendCode);

    Equity queryByCodeAndId(@Param("equityId") Integer equityId,@Param("equityCode") String equityCode);
}