package xft.abscloud.manager.dto;

import java.util.List;

/**
 * Created by lenovo on 2020-3-20.
 */
public class PackEquityDto {

    private String levelId;//会员等级Id

    private String levelName;//会员等级名称

    private List<EquityVo> equityVoList;


    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public List<EquityVo> getEquityVoList() {
        return equityVoList;
    }

    public void setEquityVoList(List<EquityVo> equityVoList) {
        this.equityVoList = equityVoList;
    }
}
