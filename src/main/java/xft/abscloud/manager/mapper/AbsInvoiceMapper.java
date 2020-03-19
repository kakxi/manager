package xft.abscloud.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.AbsInvoice;

import java.util.List;

@Repository
public interface AbsInvoiceMapper extends MyMapper<AbsInvoice>{

	/**
	 * 查询发票
	 * @param userId
	 * @return
	 */
	public List<AbsInvoice> queryInvoice(@Param("userId") String userId, @Param("invoiceStatus")String invoiceStatus);

	/**
	 * 发票审核
	 * @param invoiceId
	 * @param invoiceStatus
	 * @param updateTime
	 */
	public void updateInvoiceStatus(@Param("invoiceId")String invoiceId, @Param("invoiceStatus")String invoiceStatus, @Param("updateTime")String updateTime, @Param("remark")String remark);

	/**
	 * 发票申请
	 * @param absInvoice
	 */
	public void applyInvoice(@Param("entity")AbsInvoice absInvoice);

	/**
	 * 查询发票
	 * @param orderId
	 * @return
	 */
	public AbsInvoice queryInvoiceByOrderId(@Param("orderId")String orderId);

	/**
	 * 查询发票
	 * @param invoiceId
	 * @return
	 */
	public AbsInvoice queryInvoiceById(@Param("invoiceId")String invoiceId);

}
