package com.anshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author GUOYU
 * @Date 2021/1/6
 * @Desc 配置中服务端
 */
@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApp {

    public static void main(String[] args) {

        SpringApplication.run(ConfigServerApp.class, args);

    }
}
