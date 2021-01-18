package com.anshark.controller;

import com.anshark.feign.OrderFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/1/6
 * @Desc @RefreshScope
 */
@RefreshScope
@RestController
@RequestMapping("/member")
public class MemeberController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderFeign orderFeign;

    private int reqCount = 1;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${config.name}")
    private String configName;

    @RequestMapping("/getOrder")
    public String getOrder() {
        String url = "http://eureka-order/order/orderInfo";
        String msg = restTemplate.getForObject(url, String.class);
        return "会员获取订单信息 -> " + msg;
    }

    @RequestMapping("/feign")
    public String feign(){
        return orderFeign.orderInfo();
    }

    /**
     * ribbon实现负载均衡  测试这种方式需要删除@LoadBalanced注解
     * @return
     */
    @RequestMapping("/ribbon")
    public String ribbon(){
        String url = getInstance() + "/member/getMember";
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * 纯手写实现负载均衡
     * @return
     */
    public synchronized String getInstance(){
        //获取远程服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client-member");
        //如果服务实例为null或者长度小于等于0
        if(instances == null || instances.size() <= 0){
            return null;
        }
        //获取服务集群个数
        int instanceSize = instances.size();
        //通过求余获取下标
        int serviceIndex = reqCount % instanceSize;
        reqCount++;
        //返回地址
        return instances.get(serviceIndex).getUri().toString();
    }

    /**
     * hystrix熔断器 如果访问不到就会返回hello方法内容
     * @return
     */
    @HystrixCommand(fallbackMethod="hello")
    @RequestMapping("/hystrix")
    public String hystrix(){
        return "order调用member -> " + orderFeign.orderInfo();
    }

    public String hello(){
        return "服务正忙 请稍后再试!";
    }

    @RequestMapping("/config")
    public String config(){
        return configName;
    }

}
