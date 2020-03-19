package xft.abscloud.manager.mapper;

import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;
import xft.abscloud.manager.generator.MyMapper;
import xft.abscloud.manager.pojo.AbsFileInfo;

@Repository
public interface AbsFileInfoMapper extends MyMapper<AbsFileInfo>{

	/**
	 * 插入文件表基础表
	 * @param fileInfo
	 */
	public void add(@Param("entity")AbsFileInfo fileInfo);

}
