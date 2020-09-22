package com.lr.simplerpc.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xu.shijie
 * @since 2020/9/18
 */
@ConfigurationProperties(prefix = "rpc.server")
public class ServerProperties {
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
}
