package xft.abscloud.manager.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
import xft.abscloud.manager.dto.JsonResult;
import xft.abscloud.manager.enums.InvoiceStatusEnum;
import xft.abscloud.manager.exception.BusinessException;
import xft.abscloud.manager.pojo.AbsInvoice;
import xft.abscloud.manager.pojo.AbsOrder;
import xft.abscloud.manager.service.order.IOrderService;
import xft.abscloud.manager.service.order.InvoiceSerive;
/**
 * 发票
 * @author lenovo
 *
 */
@RestController
@RequestMapping("/invoice")
@Slf4j
public class InvoiceController {

	@Autowired
	private InvoiceSerive invoiceService;
	
	@Autowired
	private IOrderService orderService;
	/**
	 * 发票申请记录查询
	 * @return
	 */
	@PostMapping("/queryInvoice")
	public @ResponseBody JsonResult queryInvoice(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		//获取当前用户
		//如果是管理员 查询所有用户的消费记录，否则查询当前用户的消费记录
		String userId = null;
		List<AbsInvoice> invoiceList = null;
		//如果是管理员
		if("".equals(userId)) {
			invoiceList = invoiceService.queryInvoice(null);
		}else {//如果不是管理员
			invoiceList = invoiceService.queryInvoice(userId);
		}
        
        PageInfo<AbsInvoice> pageInfo = new PageInfo<AbsInvoice>(invoiceList);
        
        return JsonResult.build(200, "发票查询成功", pageInfo);
	}
	
	/**
	 *  发票审核--同意
	 * @param voucherId
	 * @return
	 */
	@PostMapping("/examineInvoice")
	public @ResponseBody JsonResult examineInvoice(String invoiceId,String remark) {
		if(StringUtils.isEmpty(invoiceId)) {
			throw new BusinessException("发票ID不能为空！");
		}
		AbsInvoice absInvoice = invoiceService.queryInvoiceById(invoiceId);
		if(absInvoice == null) {
			throw new BusinessException("发票申请记录不存在！");
		}
		String invoiceStatus = absInvoice.getInvoiceStatus();
		if(StringUtils.isEmpty(invoiceStatus)) {
			throw new BusinessException("发票状态不能为空！");
		}
		if(invoiceStatus.equals(InvoiceStatusEnum.INVOICED.getKey())) {
			throw new BusinessException(InvoiceStatusEnum.INVOICED.getValue());
		}
		try {
			invoiceService.updateInvoiceStatus(invoiceId,remark);
			return JsonResult.okMsg("审核成功");
		}catch(Exception e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg(e.getMessage());
		}
	}
	
	/**
	 *  发票审核--拒绝
	 * @param voucherId
	 * @return
	 */
	@PostMapping("/examineInvoiceRefused")
	public @ResponseBody JsonResult examineInvoiceRefused(String invoiceId, String remark) {
		if(StringUtils.isEmpty(invoiceId)) {
			throw new BusinessException("发票ID不能为空！");
		}
		AbsInvoice absInvoice = invoiceService.queryInvoiceById(invoiceId);
		if(absInvoice == null) {
			throw new BusinessException("发票申请记录不存在！");
		}
		String invoiceStatus = absInvoice.getInvoiceStatus();
		if(StringUtils.isEmpty(invoiceStatus)) {
			throw new BusinessException("发票状态不能为空！");
		}
		if(invoiceStatus.equals(InvoiceStatusEnum.INVOICED.getKey())) {
			throw new BusinessException(InvoiceStatusEnum.INVOICED.getValue());
		}
		try {
			invoiceService.examineInvoiceRefused(invoiceId,remark);
			return JsonResult.okMsg("审核拒绝成功");
		}catch(Exception e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg(InvoiceStatusEnum.INVOICED.getValue());
		}
	}
	
	/**
	 * 发票申请
	 * @return
	 */
	@PostMapping("/applyInvoice")
	public @ResponseBody JsonResult applyInvoice(AbsInvoice absInvoice) {
		
		//获取当前用户
		String userId = "1";
		absInvoice.setUserId(userId);
		
//		String invoiceType = absInvoice.getInvoiceType();
		String shippingAddress = absInvoice.getShippingAddress();
		if(StringUtils.isEmpty(shippingAddress)) {
			throw new BusinessException("寄送地址不能为空！");
		}
//		if(invoiceType.equals(InvoiceTypeEnum.ENTERPRISE.getKey())) {
//			checkAbsInvoice(absInvoice);
//		}
		String orderId = absInvoice.getOrderId();
		AbsOrder absOrder = orderService.queryOrderById(orderId);
		if(absOrder == null) {
			throw new BusinessException("订单号为：【"+orderId+"】的订单不存在！");
		}
		AbsInvoice newAbsInvoice = invoiceService.queryInvoiceByOrderId(orderId);
		if(newAbsInvoice !=null) {
			throw new BusinessException("订单号为：【"+orderId+"】的订单已经申请发票记录！");
		}
		try {
			invoiceService.applyInvoice(absInvoice);
			return JsonResult.okMsg("发票申请成功");
		}catch(Exception e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg(e.getMessage());
		}
	}

	private void checkAbsInvoice(AbsInvoice absInvoice) {
		String invoiceTitle = absInvoice.getInvoiceTitle();
		String invoiceTaxNum = absInvoice.getInvoiceTaxNum();
		String bankDeposit = absInvoice.getBankDeposit();
		String bankAccount = absInvoice.getBanckAccount();
		String enterprisePhone = absInvoice.getEnterprisePhone();
		String enterpriseAddress = absInvoice.getEnterpriseAddress();
//		String email = absInvoice.getEmail();
		if(StringUtils.isEmpty(invoiceTitle)) {
			throw new BusinessException("发票抬头不能为空！");
		}
		if(StringUtils.isEmpty(invoiceTaxNum)) {
			throw new BusinessException("税号不能为空！");
		}
		if(StringUtils.isEmpty(bankDeposit)) {
			throw new BusinessException("开户银行不能为空！");
		}
		if(StringUtils.isEmpty(bankAccount)) {
			throw new BusinessException("银行账户不能为空！");
		}
		if(StringUtils.isEmpty(enterprisePhone)) {
			throw new BusinessException("企业电话不能为空！");
		}
		if(StringUtils.isEmpty(enterpriseAddress)) {
			throw new BusinessException("企业地址不能为空！");
		}
//		if(StringUtils.isEmpty(email)) {
//			throw new BusinessException("企业邮箱不能为空！");
//		}
	}
	
	/**
	 * 合同查询
	 * @return
	 */
//	@PostMapping("/queryContract")
//	public @ResponseBody JsonResult queryContract() {
//		
//	}
//	
//	/**
//	 * 合同审核
//	 * @return
//	 */
//	@PostMapping("/examineContract")
//	public @ResponseBody JsonResult examineContract() {
//		
//	}
//	
//	/**
//	 * 合同申请
//	 * @return
//	 */
//	@PostMapping("/applyContract")
//	public @ResponseBody JsonResult applyContract() {
//		
//	}
	
}
