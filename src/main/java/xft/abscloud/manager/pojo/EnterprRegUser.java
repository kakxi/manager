package xft.abscloud.manager.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "enterpr_reg_user")
public class EnterprRegUser {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 工作邮箱
     */
    @Column(name = "enterprise_email")
    private String enterpriseEmail;

    /**
     * 用户名
     */
    @Column(name = "enterprise_account_name")
    private String enterpriseAccountName;

    /**
     * 密码
     */
    @Column(name = "enterprise_password")
    private String enterprisePassword;

    /**
     * 所属公司
     */
    @Column(name = "enterprise_name")
    private String enterpriseName;

    /**
     * 手机号码
     */
    @Column(name = "enterprise_phone")
    private String enterprisePhone;

    /**
     * 所属公司联系地址
     */
    @Column(name = "enterprise_address")
    private String enterpriseAddress;

    /**
     * 验证码
     */
    @Column(name = "enterprise_code")
    private String enterpriseCode;

    /**
     * 用户分类：1：白名单，2：黑名单，3：禁止名单
     */
    @Column(name = "suffix_status")
    private String suffixStatus;

    /**
     * 激活状态：N:未激活，Y:已激活
     */
    @Column(name = "active_status")
    private String activeStatus;

    /**
     * 激活码
     */
    @Column(name = "active_code")
    private String activeCode;

    /**
     * 注册时间
     */
    @Column(name = "reg_time")
    private Date regTime;

    /**
     * 盐值
     */
    private String id;

    /**
     * 所属机构id
     */
    private Integer orgid;

    /**
     * 用户状态：0:正常，1：停用
     */
    @Column(name = "user_status")
    private String userStatus;

    /**
     * 用户类型：0:系统管理员，1：普通用户，2：项目经理
     */
    private String usertype;

    /**
     * 姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用级别 10:匿名，11：普通，12：高级
     */
    @Column(name = "user_level")
    private String userLevel;

    /**
     * 是否需要修改密码 0：否 1：是
     */
    @Column(name = "modify_password")
    private String modifyPassword;

    /**
     * 验证码更新时间
     */
    @Column(name = "ecode_update_time")
    private Date ecodeUpdateTime;

    /**
     * 平台号
     */
    @Column(name = "platform_id")
    private String platformId;

    /**
     * 所属部门
     */
    @Column(name = "enterprise_dep")
    private String enterpriseDep;

    /**
     * 用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的
     */
    private String unionid;

    /**
     * 联系人微信号
     */
    @Column(name = "contact_wechat")
    private String contactWechat;

    /**
     * 用户注册方式 1:个人 2:机构
     */
    @Column(name = "user_reg_type")
    private Integer userRegType;

    /**
     * 推荐人
     */
    private String referee;

    /**
     * 是否关联夏金中心账号：0：无，1：有
     */
    @Column(name = "related_xj")
    private String relatedXj;

    /**
     * 夏金中心账号
     */
    @Column(name = "xj_account")
    private String xjAccount;

    /**
     * 0 代表未知，1 代表微信, 2 代表小程序
     */
    @Column(name = "bind_org_source")
    private Integer bindOrgSource;

    /**
     * 用户绑定机构时间
     */
    @Column(name = "org_bind_time")
    private Date orgBindTime;

