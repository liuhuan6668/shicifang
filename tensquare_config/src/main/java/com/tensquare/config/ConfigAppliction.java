package com.tensquare.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author liuhuan
 * @date 2019-12-31
 * @描述
 */
@SpringBootApplication
@EnableConfigServer //开启配置服务
public class ConfigAppliction {
    public static void main(String[] args) {
        SpringApplication.run(ConfigAppliction.class,args);
    }
}
