package xft.abscloud.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.AbsVoucher;

public interface AbsVoucherMapper extends MyMapper<AbsVoucher>{
	
	/**
	 * 用户线下支付凭证申请
	 */
	public void applyVoucher(@Param("entity")AbsVoucher absVoucher);

	/**
	 * 审核线下支付凭证
	 * @param absVoucher
	 * @return
	 */
	public int applyConsumptionRecord(@Param("entity")AbsVoucher absVoucher);

	/**
	 * 查询线下消费记录
	 * @param userId
	 * @return
	 */
	public List<AbsVoucher> queryCurrentUserVoucher(String userId);

	/**
	 * 线下消费凭证审核拒绝
	 * @param voucherId
	 * @param auditOpinion
	 * @param updateTime
	 * @param applyStatus
	 */
	public void applyConsumptionVoucherRefued(String voucherId, String auditOpinion, String updateTime,
			String applyStatus);

	/**
	 * 修改凭证
	 * @param absVoucher
	 */
	public void editVoucher(@Param("entity")AbsVoucher absVoucher);

}
