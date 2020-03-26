package xft.abscloud.manager.service.manage.impl;

import org.springframework.stereotype.Service;
import xft.abscloud.manager.mapper.AbsMemberLevelMapper;
import xft.abscloud.manager.pojo.AbsMemberLevel;
import xft.abscloud.manager.service.manage.MemberLevelService;

import javax.annotation.Resource;

/**
 * @author zhangkan
 * @date 2020-3-25 17:47
 */
@Service
public class MemberLevelServiceImpl implements MemberLevelService {
    @Resource
    private AbsMemberLevelMapper absMemberLevelMapper;

    public void insert(AbsMemberLevel record){
        absMemberLevelMapper.insert(record);
    }

    public void delete (AbsMemberLevel record){
        absMemberLevelMapper.delete(record);
    }

    public AbsMemberLevel queryByKey (Object key ){
        return absMemberLevelMapper.selectByPrimaryKey(key);
    }

    public void update(AbsMemberLevel record){
        absMemberLevelMapper.updateByPrimaryKey(record);
    }
}
