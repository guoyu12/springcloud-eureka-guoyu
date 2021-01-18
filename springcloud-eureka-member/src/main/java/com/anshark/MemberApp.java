package com.anshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author GUOYU
 * @Date 2021/1/6
 * @Desc
 */
@SpringBootApplication
@RestController
@RequestMapping("/app")
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class MemberApp {

    public static void main(String[] args) {

        SpringApplication.run(MemberApp.class, args);

    }

    @RequestMapping("/hello")
    String hello(){
        return "hello";
    }

}
