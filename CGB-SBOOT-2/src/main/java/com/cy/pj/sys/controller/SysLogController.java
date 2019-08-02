package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.sys.service.SysLogService;

@Controller
@RequestMapping("/log/")
public class SysLogController {
	@Autowired
	private SysLogService sls;
	
	@RequestMapping("doFindPageObject")
	@ResponseBody
	public JsonResult doFindPageObjects(Integer pageCurrent,String username){
//		System.out.println(username);
		return new JsonResult(sls.findPageObjects(username, pageCurrent));
	}
	
	@RequestMapping("doLogListUI")
	public String doLogListUI() {
		return "sys/log_list";
	}
	

	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult  doDeleteObjects(Integer...ids) {
		int rows = sls.deleteObjects(ids);
		return new JsonResult("delete OK");
	}
	@RequestMapping("delete01")
	@ResponseBody
	public String doDeleteObjects() {
		int rows = sls.deleteObjects(10);
		
		return "修改了"+rows+"行";
	}
}
