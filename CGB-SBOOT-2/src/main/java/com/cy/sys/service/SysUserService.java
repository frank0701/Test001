package com.cy.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.pj.common.annotation.RequiredCache;
import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.entity.SysUser;

public interface SysUserService {
//	@RequiredCache
	PageObject<SysUserDeptVo> findPageObjects(
			String username,
			Integer pageCurrent);
	public int validById(Integer id,
			Integer valid,
			String modifiedUser);
	public int saveObject(SysUser entity, Integer[] roleIds);
	public Map<String, Object> findObjectById(
			Integer userId) ;
	public int updateObject(SysUser entity,Integer[] roleIds);
}