    /**
     * 同步时间
     */
    @Column(name = "synchron_time")
    private Date synchronTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取工作邮箱
     *
     * @return enterprise_email - 工作邮箱
     */
    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    /**
     * 设置工作邮箱
     *
     * @param enterpriseEmail 工作邮箱
     */
    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail;
    }

    /**
     * 获取用户名
     *
     * @return enterprise_account_name - 用户名
     */
    public String getEnterpriseAccountName() {
        return enterpriseAccountName;
    }

    /**
     * 设置用户名
     *
     * @param enterpriseAccountName 用户名
     */
    public void setEnterpriseAccountName(String enterpriseAccountName) {
        this.enterpriseAccountName = enterpriseAccountName;
    }

    /**
     * 获取密码
     *
     * @return enterprise_password - 密码
     */
    public String getEnterprisePassword() {
        return enterprisePassword;
    }

    /**
     * 设置密码
     *
     * @param enterprisePassword 密码
     */
    public void setEnterprisePassword(String enterprisePassword) {
        this.enterprisePassword = enterprisePassword;
    }

    /**
     * 获取所属公司
     *
     * @return enterprise_name - 所属公司
     */
    public String getEnterpriseName() {
        return enterpriseName;
    }

    /**
     * 设置所属公司
     *
     * @param enterpriseName 所属公司
     */
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    /**
     * 获取手机号码
     *
     * @return enterprise_phone - 手机号码
     */
    public String getEnterprisePhone() {
        return enterprisePhone;
    }

    /**
     * 设置手机号码
     *
     * @param enterprisePhone 手机号码
     */
    public void setEnterprisePhone(String enterprisePhone) {
        this.enterprisePhone = enterprisePhone;
    }

    /**
     * 获取所属公司联系地址
     *
     * @return enterprise_address - 所属公司联系地址
     */
    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    /**
     * 设置所属公司联系地址
     *
     * @param enterpriseAddress 所属公司联系地址
     */
    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }

    /**
     * 获取验证码
     *
     * @return enterprise_code - 验证码
     */
    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    /**
     * 设置验证码
     *
     * @param enterpriseCode 验证码
     */
    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    /**
     * 获取用户分类：1：白名单，2：黑名单，3：禁止名单
     *
     * @return suffix_status - 用户分类：1：白名单，2：黑名单，3：禁止名单
     */
    public String getSuffixStatus() {
        return suffixStatus;
    }

    /**
     * 设置用户分类：1：白名单，2：黑名单，3：禁止名单
     *
     * @param suffixStatus 用户分类：1：白名单，2：黑名单，3：禁止名单
     */
    public void setSuffixStatus(String suffixStatus) {
        this.suffixStatus = suffixStatus;
    }

    /**
     * 获取激活状态：N:未激活，Y:已激活
     *
     * @return active_status - 激活状态：N:未激活，Y:已激活
     */
    public String getActiveStatus() {
        return activeStatus;
    }

    /**
     * 设置激活状态：N:未激活，Y:已激活
     *
     * @param activeStatus 激活状态：N:未激活，Y:已激活
     */
    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    /**
     * 获取激活码
     *
     * @return active_code - 激活码
     */
    public String getActiveCode() {
        return activeCode;
    }

    /**
     * 设置激活码
     *
     * @param activeCode 激活码
     */
    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    /**
     * 获取注册时间
     *
     * @return reg_time - 注册时间
     */
    public Date getRegTime() {
        return regTime;
    }

    /**
     * 设置注册时间
     *
     * @param regTime 注册时间
     */
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    /**
     * 获取盐值
     *
     * @return id - 盐值
     */
    public String getId() {
        return id;
    }

    /**
     * 设置盐值
     *
     * @param id 盐值
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取所属机构id
     *
     * @return orgid - 所属机构id
     */
    public Integer getOrgid() {
        return orgid;
    }

    /**
     * 设置所属机构id
     *
     * @param orgid 所属机构id
     */
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    /**
     * 获取用户状态：0:正常，1：停用
     *
     * @return user_status - 用户状态：0:正常，1：停用
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户状态：0:正常，1：停用
     *
     * @param userStatus 用户状态：0:正常，1：停用
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 获取用户类型：0:系统管理员，1：普通用户，2：项目经理
     *
     * @return usertype - 用户类型：0:系统管理员，1：普通用户，2：项目经理
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * 设置用户类型：0:系统管理员，1：普通用户，2：项目经理
     *
     * @param usertype 用户类型：0:系统管理员，1：普通用户，2：项目经理
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    /**
     * 获取姓名
     *
     * @return user_name - 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置姓名
     *
     * @param userName 姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用级别 10:匿名，11：普通，12：高级
     *
     * @return user_level - 用级别 10:匿名，11：普通，12：高级
     */
    public String getUserLevel() {
        return userLevel;
    }

    /**
     * 设置用级别 10:匿名，11：普通，12：高级
     *
     * @param userLevel 用级别 10:匿名，11：普通，12：高级
     */
    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * 获取是否需要修改密码 0：否 1：是
     *
     * @return modify_password - 是否需要修改密码 0：否 1：是
     */
    public String getModifyPassword() {
        return modifyPassword;
    }

    /**
     * 设置是否需要修改密码 0：否 1：是
     *
     * @param modifyPassword 是否需要修改密码 0：否 1：是
     */
    public void setModifyPassword(String modifyPassword) {
        this.modifyPassword = modifyPassword;
    }

    /**
     * 获取验证码更新时间
     *
     * @return ecode_update_time - 验证码更新时间
     */
    public Date getEcodeUpdateTime() {
        return ecodeUpdateTime;
    }

    /**
     * 设置验证码更新时间
     *
     * @param ecodeUpdateTime 验证码更新时间
     */
    public void setEcodeUpdateTime(Date ecodeUpdateTime) {
        this.ecodeUpdateTime = ecodeUpdateTime;
    }

    /**
     * 获取平台号
     *
     * @return platform_id - 平台号
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * 设置平台号
     *
     * @param platformId 平台号
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    /**
     * 获取所属部门
     *
     * @return enterprise_dep - 所属部门
     */
    public String getEnterpriseDep() {
        return enterpriseDep;
    }

    /**
     * 设置所属部门
     *
     * @param enterpriseDep 所属部门
     */
    public void setEnterpriseDep(String enterpriseDep) {
        this.enterpriseDep = enterpriseDep;
    }

    /**
     * 获取用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的
     *
     * @return unionid - 用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * 设置用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的
     *
     * @param unionid 用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * 获取联系人微信号
     *
     * @return contact_wechat - 联系人微信号
     */
    public String getContactWechat() {
        return contactWechat;
    }

    /**
     * 设置联系人微信号
     *
     * @param contactWechat 联系人微信号
     */
    public void setContactWechat(String contactWechat) {
        this.contactWechat = contactWechat;
    }

    /**
     * 获取用户注册方式 1:个人 2:机构
     *
     * @return user_reg_type - 用户注册方式 1:个人 2:机构
     */
    public Integer getUserRegType() {
        return userRegType;
    }

    /**
     * 设置用户注册方式 1:个人 2:机构
     *
     * @param userRegType 用户注册方式 1:个人 2:机构
     */
    public void setUserRegType(Integer userRegType) {
        this.userRegType = userRegType;
    }

    /**
     * 获取推荐人
     *
     * @return referee - 推荐人
     */
    public String getReferee() {
        return referee;
    }

    /**
     * 设置推荐人
     *
     * @param referee 推荐人
     */
    public void setReferee(String referee) {
        this.referee = referee;
    }

    /**
     * 获取是否关联夏金中心账号：0：无，1：有
     *
     * @return related_xj - 是否关联夏金中心账号：0：无，1：有
     */
    public String getRelatedXj() {
        return relatedXj;
    }

    /**
     * 设置是否关联夏金中心账号：0：无，1：有
     *
     * @param relatedXj 是否关联夏金中心账号：0：无，1：有
     */
    public void setRelatedXj(String relatedXj) {
        this.relatedXj = relatedXj;
    }

    /**
     * 获取夏金中心账号
     *
     * @return xj_account - 夏金中心账号
     */
    public String getXjAccount() {
        return xjAccount;
    }

    /**
     * 设置夏金中心账号
     *
     * @param xjAccount 夏金中心账号
     */
    public void setXjAccount(String xjAccount) {
        this.xjAccount = xjAccount;
    }

    /**
     * 获取0 代表未知，1 代表微信, 2 代表小程序
     *
     * @return bind_org_source - 0 代表未知，1 代表微信, 2 代表小程序
     */
    public Integer getBindOrgSource() {
        return bindOrgSource;
    }

    /**
     * 设置0 代表未知，1 代表微信, 2 代表小程序
     *
     * @param bindOrgSource 0 代表未知，1 代表微信, 2 代表小程序
     */
    public void setBindOrgSource(Integer bindOrgSource) {
        this.bindOrgSource = bindOrgSource;
    }

    /**
     * 获取用户绑定机构时间
     *
     * @return org_bind_time - 用户绑定机构时间
     */
    public Date getOrgBindTime() {
        return orgBindTime;
    }

    /**
     * 设置用户绑定机构时间
     *
     * @param orgBindTime 用户绑定机构时间
     */
    public void setOrgBindTime(Date orgBindTime) {
        this.orgBindTime = orgBindTime;
    }

    /**
     * 获取同步时间
     *
     * @return synchron_time - 同步时间
     */
    public Date getSynchronTime() {
        return synchronTime;
    }

    /**
     * 设置同步时间
     *
     * @param synchronTime 同步时间
     */
    public void setSynchronTime(Date synchronTime) {
        this.synchronTime = synchronTime;
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