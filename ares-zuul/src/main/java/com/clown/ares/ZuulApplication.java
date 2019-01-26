package com.clown.ares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/26
 **/
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args){
        SpringApplication.run(ZuulApplication.class);
    }
}
