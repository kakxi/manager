package xft.abscloud.manager.dto;

import xft.abscloud.manager.pojo.MemberEquity;

import java.util.List;

/**
 * Created by lenovo on 2020-3-24.
 */
public class MemberEquityDto {

    private String memberId;//会员Id

    private String accountName;

    private String levelName;

    private List<MemberEquity> memberEquityList;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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
