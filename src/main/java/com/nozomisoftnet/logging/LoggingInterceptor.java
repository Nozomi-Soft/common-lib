package com.nozomisoftnet.logging;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.slf4j.MDC;

import java.util.UUID;

public class LoggingInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        boolean s = super.preHandle(request, response, handler);

        MDC.put("X-transaction-id", UUID.randomUUID().toString());
        return true;

    }


}
