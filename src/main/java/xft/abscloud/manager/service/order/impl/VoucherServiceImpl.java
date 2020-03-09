package xft.abscloud.manager.service.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;

import xft.abscloud.manager.enums.ApplyEnum;
import xft.abscloud.manager.enums.OrderStatusEnum;
import xft.abscloud.manager.enums.PayTypeEnum;
import xft.abscloud.manager.mapper.AbsVoucherMapper;
import xft.abscloud.manager.pojo.AbsVoucher;
import xft.abscloud.manager.service.order.IOrderService;
import xft.abscloud.manager.service.order.IVoucherService;
import xft.abscloud.manager.util.OrderUtil;

@Service
public class VoucherServiceImpl implements IVoucherService{

	@Autowired
	private AbsVoucherMapper absVoucherMapper;
	
	@Autowired
	private IOrderService orderService;
	
	/**
	 * 用户线下支付凭证申请
	 */
	@Override
	public void applyVoucher(AbsVoucher absVoucher) {
		absVoucher.setApplyStatus(ApplyEnum.UN_APPLY.getKey());
		absVoucher.setCreateTime(OrderUtil.getCurrentTime());		
		
		absVoucherMapper.applyVoucher(absVoucher);
	}

	/**
	 * 支付凭证审核
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void applyConsumptionVoucher(AbsVoucher absVoucher) {
		//审核通过需要更新支付状态
		String applyStatus = ApplyEnum.APPLY.getKey();
		absVoucher.setUpdateTime(OrderUtil.getCurrentTime());
		absVoucher.setAuditOpinion("同意");
		absVoucher.setApplyStatus(applyStatus);
		int count = absVoucherMapper.applyConsumptionRecord(absVoucher);
		String orderId = absVoucher.getOrderId();
		
		//大于0表审核通过
		if(count>0 && applyStatus.equals(ApplyEnum.APPLY.getKey())) {
			//更新订单状态
			String payType = PayTypeEnum.UN_ONLINE.getKey();
			orderService.updateOrderStatus(absVoucher.getOrderId(), OrderStatusEnum.PAY.getKey(),payType);
			
			//添加消费记录
			orderService.addExpense(orderId);
			
			//添加其他业务 TODO  
			//会员表插入一条记录等等
		}
	}

	/**
	 * 查询线下消费记录
	 */
	@Override
	public List<AbsVoucher> queryCurrentUserVoucher(String userId) {
		
		List<AbsVoucher> voucherList = absVoucherMapper.queryCurrentUserVoucher(userId);
		if(voucherList !=null && voucherList.size()>0) {
			for(AbsVoucher voucher : voucherList) {
				String applyStatus = voucher.getApplyStatus();
				String newApplyStatus = this.transferApplyStatus(applyStatus);
				voucher.setApplyStatus(newApplyStatus);
			}
		}
		
		return voucherList;
	}

	/**
	 * 线下消费凭证拒绝
	 */
	@Override
	public void applyConsumptionVoucherRefued(String voucherId, String auditOpinion) {
		String updateTime = OrderUtil.getCurrentTime();
		String applyStatus = ApplyEnum.REFUSED.getKey();
		
		absVoucherMapper.applyConsumptionVoucherRefued(voucherId,auditOpinion,updateTime,applyStatus);
	}

	/**
	 * 修改凭证
	 */
	@Override
	public void editVoucher(AbsVoucher absVoucher) {
		absVoucher.setApplyStatus(ApplyEnum.UN_APPLY.getKey());
		absVoucher.setUpdateTime(OrderUtil.getCurrentTime());
		absVoucherMapper.editVoucher(absVoucher);
	}
	
	
	private String transferApplyStatus(String applyStatus) {
		String str = null;
		if(!StringUtils.isEmpty(applyStatus)) {
			switch (applyStatus) {
			case "0":
				str = ApplyEnum.UN_APPLY.getValue();
				break;
			case "1":
				str = ApplyEnum.APPLY.getValue();
				break;
			case "2":
				str =  ApplyEnum.REFUSED.getValue();
				break;
			default: 
				str = ApplyEnum.UN_APPLY.getValue();
				break;
			}
		}
		return str;
	}

}
