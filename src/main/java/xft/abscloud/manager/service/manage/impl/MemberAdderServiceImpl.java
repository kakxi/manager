package xft.abscloud.manager.service.manage.impl;

import org.springframework.stereotype.Service;
import xft.abscloud.manager.mapper.AbsMemberAdderMapper;
import xft.abscloud.manager.pojo.AbsMemberAdder;
import xft.abscloud.manager.service.manage.MemberAdderService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangkan
 * @date 2020-3-25 16:52
 */
@Service
public class MemberAdderServiceImpl implements MemberAdderService {

    @Resource
    private AbsMemberAdderMapper absMemberAdderMapper;

    public void  insert(AbsMemberAdder record) {
         absMemberAdderMapper.insert(record);
    }

    public void delete(AbsMemberAdder record) {
        absMemberAdderMapper.delete(record);
    }

    public AbsMemberAdder queryByKey(Object key) {
        return absMemberAdderMapper.selectByPrimaryKey(key);
    }

    public void update(AbsMemberAdder record) {
        absMemberAdderMapper.updateByPrimaryKey(record);
    }

    public List<AbsMemberAdder> queryList(AbsMemberAdder record) {
        return absMemberAdderMapper.select(record);
    }


}
