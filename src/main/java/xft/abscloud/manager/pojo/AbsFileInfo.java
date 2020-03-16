package xft.abscloud.manager.pojo;

import javax.persistence.*;

@Table(name = "abs_file_info")
public class AbsFileInfo {
    /**
     * 文件ID
     */
    @Id
    @Column(name = "ID")
    private Long fileId;

    /**
     * 文档名称
     */
    @Column(name = "FILE_NAME")
    private String fileName;

    /**
     * 文档保存路径
     */
    @Column(name = "FILE_URL")
    private String fileUrl;

    /**
     * 文档后缀名
     */
    @Column(name = "FILE_SUFFIX")
    private String fileSuffix;

    /**
     * 文档大小
     */
    @Column(name = "FILE_SIZE")
    private String fileSize;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private String createTime;

    /**
     * 创建人员
     */
    @Column(name = "CREATE_USER")
    private String createUser;

    /**
     * 获取文件ID
     *
     * @return fileId - 文件ID
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * 设置文件ID
     *
     * @param fileId 文件ID
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * 获取文档名称
     *
     * @return FILE_NAME - 文档名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置文档名称
     *
     * @param fileName 文档名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取文档保存路径
     *
     * @return FILE_URL - 文档保存路径
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 设置文档保存路径
     *
     * @param fileUrl 文档保存路径
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * 获取文档后缀名
     *
     * @return FILE_SUFFIX - 文档后缀名
     */
    public String getFileSuffix() {
        return fileSuffix;
    }

    /**
     * 设置文档后缀名
     *
     * @param fileSuffix 文档后缀名
     */
    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    /**
     * 获取文档大小
     *
     * @return FILE_SIZE - 文档大小
     */
    public String getFileSize() {
        return fileSize;
    }

    /**
     * 设置文档大小
     *
     * @param fileSize 文档大小
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人员
     *
     * @return CREATE_PERSON - 创建人员
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人员
     *
     * @param createPerson 创建人员
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}