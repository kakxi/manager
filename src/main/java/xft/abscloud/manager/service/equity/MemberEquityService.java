package xft.abscloud.manager.service.equity;

import com.github.pagehelper.PageInfo;
import xft.abscloud.manager.dto.MemberEquityDto;
import xft.abscloud.manager.pojo.MemberEquity;

import java.util.List;

public interface MemberEquityService {

    int add(MemberEquity memberEquity);

    int update(MemberEquity memberEquity);

    int delete(Integer memberEquityId);

    MemberEquity query(Integer memberEquityId);

    MemberEquity query(String memberId,String spendCode);

    int increaseSpendCounter(Integer memberEquityId);

    int reduceSpendCounter(Integer memberEquityId);

    // 查询单个会员的权益列表
    List<MemberEquity> queryListByMemberId(String memberId);

    // 初始化会员权益
    void initMemberEquity(String memberId, String levelId);

    // 根据消费标识查询人员列表
    List<String> queryMemberListBySpendCode(String spendCode);

    /**
     * 查询会员权益
     * @param pageNum
     * @param pageSize
     * @param accountName
     * @return
     */
    public PageInfo<MemberEquityDto> queryMemberEquityPage(Integer pageNum, Integer pageSize, String accountName);

    public void updateMemberEquity(MemberEquityDto memberEquityDto);
}
