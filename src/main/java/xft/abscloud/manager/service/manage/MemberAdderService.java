package xft.abscloud.manager.service.manage;

import xft.abscloud.manager.pojo.AbsMemberAdder;

import java.util.List;

/**
 * @author zhangkan
 * @date 2020-3-25 16:51
 */
public interface MemberAdderService {
    public void insert(AbsMemberAdder record);
    public void delete (AbsMemberAdder record);
    public AbsMemberAdder queryByKey (Object key );
    public void update(AbsMemberAdder record);
    public List<AbsMemberAdder> queryList(AbsMemberAdder record);
}
