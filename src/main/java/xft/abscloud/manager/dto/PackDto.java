package xft.abscloud.manager.dto;

import lombok.Getter;
import lombok.Setter;
import xft.abscloud.manager.pojo.LevelEquity;

import java.util.List;

/**
 * 套餐信息
 */
@Setter
@Getter
public class PackDto {

    /**
     * 会员等级id
     */
    private String levelId;

    /**
     * 权益列表
     */
    private List<LevelEquity> equityList;


}
