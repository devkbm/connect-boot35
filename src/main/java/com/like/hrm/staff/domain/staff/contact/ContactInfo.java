package com.like.hrm.staff.domain.staff.contact;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.common.vo.Address;
import com.like.common.vo.PhoneNumber;
import com.like.core.jpa.domain.AbstractAuditEntity;
import com.like.hrm.staff.domain.staff.Staff;

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
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "HRMSTAFFCONTACT")
@EntityListeners(AuditingEntityListener.class)
public class ContactInfo extends AbstractAuditEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "ORG_CD", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name = "STAFF_NO", nullable=false, insertable=false, updatable=false)
	})
	private Staff staff;
	
	@EmbeddedId	
	ContactInfoId id;
	
	@Embedded
	Address address;
	
	@Embedded
	PhoneNumber phoneNumber;
	
	public ContactInfo(
			Staff staff,
			String type,
			Address address
			) {
		this.staff = staff;
		this.id = new ContactInfoId(staff, type);
		this.address = address;	
	}
	
	public ContactInfo(
			Staff staff,
			String type,
			PhoneNumber phoneNumber
			) {
		this.staff = staff;
		this.id = new ContactInfoId(staff, type);
		this.phoneNumber = phoneNumber;	
	}
}
