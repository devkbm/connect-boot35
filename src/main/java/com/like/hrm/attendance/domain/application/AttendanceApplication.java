package com.like.hrm.attendance.domain.application;


import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.hibernate.annotations.Comment;

import com.like.common.vo.LocalDatePeriod;
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
@Table(name = "HRMDUTYAPPLICATION")
public class AttendanceApplication extends AbstractAuditEntity {
	
	@Id		
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Tsid
	@Column(name="DUTY_ID", nullable = false)
	Long id;
			
	@Column(name="ORG_CD") 
	String companyCode;
	
	@Column(name="STAFF_NO") 
	String staffNo;		
	
	@Comment("근무코드")
	@Column(name="DUTY_CODE", nullable = false)
	String dutyCode;
	
	@Comment("근무사유")
	@Column(name="DUTY_REASON", nullable = false)
	String dutyReason;	
		
	@AttributeOverrides({
		@AttributeOverride(name = "from", column = @Column(name = "FROM_DT")),
		@AttributeOverride(name = "to", column = @Column(name = "TO_DT"))
	})
	LocalDatePeriod period;
	
	@Column(name="HHMM")
	LocalTime hhmm;
					
	@Transient
	private List<DutyApplicationAttachedFile> fileList;	
	
	public AttendanceApplication(
			String companyCode,
			String staffNo,
			String dutyCode,
			String dutyReason,
			LocalDatePeriod period,			
			LocalTime hhmm
			) {
		
		this.companyCode = companyCode;
		this.staffNo = staffNo;
		this.dutyCode = dutyCode;
		this.dutyReason = dutyReason;		
		this.period = period;		
		this.hhmm = hhmm;
	}	
	
	public void modify(
			String dutyCode,
			String dutyReason,
			LocalDatePeriod period,						
			LocalTime hhmm
			) {
		
		this.dutyCode = dutyCode;
		this.dutyReason = dutyReason;
		this.period = period;		
		this.hhmm = hhmm;
	}	
	
	public void addFile(DutyApplicationAttachedFile file) {
		this.fileList.add(file);
	}	
		
}
