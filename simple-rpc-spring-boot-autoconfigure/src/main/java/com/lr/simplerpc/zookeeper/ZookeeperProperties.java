package com.lr.simplerpc.zookeeper;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xu.shijie
 * @since 2020/9/16
 */
@ConfigurationProperties(prefix = "rpc.registry")
public class ZookeeperProperties {
    private String ip;
    private Integer port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getIpAddress() {
        return ip + ":" + port;
    }
}
