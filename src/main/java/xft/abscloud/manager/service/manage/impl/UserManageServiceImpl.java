package xft.abscloud.manager.service.manage.impl;

import org.springframework.stereotype.Service;
import xft.abscloud.manager.mapper.EnterprRegUserMapper;
import xft.abscloud.manager.pojo.AbsMemberUser;
import xft.abscloud.manager.pojo.EnterprRegUser;
import xft.abscloud.manager.service.manage.UserManageService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangkan
 * @date 2020-3-25 16:52
 */
@Service
public class UserManageServiceImpl implements UserManageService {

    @Resource
    private EnterprRegUserMapper enterprRegUserMapper;

    public void insert(EnterprRegUser record){
        enterprRegUserMapper.insert(record);
    }

    public void delete (EnterprRegUser record){
        enterprRegUserMapper.delete(record);
    }
    public EnterprRegUser queryByKey (Object key ){
         return enterprRegUserMapper.selectByPrimaryKey(key);
    }

    public void update(EnterprRegUser record){
        enterprRegUserMapper.updateByPrimaryKey(record);
    }

    public List<EnterprRegUser> queryList(EnterprRegUser record){
        return  enterprRegUserMapper.select(record);
    };

}
