package com.cy.pj.sys.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysDeptDao {
	@Select("select * from sys_depts")
	List<Map<String,Object>> doFindObjects();
	 /**
	  * 根据部门id统计子部门的个数
	  * @param id
	  * @return
	  */
//	 int getChildCount(Integer id);
//	 /**
//	  * 根据id 删除部门
//	  * @param id
//	  * @return
//	  */
//	 int deleteObject(Integer id);
}
