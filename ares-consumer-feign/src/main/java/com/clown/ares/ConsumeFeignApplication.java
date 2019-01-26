package com.clown.ares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/25
 **/
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ConsumeFeignApplication {
    public static void main(String[] args){
        SpringApplication.run(ConsumeFeignApplication.class);
    }
}
