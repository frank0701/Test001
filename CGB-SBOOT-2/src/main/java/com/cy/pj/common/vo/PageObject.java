package com.cy.pj.common.vo;
/**
 * 负责封装业务层当前页记录以及分页信息
 * @author hasee
 *
 * @param <T>
 */

import java.util.List;

import lombok.Data;

@Data
public class PageObject<T> {
	private Integer pageCurrent=1;
	/**页面大小*/
	private Integer pageSize=3;
	/**总行数(通过查询获得)*/
    private Integer rowCount=0;
    /**总页数(通过计算获得)*/
    private Integer pageCount=0;
    /**当前页记录*/
    private List<T> records;
}
