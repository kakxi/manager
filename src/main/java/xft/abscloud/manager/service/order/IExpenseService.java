package xft.abscloud.manager.service.order;

import java.util.List;

import xft.abscloud.manager.pojo.AbsExpense;

public interface IExpenseService {

	/**
	 * 查询线上消费记录
	 * @param userId
	 * @return
	 */
	public List<AbsExpense> queryExpenseList(String userId);

	/**
	 * 插入消费记录
	 * @param absExpense
	 */
	public void addAbsExpense(AbsExpense absExpense);
}
