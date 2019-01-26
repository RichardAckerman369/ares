package com.clown.ares;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/25
 *
 * 只为验证断路器的应用
 *
 **/
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("com.clown.ares.mapper")
@SpringBootApplication
public class ProviderHystrixApplication {
    public static void main(String[] args){
        SpringApplication.run(ProviderHystrixApplication.class);
    }
}
