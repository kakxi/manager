package xft.abscloud.manager.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

@Table(name = "abs_event")
public class Event {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 活动主题
     */
    @Column(name = "event_name")
    private String eventName;

    /**
     * 活动时间
     */
    @Column(name = "event_date")
    private String eventDate;

    /**
     * 活动地点
     */
    @Column(name = "event_address")
    private String eventAddress;

    /**
     * 活动链接
     */
    @Column(name = "event_url")
    private String eventUrl;

    /**
     * 人数限制
     */
    @Column(name = "num_limit")
    private Integer numLimit;

    /**
     * 已预约人数
     */
    @Column(name = "num_used")
    private Integer numUsed;

    /**
     * 预约截止日
     */
    @Column(name = "reserve_end_date")
    private String reserveEndDate;

    /**
     * 取消截止日
     */
    @Column(name = "cancel_end_date")
    private String cancelEndDate;

    /**
     * 是否限定权益：0否，1是
     */
    @Column(name = "need_equity")
    private String needEquity;

    /**
     * 消费标识
     */
    @Column(name = "spend_code")
    private String spendCode;

    /**
     * 状态；1已发布，0未发布，2已取消，4已完成
     */
    private String status;

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
     * 活动介绍
     */
    @Column(name = "event_desc")
    private String eventDesc;

    @Getter
    @Setter
    @Transient
    private String eventDateStart;

    @Getter
    @Setter
    @Transient
    private String eventDateEnd;

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
     * 获取活动主题
     *
     * @return event_name - 活动主题
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * 设置活动主题
     *
     * @param eventName 活动主题
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * 获取活动时间
     *
     * @return event_date - 活动时间
     */
    public String getEventDate() {
        return eventDate;
    }

    /**
     * 设置活动时间
     *
     * @param eventDate 活动时间
     */
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * 获取活动地点
     *
     * @return event_address - 活动地点
     */
    public String getEventAddress() {
        return eventAddress;
    }

    /**
     * 设置活动地点
     *
     * @param eventAddress 活动地点
     */
    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    /**
     * 获取活动链接
     *
     * @return event_url - 活动链接
     */
    public String getEventUrl() {
        return eventUrl;
    }

    /**
     * 设置活动链接
     *
     * @param eventUrl 活动链接
     */
    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    /**
     * 获取人数限制
     *
     * @return num_limit - 人数限制
     */
    public Integer getNumLimit() {
        return numLimit;
    }

    /**
     * 设置人数限制
     *
     * @param numLimit 人数限制
     */
    public void setNumLimit(Integer numLimit) {
        this.numLimit = numLimit;
    }

    /**
     * 获取已预约人数
     *
     * @return num_used - 已预约人数
     */
    public Integer getNumUsed() {
        return numUsed;
    }

    /**
     * 设置已预约人数
     *
     * @param numUsed 已预约人数
     */
    public void setNumUsed(Integer numUsed) {
        this.numUsed = numUsed;
    }

    /**
     * 获取预约截止日
     *
     * @return reserve_end_date - 预约截止日
     */
    public String getReserveEndDate() {
        return reserveEndDate;
    }

    /**
     * 设置预约截止日
     *
     * @param reserveEndDate 预约截止日
     */
    public void setReserveEndDate(String reserveEndDate) {
        this.reserveEndDate = reserveEndDate;
    }

    /**
     * 获取取消截止日
     *
     * @return cancel_end_date - 取消截止日
     */
    public String getCancelEndDate() {
        return cancelEndDate;
    }

    /**
     * 设置取消截止日
     *
     * @param cancelEndDate 取消截止日
     */
    public void setCancelEndDate(String cancelEndDate) {
        this.cancelEndDate = cancelEndDate;
    }

    /**
     * 获取是否限定权益：0否，1是
     *
     * @return need_equity - 是否限定权益：0否，1是
     */
    public String getNeedEquity() {
        return needEquity;
    }

    /**
     * 设置是否限定权益：0否，1是
     *
     * @param needEquity 是否限定权益：0否，1是
     */
    public void setNeedEquity(String needEquity) {
        this.needEquity = needEquity;
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
     * 获取状态；1已发布，0未发布，2已取消，4已完成
     *
     * @return status - 状态；1已发布，0未发布，2已取消，4已完成
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态；1已发布，0未发布，2已取消，4已完成
     *
     * @param status 状态；1已发布，0未发布，2已取消，4已完成
     */
    public void setStatus(String status) {
        this.status = status;
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

    /**
     * 获取活动介绍
     *
     * @return event_desc - 活动介绍
     */
    public String getEventDesc() {
        return eventDesc;
    }

    /**
     * 设置活动介绍
     *
     * @param eventDesc 活动介绍
     */
    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }
}