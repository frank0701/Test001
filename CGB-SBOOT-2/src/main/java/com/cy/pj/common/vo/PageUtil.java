package com.cy.pj.common.vo;

import java.util.List;

import com.cy.pj.sys.entity.SysLog;

public class PageUtil {
	private static int pageSize=20;
	public static int getPageSize() {
		return pageSize;
	}
	
	public static int getStartIndex(Integer pageCurrent) {
		return (pageCurrent-1)*pageSize;
	}
	public static <T>PageObject<T> newPageObject(Integer pageCurrent, int rowCount, int pageSize, List<T> records) {
		PageObject<T> pageObject=new PageObject<>();
		  //4.2)封装数据
		  pageObject.setPageCurrent(pageCurrent);
		  pageObject.setPageSize(pageSize);
		  pageObject.setRowCount(rowCount);
		  pageObject.setRecords(records);
        pageObject.setPageCount((rowCount-1)/pageSize+1);
		return pageObject;
	}
}
