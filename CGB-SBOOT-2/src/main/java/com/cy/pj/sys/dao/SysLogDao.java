package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.entity.SysLog;

@Mapper
public interface SysLogDao {
	/**按条件查询日志总记录数
	 * @param username 查询条件
	 * */
	int getRowCount(@Param("username")String username);
	
	/**
	 * 基于条件执行分页查询,获取当前页记录
	 * @param username
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<SysLog> findPageObjects(@Param("username")String username
			,@Param("startIndex")Integer startIndex
			,@Param("pageSize")Integer pageSize);
	
	@Delete("delete from sys_logs where id = #{id}")
	int deleteObject(Integer id);
	
	/**
	 * 基于传入的id执行动态删除(可能多个)操作
	 * @param ids
	 * @return
	 */
	
	int deleteObjects(@Param("ids")Integer...ids);
	int insertObject(SysLog entity);
}
