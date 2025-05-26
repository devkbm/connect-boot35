package com.like.hrm.staff.domain.staff.period;

import java.io.Serializable;

import org.hibernate.annotations.Comment;

import com.like.hrm.staff.domain.staff.Staff;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = {"companyCode","staffNo","periodType","seq"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class StaffPeriodId implements Serializable {
	
	private static final long serialVersionUID = 1961973101886772836L;

	@Column(name="ORG_CD")
	String companyCode;
		
	@Column(name="STAFF_NO")
	String staffNo;
	
	@Column(name="PERIOD_TYPE_CD")
	String periodType;
	
	@Comment("등록순번")
	@Column(name="SEQ")
	Long seq;	
	
	public StaffPeriodId(
			Staff staff,
			String periodType,
			Long seq
			) {
		this.companyCode = staff.getId().companyCode();
		this.staffNo = staff.getId().staffNo();
		this.periodType = periodType;
		this.seq = seq;
	}
	
	public StaffPeriodId(
			String companyCode,
			String staffNo,
			String periodType,
			Long seq
			) {
		this.companyCode = companyCode;
		this.staffNo = staffNo;
		this.periodType = periodType;
		this.seq = seq;
	}
}
