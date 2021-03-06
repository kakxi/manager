package xft.abscloud.manager.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConfigurationProperties(prefix = "fastdfs.properties")
public class FastDFSConfig {
    private static final Logger log = LoggerFactory.getLogger(FastDFSConfig.class);

    private String connect_timeout_in_seconds;      // 连接tracker服务器超时时长
    private String network_timeout_in_seconds;      // socket连接超时时长
    private String charset;                         // 文件内容编码
    private String tracker_servers;                 // tracker服务器IP和端口

    @PostConstruct
    public void initMethod() {
        log.info("------------------ 文件服务器配置值读取完毕 BEGIN ------------------");
        log.info("connect_timeout_in_seconds is :" + connect_timeout_in_seconds);
        log.info("network_timeout_in_seconds is :" + network_timeout_in_seconds);
        log.info("charset is :" + charset);
        log.info("tracker_servers is :" + tracker_servers);
        log.info("------------------ 文件服务器配置值读取完毕 END   ------------------");
    }

    public String getConnect_timeout_in_seconds() {
        return connect_timeout_in_seconds;
    }

    public void setConnect_timeout_in_seconds(String connect_timeout_in_seconds) {
        this.connect_timeout_in_seconds = connect_timeout_in_seconds;
    }

    public String getNetwork_timeout_in_seconds() {
        return network_timeout_in_seconds;
    }

    public void setNetwork_timeout_in_seconds(String network_timeout_in_seconds) {
        this.network_timeout_in_seconds = network_timeout_in_seconds;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getTracker_servers() {
        return tracker_servers;
    }

    public void setTracker_servers(String tracker_servers) {
        this.tracker_servers = tracker_servers;
    }
}
