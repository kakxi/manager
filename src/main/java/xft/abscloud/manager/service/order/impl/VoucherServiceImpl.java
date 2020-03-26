package xft.abscloud.manager.service.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xft.abscloud.manager.enums.ApplyEnum;
import xft.abscloud.manager.enums.OrderStatusEnum;
import xft.abscloud.manager.enums.PayTypeEnum;
import xft.abscloud.manager.mapper.AbsVoucherMapper;
import xft.abscloud.manager.pojo.AbsVoucher;
import xft.abscloud.manager.service.order.IOrderService;
import xft.abscloud.manager.service.order.IVoucherService;
import xft.abscloud.manager.util.OrderUtil;

import java.util.List;

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
			//支付时间
			String payTime = absVoucher.getPayTime();
			orderService.updateOrderStatus(absVoucher.getOrderId(), OrderStatusEnum.PAY.getKey(),payType,payTime);
			
			//添加消费记录
			orderService.addExpense(orderId);
			//添加会员权益
			orderService.addMemberEquity(orderId);

			//支付完成 发送通知 TODO
		}
	}

	/**
	 * 查询线下消费记录
	 */
	@Override
	public List<AbsVoucher> queryCurrentUserVoucher(String userId) {
		
		List<AbsVoucher> voucherList = absVoucherMapper.queryCurrentUserVoucher(userId);

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
	
	
	/**
	 * 根据订单号查询凭证
	 */
	@Override
	public AbsVoucher queryVoucherByOrderId(String orderId) {
		
		AbsVoucher voucher = absVoucherMapper.queryVoucherByOrderId(orderId);
		
		return voucher;
	}

}
