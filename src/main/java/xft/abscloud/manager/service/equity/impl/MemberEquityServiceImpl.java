package xft.abscloud.manager.service.equity.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xft.abscloud.manager.dto.MemberEquityDto;
import xft.abscloud.manager.mapper.MemberEquityMapper;
import xft.abscloud.manager.pojo.MemberEquity;
import xft.abscloud.manager.service.equity.LevelEquityService;
import xft.abscloud.manager.service.equity.MemberEquityService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MemberEquityServiceImpl implements MemberEquityService {

    @Resource
    private MemberEquityMapper memberEquityMapper;

    @Resource
    private LevelEquityService levelEquityService;

    @Override
    public int add(MemberEquity memberEquity) {
        return memberEquityMapper.add(memberEquity);
    }

    @Override
    public int update(MemberEquity memberEquity) {
        return memberEquityMapper.update(memberEquity);
    }

    @Override
    public int delete(Integer memberEquityId) {
        return memberEquityMapper.deleteByPrimaryKey(memberEquityId);
    }

    @Override
    public MemberEquity query(Integer memberEquityId) {
        return memberEquityMapper.query(memberEquityId);
    }

    @Override
    public MemberEquity query(String memberId, String spendCode) {
        return memberEquityMapper.queryByMemberIdAndSpendCode(memberId, spendCode);
    }

    /**
     * 增加消费次数 1
     *
     * @param memberEquityId
     * @return
     */
    @Override
    public int increaseSpendCounter(Integer memberEquityId) {
        return memberEquityMapper.updateBalanceCounter(memberEquityId, 1);
    }

    /**
     * 减少消费次数 1
     *
     * @param memberEquityId
     * @return
     */
    @Override
    public int reduceSpendCounter(Integer memberEquityId) {
        return memberEquityMapper.updateBalanceCounter(memberEquityId, -1);
    }

    @Override
    public List<MemberEquity> queryListByMemberId(String memberId) {
        return memberEquityMapper.queryListByMemberId(memberId);
    }

    /**
     * 初始化会员的权益列表，（在支付成功时调用）
     *
     * @param memberId
     * @param levelId
     */
    @Override
    public void initMemberEquity(String memberId, String levelId) {
        // 根据等级id查询权益列表
        List<Map<String, Object>> list = levelEquityService.query(levelId);
        List<MemberEquity> memberEquityList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            MemberEquity memberEquity = BeanUtil.mapToBean(map, MemberEquity.class, true);
            memberEquity.setMemberId(memberId);
            memberEquity.setBalanceCounter(memberEquity.getUsageCounter());
            memberEquityList.add(memberEquity);
        }
        memberEquityMapper.insertForeach(memberEquityList);
    }

    /**
     * 查询拥有指定消费标识的会员列表
     *
     * @param spendCode
     * @return
     */
    @Override
    public List<String> queryMemberListBySpendCode(String spendCode) {
        return memberEquityMapper.queryMemberListBySpendCode(spendCode);
    }

    @Override
    public PageInfo<MemberEquityDto> queryMemberEquityPage(Integer pageNum, Integer pageSize, String accountName) {

        PageHelper.startPage(pageNum, pageSize);
        List<MemberEquityDto> absMemberUsers = memberEquityMapper.queryAllMember(accountName);
        PageInfo<MemberEquityDto> pageInfo = new PageInfo<>(absMemberUsers);
        List<MemberEquityDto> memberEquityDtos = new ArrayList<>();
        for(MemberEquityDto memberUser : absMemberUsers){
            String memberId = memberUser.getMemberId();
            List<MemberEquity> equityVoList = memberEquityMapper.queryListByMemberId(memberId);
            memberUser.setMemberEquityList(equityVoList);
            memberEquityDtos.add(memberUser);
        }

        return pageInfo;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void updateMemberEquity(MemberEquityDto memberEquityDto) {

        String memberId = memberEquityDto.getMemberId();
        //先删除
        memberEquityMapper.deleteMemberEquityById(memberId);
        List<MemberEquity> memberEquityList = memberEquityDto.getMemberEquityList();
        if(memberEquityList.size()>0 || memberEquityList != null){
            //再插入
            memberEquityMapper.insertForeach(memberEquityList);
        }

    }
}
