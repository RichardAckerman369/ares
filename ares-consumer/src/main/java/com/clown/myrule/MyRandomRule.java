package com.clown.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: Richard·Ackerman
 * @create: 2019/1/26
 *
 * 需求:依旧是轮询策略,但是是每台机器被访问5次后,在切换为下一个服务
 *
 **/
public class MyRandomRule extends AbstractLoadBalancerRule {

    //total=0 : 定义一个计数器,当计数器==5时,我们指针才能往下走
    //index=0 : 当前对外提供服务的服务器地址
    //当index=5时,total重新置换为0,但是已经达到5次了,index=1就是下一台服务提供
    //分析: 我们规定是5次,但是服务只用3台 7777,8888,9999

    private int total = 0;          //总共被调用的次数,每台5次
    private int currentIndex =0;    //当前提供服务的机器号


    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            //获取所有的可连接服务列表
            List<Server> upList = lb.getReachableServers();

            //获取所有的服务个数
            List<Server> allList = lb.getAllServers();

            //判断服务个数是否小于0
            int serverCount = allList.size();
            if (serverCount == 0) {

                //No servers. End regardless of pass, because subsequent passes only get more restrictive.
                return null;
            }

            if(total < 5){
                server = upList.get(currentIndex);
                total++;
            }else{
                total = 0;
                currentIndex++;
                if(currentIndex >= upList.size()){
                    currentIndex = 0;
                }
            }

            //判断服务如果不存在,继续获取
            if (server == null) {

                //The only time this should happen is if the server list were somehow trimmed. This is a transient condition. Retry after yielding.
                //让出线程,将当前线程的运行状态改为就绪状态
                Thread.yield();
                continue;
            }

            //如果服务存在,返回该服务
            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        //返回服务
        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
