package com.anshark.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author GUOYU
 * @Date 2021/1/6
 * @Desc feign客户端的使用
 */
@FeignClient(name = "eureka-order")
public interface OrderFeign {

    /**
     * 请求名称与order模块中请求保持一致
     *
     * @return
     */
    @RequestMapping("/order/orderInfo")
    public String orderInfo();
}
