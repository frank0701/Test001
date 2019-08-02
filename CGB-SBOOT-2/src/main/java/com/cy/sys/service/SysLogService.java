package com.cy.sys.service;

import com.cy.pj.common.annotation.RequiredCache;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;

public interface SysLogService {
	PageObject<SysLog> findPageObjects(String name,Integer pageCurrent);
	int deleteObjects(Integer...ids);
}
