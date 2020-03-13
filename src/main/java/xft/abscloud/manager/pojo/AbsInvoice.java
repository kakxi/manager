package xft.abscloud.manager.pojo;

import javax.persistence.*;

@Table(name = "abs_invoice")
public class AbsInvoice {
    @Id
    @Column(name = "invoice_id")
    private Integer invoiceId;

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
     * 订单id
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 抬头类型  001-个人  002-单位
     */
    @Column(name = "invoice_type")
    private String invoiceType;

    /**
     * 发票抬头
     */
    @Column(name = "invoice_title")
    private String invoiceTitle;

    /**
     * 税号
     */
    @Column(name = "invoice_tax_num")
    private String invoiceTaxNum;

    /**
     * 开户银行
     */
    @Column(name = "bank_deposit")
    private String bankDeposit;

    /**
     * 银行账户
     */
    @Column(name = "banck_account")
    private String banckAccount;

    /**
     * 寄送地址
     */
    @Column(name = "shipping_address")
    private String shippingAddress;
    
    /**
     * 企业地址
     */
    @Column(name = "enterprise_address")
    private String enterpriseAddress;

    /**
     * 企业电话
     */
    @Column(name = "enterprise_phone")
    private String enterprisePhone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 发票状态 000-未开发票  001-已开发票
     */
    @Column(name = "invoice_status")
    private String invoiceStatus;

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
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 发票类型
     */
    @Column(name = "fp_type")
    private String fpType;
    
    
    /**
     * 发票内容
     */
    @Column(name = "invoice_content")
    private String invoiceContent;
    
    /**
     * 联系电话
     */
    @Column(name = "user_phone")
    private String userPhone;
    
    
    
    /**
     * @return invoice_id
     */
    public Integer getInvoiceId() {
        return invoiceId;
    }

    /**
     * @param invoiceId
     */
    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
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
     * 获取发票类型  001-个人或事业单位  002-企业
     *
     * @return invoice_type - 发票类型  001-个人或事业单位  002-企业
     */
    public String getInvoiceType() {
        return invoiceType;
    }

    /**
     * 设置发票类型  001-个人或事业单位  002-企业
     *
     * @param invoiceType 发票类型  001-个人或事业单位  002-企业
     */
    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    /**
     * 获取发票抬头
     *
     * @return invoice_title - 发票抬头
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * 设置发票抬头
     *
     * @param invoiceTitle 发票抬头
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    /**
     * 获取税号
     *
     * @return invoice_tax_num - 税号
     */
    public String getInvoiceTaxNum() {
        return invoiceTaxNum;
    }

    /**
     * 设置税号
     *
     * @param invoiceTaxNum 税号
     */
    public void setInvoiceTaxNum(String invoiceTaxNum) {
        this.invoiceTaxNum = invoiceTaxNum;
    }

    /**
     * 获取开户银行
     *
     * @return bank_deposit - 开户银行
     */
    public String getBankDeposit() {
        return bankDeposit;
    }

    /**
     * 设置开户银行
     *
     * @param bankDeposit 开户银行
     */
    public void setBankDeposit(String bankDeposit) {
        this.bankDeposit = bankDeposit;
    }

    /**
     * 获取银行账户
     *
     * @return banck_account - 银行账户
     */
    public String getBanckAccount() {
        return banckAccount;
    }

    /**
     * 设置银行账户
     *
     * @param banckAccount 银行账户
     */
    public void setBanckAccount(String banckAccount) {
        this.banckAccount = banckAccount;
    }

    public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
     * 获取企业地址
     *
     * @return enterprise_address - 企业地址
     */
    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    /**
     * 设置企业地址
     *
     * @param enterpriseAddress 企业地址
     */
    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }

    /**
     * 获取企业电话
     *
     * @return enterprise_phone - 企业电话
     */
    public String getEnterprisePhone() {
        return enterprisePhone;
    }

    /**
     * 设置企业电话
     *
     * @param enterprisePhone 企业电话
     */
    public void setEnterprisePhone(String enterprisePhone) {
        this.enterprisePhone = enterprisePhone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取发票状态 000-未开发票  001-已开发票
     *
     * @return invoice_status - 发票状态 000-未开发票  001-已开发票
     */
    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * 设置发票状态 000-未开发票  001-已开发票
     *
     * @param invoiceStatus 发票状态 000-未开发票  001-已开发票
     */
    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
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
    
    /**
     * 获取备注
     *
     * @return update_time - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param updateTime 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

	public String getFpType() {
		return fpType;
	}

	public void setFpType(String fpType) {
		this.fpType = fpType;
	}

	public String getInvoiceContent() {
		return invoiceContent;
	}

	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
    
    
}