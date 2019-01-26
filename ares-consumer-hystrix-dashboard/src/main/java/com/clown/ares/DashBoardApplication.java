package com.clown.ares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/26
 **/
@EnableHystrixDashboard
@SpringBootApplication
public class DashBoardApplication {
    public static void main(String[] args){
        SpringApplication.run(DashBoardApplication.class);
    }
}
