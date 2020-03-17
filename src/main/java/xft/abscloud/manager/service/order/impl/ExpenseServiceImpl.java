package xft.abscloud.manager.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xft.abscloud.manager.mapper.AbsExpenseMapper;
import xft.abscloud.manager.pojo.AbsExpense;
import xft.abscloud.manager.service.order.IExpenseService;

@Service
public class ExpenseServiceImpl implements IExpenseService{

	@Autowired
	private AbsExpenseMapper absExpenseMapper;

	/**
	 * 查询线上支付消费记录
	 */
	@Override
	public List<AbsExpense> queryExpenseList(String userId) {
		
		List<AbsExpense> expenseList = absExpenseMapper.queryExpenseList(userId);
//		if(expenseList !=null && expenseList.size()>0) {
//			for(AbsExpense expense : expenseList) {
//				String payResult = expense.getPayResult();
//				String newPayResult = this.transferPayResult(payResult);
//				expense.setPayResult(newPayResult);
//				String payType = expense.getPayType();
//				String newPayType = OrderUtil.transferPayType(payType);
//				expense.setPayType(newPayType);
//			}
//		}
		
		
		return expenseList;
	}

	/**
	 * 插入消费记录
	 */
	@Override
	public void addAbsExpense(AbsExpense absExpense) {
		
		absExpenseMapper.addAbsExpense(absExpense);
	}
	
	
//	public String transferPayResult(String payResult) {
//		String str = null;
//		if(!StringUtils.isEmpty(payResult)) {
//			switch (payResult) {
//			case "01":
//				str = PayResultEnum.UN_FINISHED.getValue();
//				break;
//			case "00":
//				str = PayResultEnum.FINISHED.getValue();
//				break;
//			default: 
//				str = PayResultEnum.UN_FINISHED.getValue();
//				break;
//			}
//		}
//		return str;
//	}

}
