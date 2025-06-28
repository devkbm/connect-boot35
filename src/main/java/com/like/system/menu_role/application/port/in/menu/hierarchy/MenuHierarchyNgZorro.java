package com.like.system.menu_role.application.port.in.menu.hierarchy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.like.system.menu_role.domain.menu.MenuHierarchy;
import com.like.system.menu_role.domain.menu.MenuType;
import com.querydsl.core.annotations.QueryProjection;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuHierarchyNgZorro {
	
	/* NzTreeNodeOptions */
	String key;
	
	String title;			
					
	boolean expanded;
	
	boolean selected;
	
	@JsonProperty(value="isLeaf")
	boolean isLeaf;
	
	List<MenuHierarchyNgZorro> children;
	/* NzTreeNodeOptions */
	
	String menuGroupCode;
	
	String parentMenuCode;
	
	String menuType;
	
	Long sequence;
	
	Long level;
	
	String url;
	
	String icon;

	@QueryProjection
	public MenuHierarchyNgZorro(String key, String title, String menuGroupCode, String parentMenuCode,
			MenuType menuType, Long sequence, Long level, String url, String icon) {				
		this.key = key;
		this.title = title;
		this.expanded = false;
		this.selected = false;
		this.menuGroupCode = menuGroupCode;
		this.parentMenuCode = parentMenuCode;
		this.menuType = menuType.toString();
		this.sequence = sequence;
		this.level = level;
		this.url = url;				
		this.icon = icon;
	}
	
	public static MenuHierarchyNgZorro build(MenuHierarchy dto) {
		MenuHierarchyNgZorro rec = new MenuHierarchyNgZorro();
		
		rec.menuGroupCode = dto.getMenuGroupCode();
		rec.parentMenuCode = dto.getParentMenuCode();
		rec.menuType = dto.getMenuType().toString();
		rec.sequence = dto.getSequence();
		rec.level = dto.getLevel();
		rec.url = dto.getAppUrl();
		rec.icon = dto.getAppIcon();
		
		rec.key = dto.getMenuCode();
		rec.title = dto.getMenuName();
		rec.expanded = false;
		rec.selected = false;
		
		rec.isLeaf = dto.isLeaf();
		
		return rec;
	}

	public void setChildren(List<MenuHierarchyNgZorro> children) {
		this.children = children;
	}
	
	public void setIsLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	
}
