package xft.abscloud.manager.service.order.impl;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xft.abscloud.manager.enums.OrderStatusEnum;
import xft.abscloud.manager.enums.PayResultEnum;
import xft.abscloud.manager.enums.PayTypeEnum;
import xft.abscloud.manager.mapper.AbsOrderMapper;
import xft.abscloud.manager.pojo.AbsExpense;
import xft.abscloud.manager.pojo.AbsOrder;
import xft.abscloud.manager.pojo.MemberEquity;
import xft.abscloud.manager.service.equity.LevelEquityService;
import xft.abscloud.manager.service.equity.MemberEquityService;
import xft.abscloud.manager.service.order.IExpenseService;
import xft.abscloud.manager.service.order.IOrderService;
import xft.abscloud.manager.util.OrderUtil;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private AbsOrderMapper absOrderMapper;
	
	@Autowired
	private IExpenseService expenseService;

	@Autowired
	private LevelEquityService levelEquityService;

	@Autowired
	private MemberEquityService memberEquityService;
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
		return orderList;
	}
	
	/**
	 * 更新订单支付状态
	 */
	@Override
	public void updateOrderStatus(String orderId, String orderStatus, String payType, String payTime) {
		

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
		//支付时间
		String payTime = OrderUtil.getCurrentTime();
		//修改订单
		this.updateOrderStatus(orderId, orderStatus, payType,payTime);
		
		//添加消费记录
		this.addExpense(orderId);

		//添加会员权益
		this.addMemberEquity(orderId);

		//支付完成 发送通知 TODO
	}

	@Override
	public void addMemberEquity(String orderId){

		AbsOrder absOrder = absOrderMapper.queryOrderById(orderId);
		//TODO 插入会员记录
		String memberId = null;
		//会员等级Id
		String gradeId = absOrder.getmGradeId();
		//查询套餐权益
		List<Map<String, Object>> map = levelEquityService.query(gradeId);
		if(map.size()>0){
			for(Map<String, Object> m : map){
				MemberEquity memberEquity = BeanUtil.mapToBean(m,MemberEquity.class,true);
				memberEquity.setMemberId(memberId);

				memberEquityService.add(memberEquity);
			}
		}
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

	/**
	 * 查询可以开发票的订单
	 */
	@Override
	public List<AbsOrder> queryOrderByfp(String userId, String orderId) {

		String orderStatus = OrderStatusEnum.PAY.getKey();
		
		return absOrderMapper.queryOrderByfp(userId,orderId,orderStatus);
	}
	
}
