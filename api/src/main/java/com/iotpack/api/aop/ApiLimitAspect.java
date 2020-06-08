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
     * api TODO 请求限额
     * api TODO 请求统计 超时发送 邮件提醒
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("execution(public * com.iotpack.api.controller..*.*(..))")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object o = pjp.proceed();
        Long endTime = System.currentTimeMillis();
        if((endTime-startTime)>3000){
            log.info("api:{} time:{} controller:{}", httpServletRequest.getRequestURL().toString(), endTime - startTime, pjp.toString());
            String msg="api 请求耗时预警提醒 "+httpServletRequest.getRequestURL().toString()+" "+(endTime - startTime);
            systemService.sendMessage(msg);
        }

        if((endTime-startTime)>5000){
            log.info("api:{} time:{} controller:{}", httpServletRequest.getRequestURL().toString(), endTime - startTime, pjp.toString());
            String msg="api 请求耗时提醒 "+httpServletRequest.getRequestURL().toString()+" "+(endTime - startTime);
            systemService.sendMessage(msg);
        }

        if((endTime-startTime)>10000){
            log.info("api:{} time:{} controller:{}", httpServletRequest.getRequestURL().toString(), endTime - startTime, pjp.toString());
            String msg="api 请求耗时超时提醒 "+httpServletRequest.getRequestURL().toString()+" "+(endTime - startTime);
            systemService.sendMessage(msg);
        }
        return o;
    }

}
