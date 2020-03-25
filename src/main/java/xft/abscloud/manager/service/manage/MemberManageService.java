package xft.abscloud.manager.service.manage;

import xft.abscloud.manager.pojo.AbsMemberUser;

import java.util.List;

/**
 * @author zhangkan
 * @date 2020-3-25 16:51
 */
public interface MemberManageService {
    public void insert(AbsMemberUser record);
    public void delete(AbsMemberUser record);
    public AbsMemberUser queryByKey(Object key);
    public void update(AbsMemberUser record);
    public List<AbsMemberUser> queryList(AbsMemberUser record);
}
