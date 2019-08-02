package com.cy.pj.common.vo;
import java.io.Serializable;
import java.util.List;
import com.cy.pj.sys.entity.SysRole;
/**
 * VO：通过此对象封装角色以及角色对应的菜单id
 * @author ta
 */
public class SysRoleMenuVo implements Serializable{
	
	private static final long serialVersionUID = -3748480033139534136L;
	/**角色id*/
	private Integer id;
	/**角色名称*/
	private String name;
	/**角色备注*/
	private String note;
	/**角色对应的菜单id*/
	private List<Integer> menuIds;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id= id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public List<Integer> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}
}