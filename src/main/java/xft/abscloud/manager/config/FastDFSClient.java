package xft.abscloud.manager.config;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FastDFSClient {

    @Autowired
    private FastDFSConfig fastDFSConfig;

    private TrackerClient trackerClient = null;

    @PostConstruct
    public void initMethod() {
        Properties props = new Properties();
        props.put(ClientGlobal.PROP_KEY_TRACKER_SERVERS, fastDFSConfig.getTracker_servers());                           // tracker服务器IP和端口
        props.put(ClientGlobal.PROP_KEY_CONNECT_TIMEOUT_IN_SECONDS, fastDFSConfig.getConnect_timeout_in_seconds());     // 连接tracker服务器超时时长
        props.put(ClientGlobal.PROP_KEY_NETWORK_TIMEOUT_IN_SECONDS, fastDFSConfig.getNetwork_timeout_in_seconds());     // socket连接超时时长
        props.put(ClientGlobal.PROP_KEY_CHARSET, fastDFSConfig.getCharset());                                           // 文件内容编码
        try {
            ClientGlobal.initByProperties(props);
            trackerClient = new TrackerClient();
            log.info("FastDFS Settings information :\n" + ClientGlobal.configInfo());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("FastDFSClient初始化失败：", e);
        }
    }

    /**
     * 上传文件
     *
     * @param filePathAndName 文件的磁盘路径名称 如：/Users/mac/Pictures/a.JPEG
     * @return null:失败, group path:成功
     */
    public String uploadFile(String filePathAndName) throws Exception {
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, null);
        String result = storageClient1.upload_file1(filePathAndName, null, null);
        if (null == result) {
            log.error("fdfs upload file error:" + storageClient1.getErrorCode());
        }
        return result;
    }

    /**
     * 上传文件2
     *
     * @param fileBytes   图片文件字节流
     * @param fileExtName 文件格式后缀
     * @return null:失败, group path:成功
     */
    public String uploadFile(byte[] fileBytes, String fileExtName) throws Exception {
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, null);
        String result = storageClient1.upload_file1(fileBytes, fileExtName, null);
        if (null == result) {
            log.error("fdfs upload file error:" + storageClient1.getErrorCode());
        }
        return result;
    }

    /**
     * 获取文件信息
     *
     * @param storageFilePath group1/M00/00/00/test.JPEG
     * @return null:失败
     */
    public String getFileInfo(String storageFilePath) throws Exception {
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, null);
        FileInfo fileInfo = storageClient1.get_file_info1(storageFilePath);
        if (null == fileInfo) {
            log.error("fdfs upload file error:" + storageClient1.getErrorCode());
            return null;
        }
        return fileInfo.toString();
    }


    /**
     * 下载文件(字节)
     *
     * @param storageFilePath
     * @return null:失败
     */
    public byte[] downloadFile(String storageFilePath) throws Exception {
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, null);
        byte[] fileByte = storageClient1.download_file1(storageFilePath);
        if (null == fileByte) {
            log.error("fdfs download file error:" + storageClient1.getErrorCode());
        }
        return fileByte;
    }

    /**
     * 删除文件
     *
     * @param storageFilePath group1/M00/00/00/CgEBDlujlNSABYx0AAF-SBVqisw76.JPEG"
     * @return -1:失败,  0:成功
     */
    public Integer deleteFile(String storageFilePath) throws Exception {
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, null);
        Integer result = -1;
        result = storageClient1.delete_file1(storageFilePath);
        if (-1 == result) {
            log.error("fdfs delete file error:" + storageClient1.getErrorCode());
        }
        return result;
    }

    public byte[] getFile(String filePath) throws Exception {
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient1 storageClient = new StorageClient1(trackerServer, null);
        return storageClient.download_file1(filePath);
    }

}
