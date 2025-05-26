package com.like.system.menu_role.adapter.out.db.role.jpa;

import com.like.core.jpa.domain.AbstractAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Entity
@Table(name = "comrole")
public class RoleJpaEntity extends AbstractAuditEntity {
		
	@EmbeddedId
	RoleJpaEntityId id;
	
	@Column(name="ROLE_NM")
	String roleName;
	
	@Column(name="description")
	String description;	
	
	@Column(name="MENU_GROUP_CD")
	String menuGroupCode;
	
	public RoleJpaEntity(
			String companyCode, 
			String roleCode, 
			String roleName, 
			String description, 
			String menuGroupCode
			) {		
		this.id = new RoleJpaEntityId(companyCode, roleCode);
		this.roleName = roleName;
		this.description = description;
		this.menuGroupCode = menuGroupCode;
	}	
		
	
	public String getCompanyCode() {
		return this.id.getCompanyCode();
	}

	public String getRoleCode() {
		return this.id.getRoleCode();
	}
		
}
