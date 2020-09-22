package com.lr.simplerpc.server.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xu.shijie
 * @since 2020/9/18
 */
@Configuration
@EnableConfigurationProperties(ServerProperties.class)
public class ServerAutoConfiguration {
    @Bean
    public ServerService serverService(){
        return new ServerService();
    }
}
