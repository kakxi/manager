package xft.abscloud.manager.service.equity.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import xft.abscloud.manager.mapper.DataDictMapper;
import xft.abscloud.manager.pojo.DataDict;
import xft.abscloud.manager.service.equity.DataDictService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DataDictServiceImpl implements DataDictService {

	@Resource
	private DataDictMapper dataDictMapper;

	@Override
	public List<Map<String, String>> queryByKey(String key) {
		return dataDictMapper.selectDataDictByKey(key);
	}
	
	@Override
	public List<Map<String, String>> queryDictByKeys(List<String> ids) {
		return dataDictMapper.queryDictByKeys(ids);
	}

	@Override
	public DataDict queryDict(DataDict dataDict) {
		return dataDictMapper.queryDict(dataDict);
	}

	@Override
	public PageInfo<DataDict> queryPage(DataDict dataDict, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<DataDict> list = dataDictMapper.queryDictList(dataDict);
		PageInfo<DataDict> result = new PageInfo<>(list);
		return result;
	}

	@Override
	public int addDict(DataDict dataDict) {
		return dataDictMapper.addDict(dataDict);
	}
	
	@CacheEvict(cacheNames = "perm", key = "#dataDict.id")
	@Override
	public int updateDict(DataDict dataDict) {
		return dataDictMapper.updateDict(dataDict);
	}

	@Override
	public int deleteDict(DataDict dataDict) {
		return dataDictMapper.deleteDict(dataDict);
	}
}
