package xft.abscloud.manager.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "abs_level_equity")
public class LevelEquity {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 会员等级id
     */
    @Column(name = "level_id")
    private String levelId;

    /**
     * 权益id
     */
    @Column(name = "equity_id")
    private Integer equityId;

    /**
     * 消费次数
     */
    @Column(name = "usage_counter")
    private int usageCounter;

    /**
     * 序号
     */
    private Integer order;

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
     * 获取会员等级id
     *
     * @return level_id - 会员等级id
     */
    public String getLevelId() {
        return levelId;
    }

    /**
     * 设置会员等级id
     *
     * @param levelId 会员等级id
     */
    public void setLevelId(String levelId) {
        this.levelId = levelId;
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
     * 获取消费次数
     *
     * @return usage_counter - 消费次数
     */
    public int getUsageCounter() {
        return usageCounter;
    }

    /**
     * 设置消费次数
     *
     * @param usageCounter 消费次数
     */
    public void setUsageCounter(int usageCounter) {
        this.usageCounter = usageCounter;
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