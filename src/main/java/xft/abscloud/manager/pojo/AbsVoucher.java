package xft.abscloud.manager.pojo;

import javax.persistence.*;

@Table(name = "abs_voucher")
public class AbsVoucher {
    @Id
    @Column(name = "voucher_id")
    private Integer voucherId;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 支付金额
     */
    @Column(name = "pay_amount")
    private String payAmount;

    /**
     * 交易单号/支付流水号
     */
    @Column(name = "transcation_nm")
    private String transcationNm;

    /**
     * 商品名称
     */
    @Column(name = "goods_name")
    private String goodsName;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private String payTime;

    /**
     * 凭证文件路径
     */
    @Column(name = "file_url")
    private String fileUrl;

    /**
     * 审核状态  0-未审核 1-审核通过 2-审核拒绝
     */
    @Column(name = "apply_status")
    private String applyStatus;

    /**
     * 审核意见
     */
    @Column(name = "audit_opinion")
    private String auditOpinion;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * @return voucher_id
     */
    public Integer getVoucherId() {
        return voucherId;
    }

    /**
     * @param voucherId
     */
    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取支付金额
     *
     * @return pay_amount - 支付金额
     */
    public String getPayAmount() {
        return payAmount;
    }

    /**
     * 设置支付金额
     *
     * @param payAmount 支付金额
     */
    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取交易单号/支付流水号
     *
     * @return transcation_nm - 交易单号/支付流水号
     */
    public String getTranscationNm() {
        return transcationNm;
    }

    /**
     * 设置交易单号/支付流水号
     *
     * @param transcationNm 交易单号/支付流水号
     */
    public void setTranscationNm(String transcationNm) {
        this.transcationNm = transcationNm;
    }

    /**
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 设置商品名称
     *
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 获取支付时间
     *
     * @return pay_time - 支付时间
     */
    public String getPayTime() {
        return payTime;
    }

    /**
     * 设置支付时间
     *
     * @param payTime 支付时间
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取凭证文件路径
     *
     * @return file_url - 凭证文件路径
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 设置凭证文件路径
     *
     * @param fileUrl 凭证文件路径
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * 获取审核状态  0-未审核 1-审核通过 2-审核拒绝
     *
     * @return apply_status - 审核状态  0-未审核 1-审核通过 2-审核拒绝
     */
    public String getApplyStatus() {
        return applyStatus;
    }

    /**
     * 设置审核状态  0-未审核 1-审核通过 2-审核拒绝
     *
     * @param applyStatus 审核状态  0-未审核 1-审核通过 2-审核拒绝
     */
    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    /**
     * 获取审核意见
     *
     * @return audit_opinion - 审核意见
     */
    public String getAuditOpinion() {
        return auditOpinion;
    }

    /**
     * 设置审核意见
     *
     * @param auditOpinion 审核意见
     */
    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}