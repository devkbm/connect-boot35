package com.like.hrm.staff.domain.staff;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.hrm.staff.domain.AbstractStaff;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecordList;
import com.like.hrm.staff.domain.staff.contact.ContactInfoList;
import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDutyList;
import com.like.hrm.staff.domain.staff.family.StaffFamilyList;
import com.like.hrm.staff.domain.staff.license.StaffLicenseList;
import com.like.hrm.staff.domain.staff.period.StaffPeriod;
import com.like.hrm.staff.domain.staff.period.StaffPeriodList;
import com.like.hrm.staff.domain.staff.schoolcareer.StaffSchoolCareerList;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Aggregate Root 
 * <p> 직원정보 </p>
 *  
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "HRMSTAFF")
@EntityListeners(AuditingEntityListener.class)
public class Staff extends AbstractStaff implements Serializable {

	private static final long serialVersionUID = -3164713918774455925L;
	
	@EmbeddedId
	StaffId id;
		
	@Embedded
	StaffName name;
				
	@Embedded
	ResidentRegistrationNumber residentRegistrationNumber;
	
	@Column(name="STAFF_YN")
	Boolean isStaff = true;
			
	@Comment("성별")
	@Column(name="GENDER")
	String gender;
				
	@Comment("생일")
	@Column(name="BIRTHDAY")
	LocalDate birthday;	
		
	@Comment("입사일")
	@Column(name="JOIN_COMP_DT")
	LocalDate joinDate;
	
	@Comment("퇴사일")
	@Column(name="RETIRE_COMP_DT")
	LocalDate retireDate;
	
	@Comment("근무상태")
	@Column(name="WORK_STATE_CODE")
	String workStateCode;
		
	@Comment("이미지경로")
	@Column(name="IMG_PATH")
	String imagePath;
		
	@Embedded
	CurrentAppointmentInformation currentAppointment = new CurrentAppointmentInformation();
		
	@Embedded
	AppointmentRecordList appointmentRecordList = new AppointmentRecordList();
		
	@Embedded
	StaffDutyList staffDutyResponsibilityList = new StaffDutyList();
	
	@Embedded
	StaffFamilyList familyList = new StaffFamilyList();
		
	@Embedded
	StaffSchoolCareerList schoolCareerList = new StaffSchoolCareerList();
	
	/**
	 * 자격면허 명단
	 */
	@Embedded
	StaffLicenseList licenseList = new StaffLicenseList();
	
	@Embedded
	StaffPeriodList periodList = new StaffPeriodList();
	
	@Embedded
	ContactInfoList contactInfoList = new ContactInfoList();
			
	public Staff(String companyCode, StaffNoCreateStrategy strategy, StaffName name, String residentRegistrationNumber) {
		this.id 						= new StaffId(companyCode, strategy.create());
		this.name 						= name; 
		this.residentRegistrationNumber = ResidentRegistrationNumber.of(residentRegistrationNumber);
		this.gender 					= this.residentRegistrationNumber.getGender();
		this.birthday 					= this.residentRegistrationNumber.getBirthDay();		
	}	
					
	public void modifyEntity(StaffName name
						    ,LocalDate birthday) {
		this.name 		= name;				
		this.birthday 	= birthday;
	}
					
	public void changeImagePath(String imagePath) {
		this.imagePath = imagePath;
	}	
	
	public StaffPeriod joinCompany(LocalDate joinDate) {
		this.joinDate = joinDate;			
		
		if (this.periodList == null) {
			this.periodList = new StaffPeriodList();
		}
						
		StaffPeriod period = new StaffPeriod(
				this,
				"A",
				joinDate,
				LocalDate.of(9999, 12, 31),
				""
				); 
		
		this.periodList.add(period);
		
		return period;
	}
	
	public StaffPeriod retireCompany(LocalDate retireDate) {
		this.retireDate = retireDate;
		
		StaffPeriod period = this.periodList.getMax(this, "A");
		
		period.modify(period.getPeriod().getFrom(), retireDate, "");
		
		return period;
	}
	
	public void applyAppointmentRecord(AppointmentRecord record) {		
		if (this.currentAppointment == null) this.currentAppointment = new CurrentAppointmentInformation(record.getInfo()); 		
								
		this.currentAppointment.apply(record.getInfo());					
	}	
		
}
