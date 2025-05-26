package com.like.system.user.domain;

import org.hibernate.envers.Audited;
import org.springframework.security.core.GrantedAuthority;

import com.like.core.jpa.domain.AbstractAuditEntity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Audited
@Entity
@Table(name = "COMUSERROLE")
public class SystemUserCompanyRole extends AbstractAuditEntity implements GrantedAuthority {
	
	private static final long serialVersionUID = 8196330930609694251L;

	@EmbeddedId
	SystemUserCompanyRoleId id;
		
	@MapsId("id") 
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	SystemUser systemUser;
		
	public SystemUserCompanyRole(SystemUser user, String companyCode, String roleCode) {
		this.systemUser = user;
		this.id = new SystemUserCompanyRoleId(user.getId().getUserId(), companyCode, roleCode);		
	}
	
	@Override
	public String getAuthority() {
		return this.id.getRoleCode();
	}

	public String getCompanyCode() {
		return this.id.getCompanyCode();		
	}

	public String getUserId() {
		return this.id.getUserId().getUserId();
	}

	public String getRoleCode() {
		return this.id.getRoleCode();
	}
	
}
