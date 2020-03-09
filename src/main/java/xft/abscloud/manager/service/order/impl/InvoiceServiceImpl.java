package xft.abscloud.manager.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xft.abscloud.manager.enums.InvoiceStatusEnum;
import xft.abscloud.manager.mapper.AbsInvoiceMapper;
import xft.abscloud.manager.pojo.AbsInvoice;
import xft.abscloud.manager.service.order.InvoiceSerive;
import xft.abscloud.manager.util.OrderUtil;

@Service
public class InvoiceServiceImpl implements InvoiceSerive{

	@Autowired
	private AbsInvoiceMapper absInvoiceMapper;
	
	/**
	 * 查询发票
	 */
	@Override
	public List<AbsInvoice> queryInvoice(String userId) {
		return absInvoiceMapper.queryInvoice(userId);
	}

	/**
	 * 发票审核
	 */
	@Override
	public void updateInvoiceStatus(String invoiceId, String remark) {
		
		String invoiceStatus = InvoiceStatusEnum.INVOICED.getKey();
		String updateTime = OrderUtil.getCurrentTime();
		absInvoiceMapper.updateInvoiceStatus(invoiceId,invoiceStatus,updateTime,remark);
	}

	/**
	 * 发票申请
	 */
	@Override
	public void applyInvoice(AbsInvoice absInvoice) {
		
		String createTime = OrderUtil.getCurrentTime();
		String invoiceStatus = InvoiceStatusEnum.UN_INVOICED.getKey();
		absInvoice.setCreateTime(createTime);
		absInvoice.setInvoiceStatus(invoiceStatus);
		
		absInvoiceMapper.applyInvoice(absInvoice);
	}

	/**
	 * 发票审核拒绝
	 */
	@Override
	public void examineInvoiceRefused(String invoiceId, String remark) {
		String invoiceStatus = InvoiceStatusEnum.UN_INVOICED.getKey();
		String updateTime = OrderUtil.getCurrentTime();
		absInvoiceMapper.updateInvoiceStatus(invoiceId,invoiceStatus,updateTime,remark);		
	}

	@Override
	public AbsInvoice queryInvoiceByOrderId(String orderId) {
		return absInvoiceMapper.queryInvoiceByOrderId(orderId);
	}

	@Override
	public AbsInvoice queryInvoiceById(String invoiceId) {
		return absInvoiceMapper.queryInvoiceById(invoiceId);
	}

}
