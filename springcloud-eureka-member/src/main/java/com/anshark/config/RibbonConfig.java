package com.anshark.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author GUOYU
 * @Date 2021/1/6
 * @Desc
 */
@Configuration
public class RibbonConfig {

    /**
     * @return
     * @LoadBalanced 开启负载均衡
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
