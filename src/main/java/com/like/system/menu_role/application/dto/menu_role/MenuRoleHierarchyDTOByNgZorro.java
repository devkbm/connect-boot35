package com.like.system.menu_role.application.dto.menu_role;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.like.system.menu_role.domain.menu_role.MenuRoleHierarchy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuRoleHierarchyDTOByNgZorro {

	/* NzTreeNodeOptions */
	public String key;
	
	public String title;			
					
	public boolean checked;
	
	public boolean expanded;
	
	public boolean selected;
	
	@JsonProperty(value="isLeaf")
	public boolean isLeaf;
	
	public List<MenuRoleHierarchyDTOByNgZorro> children;
	/* NzTreeNodeOptions */
	
	public String menuGroupCode;
	
	public String menuCode;
	
	public String roleCode;
	
	public long menuChildrenCount;
	
	public long menuRoleChildrenCount;
	
	public boolean halfChecked;		
	
	public static MenuRoleHierarchyDTOByNgZorro build(MenuRoleHierarchy dto) {
		MenuRoleHierarchyDTOByNgZorro rec = new MenuRoleHierarchyDTOByNgZorro();
		
		rec.key = dto.getMenuCode();
		rec.title = dto.getMenuName();
		
		rec.menuGroupCode = dto.getMenuGroupCode();
		rec.menuCode = dto.getMenuCode();
		rec.roleCode = dto.getRoleCode();				
		
		rec.checked = dto.isChecked();
		rec.isLeaf = dto.isLeaf();
		
		return rec;
	}
	
	public void setChildren(List<MenuRoleHierarchyDTOByNgZorro> children) {
		this.children = children;
	}
	
	public void setIsLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}	
	
}
