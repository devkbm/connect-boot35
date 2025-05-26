package com.like.hrm.overtime.domain.application;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.core.jpa.domain.AbstractAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "HRMSTAFFOVERTIMEAPPLICATION")
@EntityListeners(AuditingEntityListener.class)
public class OverTimeApplication extends AbstractAuditEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OVTM_ID")
	Long ovtmId;
	
	@Column(name="ORG_CD") 
	String companyCode;
	
	@Column(name="STAFF_NO") 
	String staffNo;
	
	@Column(name="OVTM_FROM_DT")
	LocalDateTime from;
	
	@Column(name="OVTM_TO_DT")
	LocalDateTime to;
	
	@Column(name="CONTENTS")
	String contents;
	
	@Column(name="LOCATION")
	String location;
	
	@Column(name="OVTM_MINUTE")
	Long overTimeMinute;
	
	@Column(name="NGT_OVTM_MINUTE")
	Long nightOverTimeMinute;
		
	@Column(name="HOLY_OVTM_MINUTE")
	Long holyDayOverTimeMinute;
	
	@Column(name="HOLY_NGT_OVTM_MINUTE")
	Long holyDayNightOverTimeMinute;
	
	public OverTimeApplication(
			String companyCode,
			String staffNo,
			LocalDateTime from,
			LocalDateTime to,
			String contents,
			String location
			) {
		this.companyCode = companyCode;
		this.staffNo = staffNo;
		this.from = from;
		this.to = to;
		this.contents = contents;
		this.location = location;		
		
		this.overTimeMinute = calcOverTimeMinute(this.from, this.to);
	}
	
	public void modify(
			LocalDateTime from,
			LocalDateTime to,
			String contents,
			String location
			) {
		this.from = from;
		this.to = to;
		this.contents = contents;
		this.location = location;
		
		this.overTimeMinute = calcOverTimeMinute(this.from, this.to);
	}	
	
	public Long calcOverTimeMinute(LocalDateTime from, LocalDateTime to) {
		Duration duration = Duration.between(from, to);
		
		return duration.getSeconds() * 60;
	}
	
}
