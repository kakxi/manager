package xft.abscloud.manager.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "abs_member_equity")
public class MemberEquity {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 会员id
     */
    @Column(name = "member_id")
    private String memberId;

    /**
     * 权益编码
     */
    @Column(name = "equity_code")
    private String equityCode;

    /**
     * 权益名称
     */
    @Column(name = "equity_name")
    private String equityName;

    /**
     * 权益描述
     */
    @Column(name = "equity_desc")
    private String equityDesc;

    /**
     * 权益类型:国金ABS云平台服务，社群服务，咨询诊断服务，增值服务
     */
    @Column(name = "equity_type")
    private String equityType;

    /**
     * 权益属性:功能权限、消费类，咨询类
     */
    @Column(name = "equity_prop")
    private String equityProp;

    /**
     * 使用次数
     */
    @Column(name = "usage_counter")
    private Integer usageCounter;

    /**
     * 剩余使用次数
     */
    @Column(name = "balance_counter")
    private Integer balanceCounter;

    /**
     * 权限控制标识
     */
    @Column(name = "perm_code")
    private String permCode;

    /**
     * 消费标识
     */
    @Column(name = "spend_code")
    private String spendCode;

    /**
     * 序号
     */
    private Integer order;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取会员id
     *
     * @return member_id - 会员id
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 设置会员id
     *
     * @param memberId 会员id
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取权益编码
     *
     * @return equity_code - 权益编码
     */
    public String getEquityCode() {
        return equityCode;
    }

    /**
     * 设置权益编码
     *
     * @param equityCode 权益编码
     */
    public void setEquityCode(String equityCode) {
        this.equityCode = equityCode;
    }

    /**
     * 获取权益名称
     *
     * @return equity_name - 权益名称
     */
    public String getEquityName() {
        return equityName;
    }

    /**
     * 设置权益名称
     *
     * @param equityName 权益名称
     */
    public void setEquityName(String equityName) {
        this.equityName = equityName;
    }

    /**
     * 获取权益描述
     *
     * @return equity_desc - 权益描述
     */
    public String getEquityDesc() {
        return equityDesc;
    }

    /**
     * 设置权益描述
     *
     * @param equityDesc 权益描述
     */
    public void setEquityDesc(String equityDesc) {
        this.equityDesc = equityDesc;
    }

    /**
     * 获取权益类型:国金ABS云平台服务，社群服务，咨询诊断服务，增值服务
     *
     * @return equity_type - 权益类型:国金ABS云平台服务，社群服务，咨询诊断服务，增值服务
     */
    public String getEquityType() {
        return equityType;
    }

    /**
     * 设置权益类型:国金ABS云平台服务，社群服务，咨询诊断服务，增值服务
     *
     * @param equityType 权益类型:国金ABS云平台服务，社群服务，咨询诊断服务，增值服务
     */
    public void setEquityType(String equityType) {
        this.equityType = equityType;
    }

    /**
     * 获取权益属性:功能权限、消费类，咨询类
     *
     * @return equity_prop - 权益属性:功能权限、消费类，咨询类
     */
    public String getEquityProp() {
        return equityProp;
    }

    /**
     * 设置权益属性:功能权限、消费类，咨询类
     *
     * @param equityProp 权益属性:功能权限、消费类，咨询类
     */
    public void setEquityProp(String equityProp) {
        this.equityProp = equityProp;
    }

    /**
     * 获取使用次数
     *
     * @return usage_counter - 使用次数
     */
    public Integer getUsageCounter() {
        return usageCounter;
    }

    /**
     * 设置使用次数
     *
     * @param usageCounter 使用次数
     */
    public void setUsageCounter(Integer usageCounter) {
        this.usageCounter = usageCounter;
    }

    /**
     * 获取剩余使用次数
     *
     * @return balance_counter - 剩余使用次数
     */
    public Integer getBalanceCounter() {
        return balanceCounter;
    }

    /**
     * 设置剩余使用次数
     *
     * @param balanceCounter 剩余使用次数
     */
    public void setBalanceCounter(Integer balanceCounter) {
        this.balanceCounter = balanceCounter;
    }

    /**
     * 获取权限控制标识
     *
     * @return perm_code - 权限控制标识
     */
    public String getPermCode() {
        return permCode;
    }

    /**
     * 设置权限控制标识
     *
     * @param permCode 权限控制标识
     */
    public void setPermCode(String permCode) {
        this.permCode = permCode;
    }

    /**
     * 获取消费标识
     *
     * @return spend_code - 消费标识
     */
    public String getSpendCode() {
        return spendCode;
    }

    /**
     * 设置消费标识
     *
     * @param spendCode 消费标识
     */
    public void setSpendCode(String spendCode) {
        this.spendCode = spendCode;
    }

    /**
     * 获取序号
     *
     * @return order - 序号
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * 设置序号
     *
     * @param order 序号
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * 获取创建人
     *
     * @return create_user - 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     *
     * @param createUser 创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}