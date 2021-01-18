package com.anshark.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author GUOYU
 * @Date 2021/1/6
 * @Desc Zuul过滤器
 */
@Component
public class CustomerZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder：通过int值来定义过滤器的执行顺序，数值越小优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行。过滤的核心条件
     */
    @Override
    public boolean shouldFilter() {
        // 获取请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        // 获取到request
        HttpServletRequest request = context.getRequest();
        System.out.println("当前请求 -> " + request.getRequestURI());
        return true;
    }

    /**
     * 过滤后执行的方法
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("已通过过滤");
        return null;
    }
}
