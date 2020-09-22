package com.lr.simplerpc.zookeeper;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xu.shijie
 * @since 2020/9/16
 */
@Configuration
@EnableConfigurationProperties(ZookeeperProperties.class)
public class ZookeeperAutoConfiguration {
    private final ZookeeperProperties zookeeperProperties;

    public ZookeeperAutoConfiguration(ZookeeperProperties zookeeperProperties) {
        this.zookeeperProperties = zookeeperProperties;
    }

    @Bean
    public ZookeeperService zookeeperService(){
        return new ZookeeperService(zookeeperProperties);
    }
}
