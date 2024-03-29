package com.cy.pj.sys.entity;

import java.util.Date;

import lombok.Data;

@Data
public class SysRole {
	private static final long serialVersionUID = -2113802202295967078L;
	private Integer id;
	private String name;
	private String note;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
}
