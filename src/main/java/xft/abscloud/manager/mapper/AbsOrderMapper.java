package xft.abscloud.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.AbsOrder;

import java.util.List;

@Repository
public interface AbsOrderMapper extends MyMapper<AbsOrder>{

	/**
	 * 更新订单支付状态
	 * @param orderId
	 * @param orderStatus
	 */
	public void updateOrderStatus(@Param("orderId")String orderId, @Param("orderStatus")String orderStatus, @Param("payTime")String payTime, @Param("payType")String payType);

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
	public List<AbsOrder> queryOrderList(@Param("userId")String userId, @Param("orderId")String orderId, @Param("orderStatus")String orderStatus);

	/**
	 * 通过订单号查询订单
	 * @param orderId
	 * @return
	 */
	public AbsOrder queryOrderById(@Param("orderId")String orderId);

	/**
	 * 取消订单
	 * @param orderId
	 * @param orderStatus
	 */
	public void cancelOrder(@Param("orderId")String orderId, @Param("orderStatus")String orderStatus);

	/**
	 * 查询可以开发票的订单
	 * @param userId
	 * @param orderId
	 * @param orderStatus 
	 * @return
	 */
	public List<AbsOrder> queryOrderByfp(@Param("userId") String userId, @Param("orderId")String orderId, @Param("orderStatus")String orderStatus);

}
