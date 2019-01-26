package com.clown.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/26
 *
 * 自定义调用规则,注意此配置类所在的路径,配置类不能放在启动类的同包及其子包下
 *
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
//        return new RandomRule();
//        return new RoundRobinRule();
        return new MyRandomRule(); //自定义的Rule,每台机器5次
    }
}
