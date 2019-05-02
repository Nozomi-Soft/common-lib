package com.nozomisoft.common.logging;

import java.util.UUID;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

@Component
public class LoggingInterceptor implements AsyncHandlerInterceptor {

  @Override
  public void afterConcurrentHandlingStarted(javax.servlet.http.HttpServletRequest request,
      javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {

    MDC.put("transaction-id", UUID.randomUUID().toString());
    response.addHeader("transaction-id", MDC.get("transaction-id"));
  }

}