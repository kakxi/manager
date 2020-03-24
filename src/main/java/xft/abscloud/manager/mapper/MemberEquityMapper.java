package xft.abscloud.manager.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import xft.abscloud.manager.dto.MemberEquityDto;
import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.MemberEquity;

import java.util.List;

@Repository
public interface MemberEquityMapper extends MyMapper<MemberEquity> {

    int add(MemberEquity memberEquity);

    int update(MemberEquity memberEquity);

    int insertForeach(List<MemberEquity> list);

    MemberEquity queryByMemberIdAndSpendCode(@Param("memberId") String memberId, @Param("spendCode") String spendCode);

    int updateBalanceCounter(@Param("id") Integer id,@Param("count") Integer count);

    // 活动取消时，批量更新会员权益的消费次数 +1
    int updateBalanceCounterForCancelEvent(Integer eventId);

    // 查询单个会员的权益列表
    List<MemberEquity> queryListByMemberId(String memberId);

    // 根据消费标识查询人员列表
    List<String> queryMemberListBySpendCode(String spendCode);

    MemberEquity query(Integer id);

    public List<MemberEquityDto> queryAllMember(@Param("accountName") String accountName);

    /**
     * 删除会员权益
     * @param memberId
     */
    public void deleteMemberEquityById(@Param("memberId") String memberId);
}