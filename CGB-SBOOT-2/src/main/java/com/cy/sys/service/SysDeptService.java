package com.cy.sys.service;

import java.util.List;
import java.util.Map;


public interface SysDeptService {
	List<Map<String,Object>> doFindObjects();
	int deleteObject(Integer id);
}
