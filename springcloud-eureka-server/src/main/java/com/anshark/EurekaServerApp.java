package com.anshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
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
@EnableEurekaServer
public class EurekaServerApp {

    public static void main(String[] args) {

        SpringApplication.run(EurekaServerApp.class, args);

    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
