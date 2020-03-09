package xft.abscloud.manager.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "abs_equity_spend")
public class EquitySpend {
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
     * 活动id
     */
    @Column(name = "event_id")
    private Integer eventId;

    /**
     * 权益id
     */
    @Column(name = "equity_id")
    private Integer equityId;

    /**
     * 权益名称
     */
    @Column(name = "equity_name")
    private String equityName;

    /**
     * 状态：已完成0，已取消1
     */
    private String status;

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
     * 获取活动id
     *
     * @return event_id - 活动id
     */
    public Integer getEventId() {
        return eventId;
    }

    /**
     * 设置活动id
     *
     * @param eventId 活动id
     */
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    /**
     * 获取权益id
     *
     * @return equity_id - 权益id
     */
    public Integer getEquityId() {
        return equityId;
    }

    /**
     * 设置权益id
     *
     * @param equityId 权益id
     */
    public void setEquityId(Integer equityId) {
        this.equityId = equityId;
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
     * 获取状态：已完成0，已取消1
     *
     * @return status - 状态：已完成0，已取消1
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态：已完成0，已取消1
     *
     * @param status 状态：已完成0，已取消1
     */
    public void setStatus(String status) {
        this.status = status;
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