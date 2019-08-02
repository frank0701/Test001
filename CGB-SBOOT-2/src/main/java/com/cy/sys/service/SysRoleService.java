package com.cy.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysRoleMenuVo;
import com.cy.pj.sys.entity.SysRole;

public interface SysRoleService {
	public PageObject<SysRole> doFindObjects(Integer pageCurrent,String username);
	public int deleteObject(Integer id);
	public int saveObject(SysRole entity,Integer[] menuIds);
	SysRoleMenuVo findObjectById(Integer id) ;
	public int updateObject(SysRole entity,Integer[] menuIds);
	public List<CheckBox> findObjects();
}
