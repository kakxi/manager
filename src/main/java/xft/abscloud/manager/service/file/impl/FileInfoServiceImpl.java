package xft.abscloud.manager.service.file.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import xft.abscloud.manager.config.FastDFSClient;
import xft.abscloud.manager.mapper.AbsFileInfoMapper;
import xft.abscloud.manager.pojo.AbsFileInfo;
import xft.abscloud.manager.service.file.FileInfoService;
import xft.abscloud.manager.util.OrderUtil;

@Service
public class FileInfoServiceImpl implements FileInfoService{

	@Autowired
    private FastDFSClient fastDFSClient;

    @Autowired
    private AbsFileInfoMapper fileInfoMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public AbsFileInfo uploadFile(byte[] bs, AbsFileInfo fileInfo) throws Exception {
        // 上传文件到文服
        String result = fastDFSClient.uploadFile(bs, fileInfo.getFileSuffix());
        fileInfo.setFileUrl(result);
        fileInfoMapper.add(fileInfo);
        return fileInfo;
    }

    @Override
    public Long uploadFile(MultipartFile file) throws Exception {
        AbsFileInfo fileInfo2 = uploadFile2(file);
        return fileInfo2.getFileId();
    }

    @Override
    public AbsFileInfo uploadFile2(MultipartFile file) throws Exception {
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf(".") + 1);
        // 提取文档属性信息
        long fileSize = file.getSize();
        if (fileSize <= 0) {
            throw new Exception("文件内容为空，请确认后再上传！");
        }
        AbsFileInfo fileInfo = new AbsFileInfo();
        fileInfo.setFileSize(fileSize + "");
        fileInfo.setFileName(filename);
        fileInfo.setFileSuffix(suffix);
        fileInfo.setCreateTime(OrderUtil.getCurrentTime());
        fileInfo.setCreatePerson(null);
        byte[] bs = file.getBytes();
        AbsFileInfo fileInfo2 = uploadFile(bs, fileInfo);
        return fileInfo2;
    }

    @Override
    public byte[] getFile(String fileId) throws Exception {
        return new byte[0];
    }

    @Override
    public AbsFileInfo getFile(Long fileId) throws Exception {
        AbsFileInfo fileInfo = fileInfoMapper.selectByPrimaryKey(fileId);
        return fileInfo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteFile(Long fileId) throws Exception {
        AbsFileInfo fileInfo = fileInfoMapper.selectByPrimaryKey(fileId);
        if (fileInfo != null) {
            // 删除文件表信息
            fileInfoMapper.deleteByPrimaryKey(fileId);
            // 删除文服上的文件
            fastDFSClient.deleteFile(fileInfo.getFileUrl());
        }
    }
}
