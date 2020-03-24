package xft.abscloud.manager.dto;

import xft.abscloud.manager.pojo.MemberEquity;

import java.util.List;

/**
 * Created by lenovo on 2020-3-24.
 */
public class MemberEquityDto {

    private String levelId;//会员等级Id

    private String accountName;

    private String levelName;

    private List<MemberEquity> memberEquityList;

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public List<MemberEquity> getMemberEquityList() {
        return memberEquityList;
    }

    public void setMemberEquityList(List<MemberEquity> memberEquityList) {
        this.memberEquityList = memberEquityList;
    }
}
