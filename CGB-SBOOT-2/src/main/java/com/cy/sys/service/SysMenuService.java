package com.cy.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;

public interface SysMenuService {
	List<Map<String,Object>> findObjects();
	int deleteObject(Integer id);
	List<Node> findZtreeMenuNodes();
	public int saveObject(SysMenu entity);
	public int updateObject(SysMenu entity);
}
