package xft.abscloud.manager.pojo;

import javax.persistence.*;

@Table(name = "abs_order")
public class AbsOrder {
    /**
     * 订单编号
     */
    @Id
    @Column(name = "order_id")
    private String orderId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 数量   当前单位是：年
     */
    private String number;

    /**
     * 会员等级id
     */
    @Column(name = "m_grade_id")
    private String mGradeId;

    /**
     * 会员等级名称
     */
    @Column(name = "member_grade")
    private String memberGrade;

    /**
     * 订单金额
     */
    @Column(name = "total_amount")
    private String totalAmount;

    /**
     * 支付方式  01-在线支付 0101-微信支付 0102-支付宝支付    02-线下支付
     */
    @Column(name = "pay_type")
    private String payType;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private String payTime;

    /**
     * 订单状态  0-未支付 1-已支付 2-已取消
     */
    @Column(name = "order_status")
    private String orderStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    private String inoviceStatus;
    
    /**
     * 凭证审核状态
     */
    private String applyStatus;
    
    /**
     * 获取订单编号
     *
     * @return order_id - 订单编号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单编号
     *
     * @param orderId 订单编号
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
     * 获取数量   当前单位是：年
     *
     * @return number - 数量   当前单位是：年
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置数量   当前单位是：年
     *
     * @param number 数量   当前单位是：年
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 获取会员等级id
     *
     * @return m_grade_id - 会员等级id
     */
    public String getmGradeId() {
        return mGradeId;
    }

    /**
     * 设置会员等级id
     *
     * @param mGradeId 会员等级id
     */
    public void setmGradeId(String mGradeId) {
        this.mGradeId = mGradeId;
    }

    /**
     * 获取会员等级名称
     *
     * @return member_grade - 会员等级名称
     */
    public String getMemberGrade() {
        return memberGrade;
    }

    /**
     * 设置会员等级名称
     *
     * @param memberGrade 会员等级名称
     */
    public void setMemberGrade(String memberGrade) {
        this.memberGrade = memberGrade;
    }

    /**
     * 获取订单金额
     *
     * @return total_amount - 订单金额
     */
    public String getTotalAmount() {
        return totalAmount;
    }

    /**
     * 设置订单金额
     *
     * @param totalAmount 订单金额
     */
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 获取支付方式  01-在线支付 0101-微信支付 0102-支付宝支付    02-线下支付
     *
     * @return pay_type - 支付方式  01-在线支付 0101-微信支付 0102-支付宝支付    02-线下支付
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置支付方式  01-在线支付 0101-微信支付 0102-支付宝支付    02-线下支付
     *
     * @param payType 支付方式  01-在线支付 0101-微信支付 0102-支付宝支付    02-线下支付
     */
    public void setPayType(String payType) {
        this.payType = payType;
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
     * 获取订单状态  0-未支付 1-已支付 2-已取消
     *
     * @return order_status - 订单状态  0-未支付 1-已支付 2-已取消
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态  0-未支付 1-已支付 2-已取消
     *
     * @param orderStatus 订单状态  0-未支付 1-已支付 2-已取消
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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

	public String getInoviceStatus() {
		return inoviceStatus;
	}

	public void setInoviceStatus(String inoviceStatus) {
		this.inoviceStatus = inoviceStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
}