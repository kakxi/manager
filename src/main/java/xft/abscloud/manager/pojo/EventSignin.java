package xft.abscloud.manager.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "abs_event_signin")
public class EventSignin {
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
     * 签到时间
     */
    @Column(name = "signin_time")
    private Date signinTime;

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
     * 获取签到时间
     *
     * @return signin_time - 签到时间
     */
    public Date getSigninTime() {
        return signinTime;
    }

    /**
     * 设置签到时间
     *
     * @param signinTime 签到时间
     */
    public void setSigninTime(Date signinTime) {
        this.signinTime = signinTime;
    }
}