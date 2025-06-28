package com.like.system.dept.application.port.in.save;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record DeptSaveDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,
		String parentDeptCode,					
		String companyCode,
		@NotEmpty(message="부서코드는 필수 입력 사항입니다.")
		String deptCode,
		@NotEmpty(message="부서명(한글)은 필수 입력 사항입니다.")
		String deptNameKorean,
		String deptAbbreviationKorean,
		String deptNameEnglish,
		String deptAbbreviationEnglish,
		@DateTimeFormat(iso = ISO.DATE  )
		LocalDate fromDate,
		@DateTimeFormat(iso = ISO.DATE  )
		//@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
		LocalDate toDate,
		Integer seq,
		String comment
		) {

	
	
	
	
	/*
	public void modifyDept(Dept dept, @Nullable Dept parentDept) {
		dept.modifyEntity(deptNameKorean
						 ,deptAbbreviationKorean
						 ,deptNameEnglish
						 ,deptAbbreviationEnglish
						 ,new LocalDatePeriod(this.fromDate, this.toDate)
						 ,seq
						 ,comment
						 ,parentDept);
		
		dept.setAppUrl(clientAppUrl);
	}
	*/
}
