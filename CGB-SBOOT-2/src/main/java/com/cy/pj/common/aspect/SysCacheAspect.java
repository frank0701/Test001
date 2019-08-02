package com.cy.pj.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
@Aspect
public class SysCacheAspect {
	@Pointcut("@annotation(com.cy.pj.common.annotation.RequiredCache)")
	public void fuckYouBitch() {}
	
	@Around("fuckYouBitch()")
	public Object around(ProceedingJoinPoint jp) throws Throwable{
		try {
			log.info("start:"+System.currentTimeMillis());
			Object result = jp.proceed();//调用下一个切面方法
			log.info("end:"+System.currentTimeMillis());
			return result;
		} catch (Throwable e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	
}
