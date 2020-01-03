package com.tensquare.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import util.JwtUtil;

/**
 * @author liuhuan
 * @date
 * @描述
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ManagerAppliction {
    public static void main(String[] args) {
        SpringApplication.run(ManagerAppliction.class);
    }
    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
