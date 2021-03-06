package com.my.config;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by wt on 2017/11/21.
 */
@Aspect
@Component
public class WebLogAspect {
    private static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.my.controller.*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void printActionMsg(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Map map = request.getParameterMap();
        StringBuilder sb = new StringBuilder();
        Iterator iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            Object obj = iterator.next();
            sb.append(obj).append("=").append(request.getParameter(obj.toString())).append("&");
        }

        logger.info(request.getRequestURL().toString() + "?" + sb.toString());
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        logger.info("耗时: {}毫秒",(System.currentTimeMillis() - startTime.get()));
        logger.info("RESPONSE : " + JSON.toJSONString(ret));
    }
}
