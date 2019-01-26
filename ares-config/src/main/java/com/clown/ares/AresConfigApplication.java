package com.clown.ares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/26
 **/
@EnableConfigServer
@SpringBootApplication
public class AresConfigApplication {
    public static void main(String[] args){
        SpringApplication.run(AresConfigApplication.class);
    }
}
