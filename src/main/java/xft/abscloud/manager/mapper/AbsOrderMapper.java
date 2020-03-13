package xft.abscloud.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.AbsOrder;

public interface AbsOrderMapper extends MyMapper<AbsOrder>{

	/**
	 * 更新订单支付状态
	 * @param orderId
	 * @param orderStatus
	 */
	public void updateOrderStatus(String orderId, String orderStatus, String payTime, String payType);

	/**
	 * 创建订单
	 * @param absOrder
	 */
	public void createOrder(@Param("entity")AbsOrder absOrder);

	/**
	 * 查询订单列表
	 * @param userId
	 * @param orderStatus
	 * @return
	 */
	public List<AbsOrder> queryOrderList(String userId, String orderId, String orderStatus);

	/**
	 * 通过订单号查询订单
	 * @param orderId
	 * @return
	 */
	public AbsOrder queryOrderById(String orderId);

	/**
	 * 取消订单
	 * @param orderId
	 * @param orderStatus
	 * @param updateTime
	 */
	public void cancelOrder(String orderId, String orderStatus);

	/**
	 * 查询可以开发票的订单
	 * @param userId
	 * @param orderId
	 * @param orderStatus 
	 * @return
	 */
	public List<AbsOrder> queryOrderByfp(String userId, String orderId, String orderStatus);

}
