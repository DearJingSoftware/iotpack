package com.iotpack.api.aop;

import com.iotpack.api.service.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class ApiLimitAspect {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    SystemService systemService;
    /**
     * api 请求限额
     * api 请求统计 超时发送 邮件提醒
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("execution(public * com.iotpack.api.controller..*.*(..))")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object o = pjp.proceed();
        Long endTime = System.currentTimeMillis();
        log.info("api:{} time:{} controller:{}", httpServletRequest.getRequestURL().toString(), endTime - startTime, pjp.toString());
        if((endTime-startTime)>3000){
            String msg="api 请求耗时过长提醒 "+httpServletRequest.getRequestURL().toString()+(endTime - startTime);
            systemService.sendMessage(msg);
        }
        return o;
    }

}
