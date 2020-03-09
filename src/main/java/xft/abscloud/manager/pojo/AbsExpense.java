package xft.abscloud.manager.pojo;

import javax.persistence.*;

@Table(name = "abs_expense")
public class AbsExpense {
    @Id
    @Column(name = "expense_id")
    private Integer expenseId;

    /**
     * 订单编号
     */
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "m_grade_id")
    private String mGradeId;

    /**
     * 会员等级
     */
    @Column(name = "member_grade")
    private String memberGrade;

    /**
     * 消费时间
     */
    @Column(name = "expense_time")
    private String expenseTime;

    /**
     * 消费金额
     */
    @Column(name = "expense_amount")
    private String expenseAmount;

    /**
     * 支付方式 01-在线支付 0101-微信支付 0102-支付宝支付    02-线下支付
     */
    @Column(name = "pay_type")
    private String payType;

    /**
     * 支付结果 00-已完成 01-未完成
     */
    @Column(name = "pay_result")
    private String payResult;

    /**
     * @return expense_id
     */
    public Integer getExpenseId() {
        return expenseId;
    }

    /**
     * @param expenseId
     */
    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

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
     * @return member_id
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * @return m_grade_id
     */
    public String getmGradeId() {
        return mGradeId;
    }

    /**
     * @param mGradeId
     */
    public void setmGradeId(String mGradeId) {
        this.mGradeId = mGradeId;
    }

    /**
     * 获取会员等级
     *
     * @return member_grade - 会员等级
     */
    public String getMemberGrade() {
        return memberGrade;
    }

    /**
     * 设置会员等级
     *
     * @param memberGrade 会员等级
     */
    public void setMemberGrade(String memberGrade) {
        this.memberGrade = memberGrade;
    }

    /**
     * 获取消费时间
     *
     * @return expense_time - 消费时间
     */
    public String getExpenseTime() {
        return expenseTime;
    }

    /**
     * 设置消费时间
     *
     * @param expenseTime 消费时间
     */
    public void setExpenseTime(String expenseTime) {
        this.expenseTime = expenseTime;
    }

    /**
     * 获取消费金额
     *
     * @return expense_amount - 消费金额
     */
    public String getExpenseAmount() {
        return expenseAmount;
    }

    /**
     * 设置消费金额
     *
     * @param expenseAmount 消费金额
     */
    public void setExpenseAmount(String expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    /**
     * 获取支付方式 01-在线支付 0101-微信支付 0102-支付宝支付    02-线下支付
     *
     * @return pay_type - 支付方式 01-在线支付 0101-微信支付 0102-支付宝支付    02-线下支付
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置支付方式 01-在线支付 0101-微信支付 0102-支付宝支付    02-线下支付
     *
     * @param payType 支付方式 01-在线支付 0101-微信支付 0102-支付宝支付    02-线下支付
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * 获取支付结果 00-已完成 01-未完成
     *
     * @return pay_result - 支付结果 00-已完成 01-未完成
     */
    public String getPayResult() {
        return payResult;
    }

    /**
     * 设置支付结果 00-已完成 01-未完成
     *
     * @param payResult 支付结果 00-已完成 01-未完成
     */
    public void setPayResult(String payResult) {
        this.payResult = payResult;
    }
}