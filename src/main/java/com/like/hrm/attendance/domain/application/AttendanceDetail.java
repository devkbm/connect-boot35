package com.like.hrm.attendance.domain.application;


import java.time.LocalTime;

import org.hibernate.annotations.Comment;

import com.like.common.vo.LocalDatePeriod;
import com.like.core.jpa.domain.AbstractAuditEntity;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "HRMDUTYAPPLICATIONDETAIL")
public class AttendanceDetail extends AbstractAuditEntity {
	
	@Id		
	@Tsid
	@Column(name="DETAIL_ID", nullable = false)
	Long detailId;
	
	@Column(name="ORG_CD") 
	String companyCode;
	
	@Column(name="STAFF_NO") 
	String staffNo;
	
	@Comment("근무코드")
	@Column(name="DUTY_CODE", nullable = false)
	String dutyCode;
		
	@AttributeOverrides({
		@AttributeOverride(name = "from", column = @Column(name = "FROM_DT")),
		@AttributeOverride(name = "to", column = @Column(name = "TO_DT"))
	})
	LocalDatePeriod period;
	
	@Column(name="HHMM")
	LocalTime hhmm;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DUTY_ID", nullable=false, updatable=false)
	AttendanceApplication attendanceApplication;
	
	public AttendanceDetail(
			AttendanceApplication app,
			String dutyCode,
			LocalDatePeriod period,
			LocalTime hhmm
			) {
		this.attendanceApplication = app;
		this.companyCode = app.getCompanyCode();
		this.staffNo = app.getStaffNo();
		this.dutyCode = dutyCode;
		this.period = period;
		this.hhmm = hhmm;
	}
}
