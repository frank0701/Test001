package com.cy.sys.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.PageUtil;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.sys.service.SysLogService;
import com.db.common.exception.ServiceException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SysLogServiceImpl implements SysLogService{
//	private static final Logger logger = LoggerFactory.getLogger(SysLogServiceImpl.class);
	@Autowired
	@Qualifier("sysLogDao")
	private SysLogDao sysLogDao;
	@Override
	public int deleteObjects(Integer... ids) {
		//1.参数校验
		//2.执行删除
		int rows = sysLogDao.deleteObjects(ids);
		if (rows>0) {
			log.info("修改了"+rows);
		}
		//3.验证并返回结果
		return rows;
	}
	@Override
	public PageObject<SysLog> findPageObjects(String name, Integer pageCurrent) {
		 //1.验证参数合法性
		  //1.1验证pageCurrent的合法性，
		  //不合法抛出IllegalArgumentException异常
		  if(pageCurrent==null||pageCurrent<1)
		  throw new IllegalArgumentException("当前页码不正确");
		  //2.基于条件查询总记录数
		  //2.1) 执行查询
//		  System.out.println("Serviceimpl"+name);
		  int rowCount=sysLogDao.getRowCount(name);
		  System.out.println(rowCount);
		  //2.2) 验证查询结果，假如结果为0不再执行如下操作
		  if(rowCount==0)
		  throw new ServiceException("系统没有查到对应记录");
		  //3.基于条件查询当前页记录(pageSize定义为2)
		  //3.1)定义pageSize
		  int pageSize=PageUtil.getPageSize();
		  //3.2)计算startIndex
		  int startIndex=PageUtil.getStartIndex(pageCurrent);
		  //3.3)执行当前数据的查询操作
		  List<SysLog> records=
		  sysLogDao.findPageObjects(name, startIndex, pageSize);
//		  for (SysLog sysLog : records) {
//			System.out.println(sysLog);
//		}
		  //4.对分页信息以及当前页记录进行封装
		  //4.1)构建PageObject对象
		  PageObject<SysLog> pageObject = PageUtil.newPageObject(pageCurrent, rowCount, pageSize, records);
		  //5.返回封装结果。
		  return pageObject;
	}
	
}
