package com.clown.ares;

import com.clown.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/25
 **/
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "ARES-PROVIDER",configuration = MySelfRule.class)
public class ConsumeApplication {
    public static void main(String[] args){
        SpringApplication.run(ConsumeApplication.class);
    }
}
