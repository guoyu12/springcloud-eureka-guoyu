package com.anshark.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author GUOYU
 * @Date 2021/1/6
 * @Desc
 */
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/getMemeber")
    public String getMemeber() {
        return "";
    }


    @RequestMapping("/orderInfo")
    public String orderInfo() {
        return "订单系统端口号为 -> " + serverPort;
    }

    @RequestMapping("/getLoad")
    public String getLoad(){
        //获取服务名称为eureka-order的服务信息
        System.out.println(JSONObject.toJSONString(discoveryClient.getInstances("eureka-order")));
        //获取所有服务信息
        return JSONObject.toJSONString(discoveryClient.getServices());
    }


}
