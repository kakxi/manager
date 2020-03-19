package xft.abscloud.manager.service.order;

import xft.abscloud.manager.pojo.AbsOrder;
import xft.abscloud.manager.util.OrderUtil;

import java.util.List;

public interface IOrderService {

	/**
	 * 创建订单
	 * @param absOrder
	 */
	public String createOrder(AbsOrder absOrder);
	
	/**
	 * 查询订单
	 * @param userId
	 * @param orderId
	 * @param orderStatus 
	 * @return
	 */
	public List<AbsOrder> queryOderList(String userId, String orderId, String orderStatus);
	
	/**
	 * 更新订单状态
	 * @param orderId
	 * @param orderStatus
	 * @param payType
	 */
	public void updateOrderStatus(String orderId, String orderStatus, String payType, String payTime);

	/**
	 * 修改订单
	 * @param absOrder
	 */
	public void editOrder(AbsOrder absOrder);
	
	/**
	 * 通过订单号查询订单
	 * @param orderId
	 * @return
	 */
	public AbsOrder queryOrderById(String orderId);

	/**
	 * 取消订单
	 * @param orderId
	 */
	public void cancelOrder(String orderId);

	/**
	 * 微信回调通知
	 * @param orderId
	 */
	public void absPayCallBack(String orderId);
	
	/**
	 * 添加消费记录
	 * @param orderId
	 */
	public void addExpense(String orderId);

	/**
	 * 查询可以开发票的订单
	 * @param object
	 * @param orderId
	 * @return
	 */
	public List<AbsOrder> queryOrderByfp(String userId, String orderId);
	
}
