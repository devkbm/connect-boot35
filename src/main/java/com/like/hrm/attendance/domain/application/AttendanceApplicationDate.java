package com.like.hrm.attendance.domain.application;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.like.core.jpa.domain.AbstractAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "HRMDUTYAPPLICATIONDATE")
public class AttendanceApplicationDate extends AbstractAuditEntity {
	
	@EmbeddedId
	private AttendanceApplicationDateId id;	
	
	@Column(name="DUTY_TIME", nullable = false)
	private BigDecimal dutyTime;
	
	public AttendanceApplicationDate(
			AttendanceApplication dutyApplication,
			LocalDate date,
			BigDecimal dutyTime
			) {
		this.id = new AttendanceApplicationDateId(dutyApplication, date);
		this.dutyTime = dutyTime;
	}
	
}
