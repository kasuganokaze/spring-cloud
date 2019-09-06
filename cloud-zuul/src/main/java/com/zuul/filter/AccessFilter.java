package com.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kaze 2017/10/28
 */
@Component
@Slf4j
public class AccessFilter extends ZuulFilter {

    private static final String POST = "post";
    private static final String URI = "/login";

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("send {} request to {}", request.getMethod(), request.getRequestURL());
        String method = request.getMethod();
        String uri = request.getRequestURI();
        //如果是登录操作，则不判断是否有token
        if (POST.equals(method.toLowerCase()) && uri.endsWith(URI)) {
            return null;
        }
        String accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
        } else {
            log.info("access token ok");
        }
        return null;
    }

}