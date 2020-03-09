package xft.abscloud.manager.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "abs_equity")
public class Equity {
    /**
     * 主键
     */
    @Id
    @Column(name = "equity_id")
    private Integer equityId;

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
     * 默认次数
     */
    private Integer counter;

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
     * 状态；0-正常 1-禁用
     */
    private String state;

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
     * @return equity_id - 主键
     */
    public Integer getEquityId() {
        return equityId;
    }

    /**
     * 设置主键
     *
     * @param equityId 主键
     */
    public void setEquityId(Integer equityId) {
        this.equityId = equityId;
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
     * 获取默认次数
     *
     * @return counter - 默认次数
     */
    public Integer getCounter() {
        return counter;
    }

    /**
     * 设置默认次数
     *
     * @param counter 默认次数
     */
    public void setCounter(Integer counter) {
        this.counter = counter;
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
     * 获取状态；0-正常 1-禁用
     *
     * @return state - 状态；0-正常 1-禁用
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态；0-正常 1-禁用
     *
     * @param state 状态；0-正常 1-禁用
     */
    public void setState(String state) {
        this.state = state;
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