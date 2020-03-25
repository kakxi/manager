package xft.abscloud.manager.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "abs_member_adder")
public class AbsMemberAdder {
    /**
     * ID
     */
    @Id
    private String id;

    /**
     * 会员ID
     */
    @Column(name = "member_id")
    private String memberId;

    /**
     * 用户名
     */
    @Column(name = "account_name")
    private String accountName;

    /**
     * 状态：0:正常，1：停用
     */
    @Column(name = "user_status")
    private String userStatus;

    /**
     * 详细地址
     */
    private String adder;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取会员ID
     *
     * @return member_id - 会员ID
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * 设置会员ID
     *
     * @param memberId 会员ID
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取用户名
     *
     * @return account_name - 用户名
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 设置用户名
     *
     * @param accountName 用户名
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * 获取状态：0:正常，1：停用
     *
     * @return user_status - 状态：0:正常，1：停用
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 设置状态：0:正常，1：停用
     *
     * @param userStatus 状态：0:正常，1：停用
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 获取详细地址
     *
     * @return adder - 详细地址
     */
    public String getAdder() {
        return adder;
    }

    /**
     * 设置详细地址
     *
     * @param adder 详细地址
     */
    public void setAdder(String adder) {
        this.adder = adder;
    }

    /**
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
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

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}