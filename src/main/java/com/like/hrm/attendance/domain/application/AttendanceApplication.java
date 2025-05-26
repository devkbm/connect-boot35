package com.like.hrm.attendance.domain.application;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.hibernate.annotations.Comment;

import com.like.common.vo.LocalDatePeriod;
import com.like.core.jpa.domain.AbstractAuditEntity;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
		
	//@OneToMany(mappedBy = "dutyApplication", orphanRemoval = true, cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "id.dutyApplication", orphanRemoval = true, cascade = CascadeType.ALL)
	List<AttendanceApplicationDate> selectedDateList;
			
	@Transient
	private List<DutyApplicationAttachedFile> fileList;
	
	
	public AttendanceApplication(
			String companyCode,
			String staffNo,
			String dutyCode,
			String dutyReason,
			LocalDatePeriod period,
			List<LocalDate> selectedDateList,
			BigDecimal dutyTime) {
		
		this.companyCode = companyCode;
		this.staffNo = staffNo;
		this.dutyCode = dutyCode;
		this.dutyReason = dutyReason;
		this.period = period;		
		this.selectedDateList = addApplicationDateList(selectedDateList, dutyTime);
	}	
	
	public void modify(
			String dutyCode,
			String dutyReason,
			LocalDatePeriod period,
			List<LocalDate> selectedDate,
			BigDecimal dutyTime) {
		
		this.dutyCode = dutyCode;
		this.dutyReason = dutyReason;
		this.period = period;
		
		this.selectedDateList.clear();
		this.selectedDateList = addApplicationDateList(selectedDate, dutyTime);
	}	
	
	public void addFile(DutyApplicationAttachedFile file) {
		this.fileList.add(file);
	}
	
	public List<LocalDate> getSelectedDate() {
		return this.selectedDateList.stream().map(e -> e.getId().getDate()).toList();
	}
	
	public BigDecimal getSumDutyTime() {
		// for loop
		BigDecimal sum = BigDecimal.ZERO;		
		for (AttendanceApplicationDate dates : this.selectedDateList) sum = sum.add(dates.getDutyTime());
		
		// stream
		/*
		sum = this.selectedDateList.stream()
								   .map(e -> e.getDutyTime())
								   .reduce(BigDecimal.ZERO, BigDecimal::add);
		*/
		
		return sum;
	}
	
	private List<AttendanceApplicationDate> addApplicationDateList(List<LocalDate> dateList, BigDecimal dutyTime) {
		if (this.selectedDateList == null) this.selectedDateList = new ArrayList<>();
		
		for (LocalDate date : dateList) {
			this.selectedDateList.add(new AttendanceApplicationDate(this, date, dutyTime));
		}
		
		return this.selectedDateList;
	}
	
}
