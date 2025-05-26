package com.like.hrm.staff.domain.partner;

import java.time.LocalDate;

import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.hrm.staff.domain.AbstractStaff;
import com.like.hrm.staff.domain.staff.ResidentRegistrationNumber;
import com.like.hrm.staff.domain.staff.StaffId;
import com.like.hrm.staff.domain.staff.StaffName;
import com.like.hrm.staff.domain.staff.StaffNoCreateStrategy;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "HRMSTAFF")
@EntityListeners(AuditingEntityListener.class)
public class PartnerCompanyStaff extends AbstractStaff {

	@EmbeddedId
	StaffId id;
	
	@Embedded
	StaffName name;
				
	@Embedded
	ResidentRegistrationNumber residentRegistrationNumber;
	
	@Column(name="STAFF_YN")
	Boolean isStaff = false;
	
	@Comment("성별")
	@Column(name="GENDER")
	String gender;
				
	@Comment("생일")
	@Column(name="BIRTHDAY")
	LocalDate birthday;	
	
	@Comment("이미지경로")
	@Column(name="IMG_PATH")
	String imagePath;
			
	@Comment("소속부서코드")
	@Column(name="PARTNER_COMP_CODE")
	String partnerCompanyCode;
	
	@Comment("근무상태")
	@Column(name="WORK_STATE_CODE")
	String workStateCode;
	
	@Comment("입사일")
	@Column(name="JOIN_COMP_DT")
	LocalDate joinDate;
	
	@Comment("퇴사일")
	@Column(name="RETIRE_COMP_DT")
	LocalDate retireDate;
						
	@Comment("소속부서코드")
	@Column(name="BLNG_DEPT_CODE")
	String blngDeptCode;
		
	@Comment("근무부서코드")
	@Column(name="WORK_DEPT_CODE")
	String workDeptCode;
	
	public PartnerCompanyStaff(
			String companyCode, 
			StaffNoCreateStrategy strategy, 
			StaffName name, 
			String gender, 
			LocalDate birthday,
			String partnerCompanyCode,
			LocalDate joinDate,
			LocalDate retireDate,
			String blngDeptCode,
			String workDeptCode
			) {
		this.id 			= new StaffId(companyCode, strategy.create());
		this.name 			= name; 		
		this.gender 		= gender;
		this.birthday		= birthday;
		this.partnerCompanyCode = partnerCompanyCode;
		this.joinDate 		= joinDate;
		this.retireDate 	= retireDate;
		this.blngDeptCode	= blngDeptCode;
		this.workDeptCode	= workDeptCode;
	}
	
	public void modify(
			StaffName name, 
			String gender, 
			LocalDate birthday,
			String partnerCompanyCode,
			LocalDate joinDate,
			LocalDate retireDate,
			String blngDeptCode,
			String workDeptCode
			) {
		this.name 			= name; 		
		this.gender 		= gender;
		this.birthday		= birthday;
		this.partnerCompanyCode = partnerCompanyCode;
		this.joinDate 		= joinDate;
		this.retireDate 	= retireDate;
		this.blngDeptCode	= blngDeptCode;
		this.workDeptCode	= workDeptCode;
	}
}
