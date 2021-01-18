package com.anshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
public class OrderApp {

    public static void main(String[] args) {

        SpringApplication.run(OrderApp.class, args);

    }

    @RequestMapping("/hello")
    String hello() {
        return "hello";
    }

}
