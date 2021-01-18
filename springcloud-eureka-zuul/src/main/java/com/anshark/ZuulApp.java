package com.anshark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * @Author GUOYU
 * @Date 2021/1/6
 * @Desc 路由网关
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApp {

    public static void main(String[] args) {

        SpringApplication.run(ZuulApp.class, args);

    }

    /**
     * zuul配置能够使用config实现实时更新
     * @return
     */
    @RefreshScope
    @ConfigurationProperties
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }

}
