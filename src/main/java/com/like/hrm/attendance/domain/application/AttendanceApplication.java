package com.like.hrm.attendance.domain.application;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.hibernate.annotations.Comment;

import com.like.core.jpa.domain.AbstractAuditEntity;

import io.hypersistence.utils.hibernate.id.Tsid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Aggregation Root
 * 
 * 근태신청 엔티티 
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "HRMDUTYAPP")
public class AttendanceApplication extends AbstractAuditEntity {
	
	@Id		
	@Tsid
	@Column(name="DUTY_ID", nullable = false)
	Long appId;
			
	@Column(name="ORG_CD") 
	String companyCode;
	
	@Column(name="STAFF_NO") 
	String staffNo;		
		
	@Comment("근무사유")
	@Column(name="DUTY_REASON", nullable = false)
	String dutyReason;	
						
	@Transient
	private List<DutyApplicationAttachedFile> fileList;	
	
	public AttendanceApplication(
			String companyCode,
			String staffNo,			
			String dutyReason			
			) {
		
		this.companyCode = companyCode;
		this.staffNo = staffNo;
		this.dutyReason = dutyReason;				
	}	
	
	public void modify(			
			String dutyReason			
			) {			
		this.dutyReason = dutyReason;		
	}	
	
	public void addFile(DutyApplicationAttachedFile file) {
		this.fileList.add(file);
	}	
		
}
