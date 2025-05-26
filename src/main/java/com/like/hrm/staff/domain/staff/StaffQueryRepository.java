package com.like.hrm.staff.domain.staff;

import java.util.List;

import com.like.hrm.staff.application.dto.staff.ResponseStaffAppointmentRecord;
import com.like.hrm.staff.application.dto.staff.ResponseStaffCurrentAppointment;
import com.like.hrm.staff.application.dto.staff.ResponseStaffDutyResponsibility;
import com.like.hrm.staff.application.dto.staff.StaffQueryConditionDTO;

public interface StaffQueryRepository {

	
	List<Staff> getStaffList(StaffQueryConditionDTO dto);
	
	ResponseStaffCurrentAppointment getStaffCurrentAppointment(String companyCode, String staffNo);
		
	List<ResponseStaffAppointmentRecord> getStaffAppointmentRecordList(String companyCode, String staffNo);
	
	List<ResponseStaffDutyResponsibility> getStaffDutyResponsibility(String companyCode, String staffNo);
	
}
