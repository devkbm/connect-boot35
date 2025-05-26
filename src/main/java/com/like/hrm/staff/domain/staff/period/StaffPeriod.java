package com.like.hrm.staff.domain.staff.period;

import java.time.LocalDate;

import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.common.vo.LocalDatePeriod;
import com.like.core.jpa.domain.AbstractAuditEntity;
import com.like.hrm.staff.domain.staff.Staff;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false, of = {"id"})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "HRMSTAFFPERIOD")
@EntityListeners(AuditingEntityListener.class)
public class StaffPeriod extends AbstractAuditEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "ORG_CD", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name = "STAFF_NO", nullable=false, insertable=false, updatable=false)
	})
	private Staff staff;
	
	@EmbeddedId
	StaffPeriodId id;
		
	@Embedded
	LocalDatePeriod period;
	
	@Comment("비고")
	@Column(name="CMT")
	String comment;
	
	public StaffPeriod(
			Staff staff,
			String periodType,
			LocalDate from,
			LocalDate to,
			String comment
			) {
		this.staff = staff;
		this.id = new StaffPeriodId(staff, periodType, staff.getPeriodList().getNextSequence());
		this.period = new LocalDatePeriod(from, to);
		this.comment = comment;		
	}
	
	public void modify(
			LocalDate from,
			LocalDate to,
			String comment
			) {
		this.period = new LocalDatePeriod(from, to);
		this.comment = comment;		
	}
	
}
