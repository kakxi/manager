package xft.abscloud.manager.service.order;

import java.util.List;

import xft.abscloud.manager.pojo.AbsVoucher;

public interface IVoucherService {

	/**
	 * 用户申请线下支付
	 * @param absVoucher
	 */
	public void applyVoucher(AbsVoucher absVoucher);

	/**
	 * 支付凭证审核
	 * @param absVoucher
	 */
	public void applyConsumptionVoucher(AbsVoucher absVoucher);

	/**
	 * 查询线下支付消费记录
	 * @param object
	 * @return
	 */
	public List<AbsVoucher> queryCurrentUserVoucher(String userId);

	/**
	 * 线下消费凭证审核拒绝
	 * @param voucherId
	 * @param auditOpinion
	 */
	public void applyConsumptionVoucherRefued(String voucherId, String auditOpinion);

	/**
	 * 修改凭证
	 * @param absVoucher
	 */
	public void editVoucher(AbsVoucher absVoucher);

}
