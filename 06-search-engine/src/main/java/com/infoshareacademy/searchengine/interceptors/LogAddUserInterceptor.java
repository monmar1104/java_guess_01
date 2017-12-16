package com.infoshareacademy.searchengine.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogAddUserInterceptor {
    Logger logger = LogManager.getLogger(LogAddUserInterceptor.class.getName());
    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        logger.info("Add user has been invoked!");
        return context.proceed();
    }
}

