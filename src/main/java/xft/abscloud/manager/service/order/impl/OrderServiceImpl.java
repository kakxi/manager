package xft.abscloud.manager.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;

import xft.abscloud.manager.enums.OrderStatusEnum;
import xft.abscloud.manager.enums.PayResultEnum;
import xft.abscloud.manager.enums.PayTypeEnum;
import xft.abscloud.manager.mapper.AbsOrderMapper;
import xft.abscloud.manager.pojo.AbsExpense;
import xft.abscloud.manager.pojo.AbsOrder;
import xft.abscloud.manager.service.order.IExpenseService;
import xft.abscloud.manager.service.order.IOrderService;
import xft.abscloud.manager.util.OrderUtil;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private AbsOrderMapper absOrderMapper;
	
	@Autowired
	private IExpenseService expenseService;
	/**
	 * 创建订单
	 */
	@Override
	public String createOrder(AbsOrder absOrder) {
		
		absOrder.setCreateTime(OrderUtil.getCurrentTime());
		absOrder.setOrderStatus(OrderStatusEnum.UN_PAY.getKey());
		//生成订单编号
		String orderNum = OrderUtil.createOrderNum(absOrder.getmGradeId());
		absOrder.setOrderId(orderNum);
		absOrderMapper.createOrder(absOrder);
		return orderNum;
	}

	/**
	 * 查询订单
	 */
	@Override
	public List<AbsOrder> queryOderList(String userId, String orderId, String orderStatus) {
		
		List<AbsOrder> orderList =  absOrderMapper.queryOrderList(userId, orderId, orderStatus);
		this.checkList(orderList);
		return orderList;
	}
	
	public void checkList(List<AbsOrder> orderList) {
		if(orderList !=null && orderList.size()>0) {
			for(AbsOrder absOrder : orderList) {
				String orderStatus1 = absOrder.getOrderStatus();
				String newOrderStatus = transferOrderStatus(orderStatus1);
				absOrder.setOrderStatus(newOrderStatus);
				String payType = absOrder.getPayType();
				String newPayType = OrderUtil.transferPayType(payType);
				absOrder.setPayType(newPayType);
			}
		}
	}

	/**
	 * 更新订单支付状态
	 */
	@Override
	public void updateOrderStatus(String orderId, String orderStatus, String payType) {
		
		//支付时间
		String payTime = OrderUtil.getCurrentTime();
		
		absOrderMapper.updateOrderStatus(orderId,orderStatus,payTime,payType);
	}

	/**
	 * 修改订单
	 */
	@Override
	public void editOrder(AbsOrder absOrder) {
		
	}

	/**
	 * 通过订单号查询订单
	 */
	@Override
	public AbsOrder queryOrderById(String orderId) {
		
		return absOrderMapper.queryOrderById(orderId);
	}

	/**
	 * 取消订单
	 */
	@Override
	public void cancelOrder(String orderId) {
		
		String orderStatus = OrderStatusEnum.CANCEL.getKey();
		absOrderMapper.cancelOrder(orderId,orderStatus);
	}

	/**
	 * 微信支付回调
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void absPayCallBack(String orderId) {
		//修改订单
		String orderStatus = OrderStatusEnum.PAY.getKey();
		String payType = PayTypeEnum.WX_PAY.getKey();
		//修改订单
		this.updateOrderStatus(orderId, orderStatus, payType);
		
		//添加消费记录
		this.addExpense(orderId);

		//添加其他业务 TODO  
		//会员表插入一条记录等等
	}
	
	/**
	 * 添加消费记录
	 * @param orderId
	 */
	@Override
	public void addExpense(String orderId) {
		//查询订单
		AbsOrder absOrder = this.queryOrderById(orderId);
		
		AbsExpense absExpense = new AbsExpense();
		absExpense.setOrderId(orderId);
		absExpense.setMemberId(absOrder.getUserId());
		absExpense.setMemberGrade(absOrder.getMemberGrade());
		absExpense.setExpenseTime(absOrder.getPayTime());
		absExpense.setmGradeId(absOrder.getmGradeId());
		absExpense.setPayType(absOrder.getPayType());
		absExpense.setExpenseAmount(absOrder.getTotalAmount());
		absExpense.setPayResult(PayResultEnum.FINISHED.getKey());
		expenseService.addAbsExpense(absExpense);
	}

	private String transferOrderStatus(String orderStatus) {
		String str = null;
		if(!StringUtils.isEmpty(orderStatus)) {
			switch (orderStatus) {
			case "0":
				str = OrderStatusEnum.UN_PAY.getValue();
				break;
			case "1":
				str = OrderStatusEnum.PAY.getValue();
				break;
			case "2":
				str =  OrderStatusEnum.CANCEL.getValue();
				break;
			default: 
				str = OrderStatusEnum.UN_PAY.getValue();
				break;
			}
		}
		return str;
	}

	/**
	 * 查询可以开发票的订单
	 */
	@Override
	public List<AbsOrder> queryOrderByfp(String userId, String orderId) {

		String orderStatus = OrderStatusEnum.PAY.getKey();
		
		return absOrderMapper.queryOrderByfp(userId,orderId,orderStatus);
	}
	
}
