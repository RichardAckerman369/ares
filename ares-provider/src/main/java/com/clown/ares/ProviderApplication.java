package com.clown.ares;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/25
 **/
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.clown.ares.mapper")
public class ProviderApplication {
    public static void main(String[] args){
        SpringApplication.run(ProviderApplication.class);
    }
}
