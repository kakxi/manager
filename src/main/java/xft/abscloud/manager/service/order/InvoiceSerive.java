package xft.abscloud.manager.service.order;

import java.util.List;

import xft.abscloud.manager.pojo.AbsInvoice;

public interface InvoiceSerive {

	/**
	 * 查询发票信息
	 * @param userId
	 * @param invoiceStatus 
	 * @return
	 */
	public List<AbsInvoice> queryInvoice(String  userId, String invoiceStatus);

	/**
	 * 发票审核
	 * @param voucherId
	 */
	public void updateInvoiceStatus(String invoiceId, String remark);

	/**
	 * 发票申请
	 * @param absInvoice
	 */
	public void applyInvoice(AbsInvoice absInvoice);
	

    /**
     * 发票审核拒绝
     * @param invoiceId
     * @param remark
     */
	public void examineInvoiceRefused(String invoiceId, String remark);

	/**
	 * 查询发票信息
	 * @param userId
	 * @return
	 */
	public AbsInvoice queryInvoiceByOrderId(String orderId);
	
	/**
	 * 查询发票信息
	 * @param userId
	 * @return
	 */
	public AbsInvoice queryInvoiceById(String invoiceId);

}
