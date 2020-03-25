package xft.abscloud.manager.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "abs_member_level")
public class AbsMemberLevel {
    /**
     * ID
     */
    @Id
    private String id;

    /**
     * 等级名称
     */
    @Column(name = "level_name")
    private String levelName;

    /**
     * 会员等级
     */
    @Column(name = "member_level")
    private String memberLevel;

    /**
     * 会员价格
     */
    @Column(name = "member_money")
    private String memberMoney;

    /**
     * 会员权限信息
     */
    @Column(name = "member_info")
    private String memberInfo;

    /**
     * 会员有效时间
     */
    @Column(name = "member_valid_time")
    private Date memberValidTime;

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
     * 获取等级名称
     *
     * @return level_name - 等级名称
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * 设置等级名称
     *
     * @param levelName 等级名称
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
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
     * 获取会员价格
     *
     * @return member_money - 会员价格
     */
    public String getMemberMoney() {
        return memberMoney;
    }

    /**
     * 设置会员价格
     *
     * @param memberMoney 会员价格
     */
    public void setMemberMoney(String memberMoney) {
        this.memberMoney = memberMoney;
    }

    /**
     * 获取会员权限信息
     *
     * @return member_info - 会员权限信息
     */
    public String getMemberInfo() {
        return memberInfo;
    }

    /**
     * 设置会员权限信息
     *
     * @param memberInfo 会员权限信息
     */
    public void setMemberInfo(String memberInfo) {
        this.memberInfo = memberInfo;
    }

    /**
     * 获取会员有效时间
     *
     * @return member_valid_time - 会员有效时间
     */
    public Date getMemberValidTime() {
        return memberValidTime;
    }

    /**
     * 设置会员有效时间
     *
     * @param memberValidTime 会员有效时间
     */
    public void setMemberValidTime(Date memberValidTime) {
        this.memberValidTime = memberValidTime;
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