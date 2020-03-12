package xft.abscloud.manager.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

import xft.abscloud.manager.enums.FpTypeEnum;
import xft.abscloud.manager.enums.InvoiceContentEnum;
import xft.abscloud.manager.enums.InvoiceStatusEnum;
import xft.abscloud.manager.enums.InvoiceTypeEnum;
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
		
		List<AbsInvoice> invoiceList = absInvoiceMapper.queryInvoice(userId);
		for(AbsInvoice invoice : invoiceList) {
			String fpType = invoice.getFpType();
			invoice.setFpType(this.transferFpType(fpType));
			String invoiceStatus = invoice.getInvoiceStatus();
			invoice.setInvoiceStatus(this.transferInvoiceStatus(invoiceStatus));
			String invoiceContent = invoice.getInvoiceContent();
			invoice.setInvoiceContent(this.transferInvoiceContent(invoiceContent));
			String invoiceType = invoice.getInvoiceType();
			invoice.setInvoiceType(this.transferInvoiceType(invoiceType));
		}
		return invoiceList;
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
		absInvoice.setInvoiceContent(InvoiceContentEnum.INVOICE_CONTENT_01.getKey());
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

	
	
	private String transferFpType(String fpType) {
		String str = null;
		if(!StringUtils.isEmpty(fpType)) {
			switch (fpType) {
			case "00":
				str = FpTypeEnum.ELECTRONIC_GENERAL_INVOICE.getValue();
				break;
			case "01":
				str = FpTypeEnum.PAPER_GENERAL_INVOICE.getValue();
				break;
			case "02":
				str =  FpTypeEnum.PAPER_SPECIAL_INVOICE.getValue();
				break;
			default: 
				str = FpTypeEnum.PAPER_GENERAL_INVOICE.getValue();
				break;
			}
		}
		return str;
	}
	
	private String transferInvoiceType(String invoiceType) {
		String str = null;
		if(!StringUtils.isEmpty(invoiceType)) {
			switch (invoiceType) {
			case "001":
				str = InvoiceTypeEnum.PERSONAL.getValue();
				break;
			case "002":
				str = InvoiceTypeEnum.ENTERPRISE.getValue();
				break;
			default: 
				str = InvoiceTypeEnum.PERSONAL.getValue();
				break;
			}
		}
		return str;
	}
	
	private String transferInvoiceStatus(String invoiceStatus) {
		String str = null;
		if(!StringUtils.isEmpty(invoiceStatus)) {
			switch (invoiceStatus) {
			case "000":
				str = InvoiceStatusEnum.UN_INVOICED.getValue();
				break;
			case "001":
				str = InvoiceStatusEnum.INVOICED.getValue();
				break;
			default: 
				str = InvoiceStatusEnum.UN_INVOICED.getValue();
				break;
			}
		}
		return str;
	}
	
	private String transferInvoiceContent(String invoiceContent) {
		String str = null;
		if(!StringUtils.isEmpty(invoiceContent)) {
			switch (invoiceContent) {
			case "01":
				str = InvoiceContentEnum.INVOICE_CONTENT_01.getValue();
				break;
			case "02":
				str = InvoiceContentEnum.INVOICE_CONTENT_02.getValue();
				break;
			default: 
				str = InvoiceContentEnum.INVOICE_CONTENT_01.getValue();
				break;
			}
		}
		return str;
	}
}
