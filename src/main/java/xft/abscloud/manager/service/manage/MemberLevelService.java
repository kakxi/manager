package xft.abscloud.manager.service.manage;

import xft.abscloud.manager.pojo.AbsMemberLevel;

/**
 * @author zhangkan
 * @date 2020-3-25 16:51
 */
public interface MemberLevelService {
    public void insert(AbsMemberLevel record);
    public void delete(AbsMemberLevel record);
    public AbsMemberLevel queryByKey(Object key);
    public void update(AbsMemberLevel record);
}
