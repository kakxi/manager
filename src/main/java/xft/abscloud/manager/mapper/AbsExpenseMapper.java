package xft.abscloud.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.AbsExpense;

public interface AbsExpenseMapper extends MyMapper<AbsExpense>{

	/**
	 * 查询线上消费记录
	 * @param userId
	 * @return
	 */
	public List<AbsExpense> queryExpenseList(@Param("memberId")String userId);

	/**
	 * 插入消费记录
	 * @param absExpense
	 */
	public void addAbsExpense(@Param("entity")AbsExpense absExpense);

}
