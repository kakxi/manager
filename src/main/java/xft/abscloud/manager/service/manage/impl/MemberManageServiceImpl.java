package xft.abscloud.manager.service.manage.impl;

import org.springframework.stereotype.Service;
import xft.abscloud.manager.mapper.AbsMemberUserMapper;
import xft.abscloud.manager.pojo.AbsMemberUser;
import xft.abscloud.manager.service.manage.MemberManageService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangkan
 * @date 2020-3-25 16:52
 */
@Service
public class MemberManageServiceImpl implements MemberManageService {

    @Resource
    private AbsMemberUserMapper absMemberUserMapper;

    public void insert(AbsMemberUser record){
        absMemberUserMapper.insert(record);
    }

    public void delete (AbsMemberUser record){
        absMemberUserMapper.delete(record);
    }
    public AbsMemberUser queryByKey (Object key ){
        return absMemberUserMapper.selectByPrimaryKey(key);
    }

    public void update(AbsMemberUser record){
        absMemberUserMapper.updateByPrimaryKey(record);
    }

    public List<AbsMemberUser> queryList(AbsMemberUser record){
       return  absMemberUserMapper.select(record);
    };
}
