package xft.abscloud.manager.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "abs_member_user")
public class AbsMemberUser {
    /**
     * 会员ID
     */
    @Id
    private String id;

    /**
     * 用户名
     */
    @Column(name = "account_name")
    private String accountName;

    /**
     * 会员状态：0:正常，1：停用
     */
    @Column(name = "user_status")
    private String userStatus;

    /**
     * 会员等级
     */
    @Column(name = "member_level")
    private String memberLevel;

    /**
     * 会员开通时间
     */
    @Column(name = "member_begin_time")
    private Date memberBeginTime;

    /**
     * 会员截止时间
     */
    @Column(name = "member_end_time")
    private Date memberEndTime;

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
     * 获取会员ID
     *
     * @return id - 会员ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置会员ID
     *
     * @param id 会员ID
     */
    public void setId(String id) {
        this.id = id;
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
     * 获取会员状态：0:正常，1：停用
     *
     * @return user_status - 会员状态：0:正常，1：停用
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 设置会员状态：0:正常，1：停用
     *
     * @param userStatus 会员状态：0:正常，1：停用
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 获取会员等级
     *
     * @return member_level - 会员等级
     */
    public String getMemberLevel() {
        return memberLevel;
    }

    /**
     * 设置会员等级
     *
     * @param memberLevel 会员等级
     */
    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel;
    }

    /**
     * 获取会员开通时间
     *
     * @return member_begin_time - 会员开通时间
     */
    public Date getMemberBeginTime() {
        return memberBeginTime;
    }

    /**
     * 设置会员开通时间
     *
     * @param memberBeginTime 会员开通时间
     */
    public void setMemberBeginTime(Date memberBeginTime) {
        this.memberBeginTime = memberBeginTime;
    }

    /**
     * 获取会员截止时间
     *
     * @return member_end_time - 会员截止时间
     */
    public Date getMemberEndTime() {
        return memberEndTime;
    }

    /**
     * 设置会员截止时间
     *
     * @param memberEndTime 会员截止时间
     */
    public void setMemberEndTime(Date memberEndTime) {
        this.memberEndTime = memberEndTime;
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