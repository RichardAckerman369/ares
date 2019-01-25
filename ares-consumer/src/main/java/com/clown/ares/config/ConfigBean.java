package com.clown.ares.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/25
 **/
@Configuration
public class ConfigBean {

    @LoadBalanced   //此注解使用Ribbon的默认轮询负载算法
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /*@Bean           //此注解使用Ribbon的随机负载均衡,此随机算法会替代默认的轮询算法
    public IRule randomRule(){
        return new RandomRule();
    }
*/
    /*
     * 此注解使用Ribbon算法
     * 会先过滤掉由于多次访问故障而处于断路器跳闸的状态的服务,还有并发的连接数量超过阀值的服务
     * 然后对剩余的服务列表按照轮询策略进行访问
     */
    /*@Bean
    public IRule availabilityFilteringRule(){
        return new AvailabilityFilteringRule();
    }*/

    /*
     * 此注解使用Ribbon算法
     * 根据平均响应时间计算所有微服务的权重,响应时间越快权重越大,被选中的概率越高
     * 刚启动时如果统计信息不足,则使用RandomRule策略,等统计信息足够,会切换到WeightedResponseTimeRule策略
     */
    /*@Bean
    public IRule weightedResponseTimeRule(){
        return new WeightedResponseTimeRule();
    }*/

    /*
     * 此注解使用Ribbon算法
     * 先按照RandomRule的策略获取服务,如果获取服务失败则在指定的时间内会进行重试,获取可用服务
     */
    /*@Bean
    public IRule retryRule(){
        return new RetryRule();
    }*/

    /*
     * 此注解使用Ribbon算法
     * 会先过滤掉由于多次访问故障而处于断路器跳闸的状态的服务,然后选择一个并发量最小的服务
     */
    /*@Bean
    public IRule bestAvailableRule(){
        return new BestAvailableRule();
    }*/

    /*
     * 此注解使用Ribbon算法
     * 默认规则,复合判断server所在区域的性能和server的可用性选择服务器
     */
    /*@Bean
    public IRule my(){
        return new ZoneAvoidanceRule();
    }*/

    /**
     * 自定义Ribbon算法
     */
}
