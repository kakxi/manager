package xft.abscloud.manager.mapper;

import org.springframework.stereotype.Repository;
import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.DataDict;

import java.util.List;
import java.util.Map;

@Repository
public interface DataDictMapper extends MyMapper<DataDict> {

    List<Map<String,String>> selectDataDictByKey(String id);
    
    List<Map<String,String>> queryDictByKeys(List<String> ids);
    
    List<DataDict> queryAllDictList();
    
    List<DataDict> queryDictList(DataDict dataDict);
    
    DataDict queryDict(DataDict dataDict);
    
    int addDict(DataDict dataDict);
    
    int updateDict(DataDict dataDict);
    
    int deleteDict(DataDict dataDict);

    /**
     * 查询功能模块
     * @return
     */
    public List<Map<String,String>> queryModelList();
}