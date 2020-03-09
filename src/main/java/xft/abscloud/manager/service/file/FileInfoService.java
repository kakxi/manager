package xft.abscloud.manager.service.file;

import org.springframework.web.multipart.MultipartFile;

import xft.abscloud.manager.pojo.AbsFileInfo;

public interface FileInfoService {

	/**
	 * 上传文件
     * @param bs
     * @param fileInfo
     * @return
     * @throws Exception
     */
    public AbsFileInfo uploadFile(byte[] bs, AbsFileInfo fileInfo) throws Exception;

    /**
     * 上传文件
     * @param file
     * @return
     * @throws Exception
     */
    public Long uploadFile(MultipartFile file) throws Exception;

    public AbsFileInfo uploadFile2(MultipartFile file) throws Exception;


    /**
     * 获取文件内容
     * @param fileId
     * @return
     * @throws Exception
     */
    public  byte[] getFile(String fileId) throws Exception;

    public AbsFileInfo getFile(Long fileId) throws Exception;

    public void deleteFile(Long fileId) throws Exception;
}
