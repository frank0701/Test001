package com.cy.pj.common.aspect;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
/**
 * @Aspect 描述的类为一个切面类对象
 * 1)切入点(切入扩展功能的点)
 * 2)通知(扩展功能)
 */
@Order(2)
@Aspect
@Service
@Slf4j
public class SysLogAspect {
	 /**
	  * @Pointcut注解用于定义切入点
	  * bean表达式为切入点表达式,
	  * bean表达式内部指定的bean对象中
	    *   所有方法为切入点(进行功能扩展的点)
	  */
	 @Pointcut("bean(*ServiceImpl)")
	 public void logPointCut() {}
	 /**
	  * @Around 描述的方法为环绕通知,用于功能增强
	    *   环绕通知(目标方法执行之前和之后都可以执行)
	  * @param jp 连接点 (封装了要执行的目标方法信息)
	  * @return 目标方法的执行结果
	  * @throws Throwable
	  */
	 @Around("logPointCut()")
	 public Object around(ProceedingJoinPoint jp)
	 throws Throwable{
		 try {
		   long t1=System.currentTimeMillis();
		   log.info("start:"+t1);
		   Object result=jp.proceed();//调用下一个切面方法或目标方法
		   long t2=System.currentTimeMillis();
		   log.info("after:"+t2);
		   saveObject(jp,(t2-t1));
		   return result;
		 }catch(Throwable e) {
		   log.error(e.getMessage());
		   throw e;
		 }
	 }
	 @Autowired
	 private SysLogDao sysLogDao;
	 //????
	 private void saveObject(ProceedingJoinPoint jp,long time) throws JsonProcessingException {
		 //1.获取用户行为信息
		 //???????
		 Class<? extends Object> targetClass = jp.getTarget().getClass();
		 String classNameString = targetClass.getName();
		 String methodName = jp.getSignature().getName();
		 String method = classNameString+"."+methodName;
		 //2.封装用户行为信息
		 SysLog log=new SysLog();
		 log.setIp("192.168.1.100");
		 log.setUsername("admin");
		 log.setMethod(method);//类全名+方法
		 log.setParams(new ObjectMapper().writeValueAsString(jp.getArgs()));//方法实际参数值
		 log.setOperation("operation");//添加,修改,删除,..
		 log.setTime(time);
		 log.setCreatedTime(new Date());
		 //3.将用户行为信息存储到数据库
		 sysLogDao.insertObject(log);
	 }
}


