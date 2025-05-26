package com.like.hrm.attendance.domain.application;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = {"dutyApplication", "date"})
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
public class AttendanceApplicationDateId implements Serializable {
		
	private static final long serialVersionUID = 5466023572115599204L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_DUTY_ID", nullable=false, updatable=false)
	private AttendanceApplication dutyApplication;
		
	@Column(name="DUTY_DT", nullable = false)	
	private LocalDate date;
	
	public AttendanceApplicationDateId(AttendanceApplication dutyApplication
			 					,LocalDate date) {
		this.dutyApplication = dutyApplication;
		this.date = date;
	}
}
