package com.cy.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.sys.dao.SysDeptDao;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.entity.SysDept;
import com.cy.sys.service.SysDeptService;
import com.db.common.exception.ServiceException;

@Service
public class SysDeptServiceImpl implements SysDeptService{
	@Autowired
	SysDeptDao sysDeptDao;
	@Autowired
	SysUserDao sysUserDao;

	@Override
	public List<Map<String,Object>> doFindObjects() {
		List depts = sysDeptDao.doFindObjects();
		return depts;
	}

	@Override
	public int deleteObject(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}


//	@Override
//	public int deleteObject(Integer id) {
//		//1.合法性验证
//		if(id==null||id<=0)
//		throw new ServiceException("数据不合法,id="+id);
//		//2.执行删除操作
//		//2.1判定此id对应的菜单是否有子元素
//		int childCount=sysDeptDao.getChildCount(id);
//		if(childCount>0)
//		throw new ServiceException("此元素有子元素，不允许删除");
//		//2.2判定此部门是否有用户
//		int userCount=sysUserDao.getUserCountByDeptId(id);
//		if(userCount>0)
//		throw new ServiceException("此部门有员工，不允许对部门进行删除");
//		//2.2判定此部门是否已经被用户使用,假如有则拒绝删除
//		//2.3执行删除操作
//		int rows=sysDeptDao.deleteObject(id);
//		if(rows==0)
//		throw new ServiceException("此信息可能已经不存在");
//		return rows;
//			
//	}
}
