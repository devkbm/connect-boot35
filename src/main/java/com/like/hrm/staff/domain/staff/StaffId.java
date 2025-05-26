package com.like.hrm.staff.domain.staff;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record StaffId(
		@Column(name="ORG_CD") String companyCode,
		@Column(name="STAFF_NO") String staffNo		
		) {
		
	public StaffId {
		Objects.requireNonNull(companyCode);
		Objects.requireNonNull(staffNo);
	}
}