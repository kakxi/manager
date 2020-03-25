package xft.abscloud.manager.service.manage;

import xft.abscloud.manager.pojo.EnterprRegUser;

import java.util.List;

/**
 * @author zhangkan
 * @date 2020-3-25 16:51
 */
public interface UserManageService {
    public void insert(EnterprRegUser record);
    public void delete(EnterprRegUser record);
    public EnterprRegUser queryByKey(Object key);
    public void update(EnterprRegUser record);
    public List<EnterprRegUser> queryList(EnterprRegUser record);

}
