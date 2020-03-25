package xft.abscloud.manager.service.equity;

import com.github.pagehelper.PageInfo;
import xft.abscloud.manager.pojo.DataDict;

import java.util.List;
import java.util.Map;

public interface DataDictService {
	
    public List<Map<String,String>> queryByKey(String key);
    
    DataDict queryDict(DataDict dataDict);
    
    PageInfo<DataDict> queryPage(DataDict dataDict, int pageNum, int pageSize);
    
    int addDict(DataDict dataDict);
    
    int updateDict(DataDict dataDict);
    
    int deleteDict(DataDict dataDict);
    
	/**
	 * 查询：数据字典（批量）
	 * @author ligaopeng
	 * @date 2019年7月1日
	 * @param ids
	 * @return
	 */
	List<Map<String, String>> queryDictByKeys(List<String> ids);

    public List<Map<String,String>> queryModelList();
}
