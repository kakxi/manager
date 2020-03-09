package xft.abscloud.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.AbsInvoice;

public interface AbsInvoiceMapper extends MyMapper<AbsInvoice>{

	/**
	 * 查询发票
	 * @param userId
	 * @return
	 */
	public List<AbsInvoice> queryInvoice(String userId);

	/**
	 * 发票审核
	 * @param invoiceId
	 * @param invoiceStatus
	 * @param updateTime
	 */
	public void updateInvoiceStatus(String invoiceId, String invoiceStatus, String updateTime, String remark);

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
	public AbsInvoice queryInvoiceByOrderId(String orderId);

	/**
	 * 查询发票
	 * @param invoiceId
	 * @return
	 */
	public AbsInvoice queryInvoiceById(String invoiceId);

}
