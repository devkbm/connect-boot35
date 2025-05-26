package com.like.system.company.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"companyCode"})
@Embeddable
public class CompanyInfoId implements Serializable {
	
	private static final long serialVersionUID = 7980451248122646591L;
	
	@Column(name="ORG_CD")
	String companyCode;	
	
	public CompanyInfoId(String companyCode) {
		this.companyCode = companyCode;
	}
	
}
