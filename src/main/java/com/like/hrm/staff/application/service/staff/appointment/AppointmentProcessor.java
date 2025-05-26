package com.like.hrm.staff.application.service.staff.appointment;

import org.springframework.stereotype.Service;

import com.like.hrm.hrmcode.application.dto.hrmcode.HrmCodeSelectDTO;
import com.like.hrm.hrmcode.application.port.in.hrmcode.HrmCodeSelectUseCase;
import com.like.hrm.staff.application.port.in.staff.appointment.StaffAppointmentApplyUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffAppointmentCommandDbPort;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.application.port.out.staff.StaffPeriodCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;
import com.like.hrm.staff.domain.staff.period.StaffPeriod;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AppointmentProcessor implements StaffAppointmentApplyUseCase {
	
	StaffCommandDbPort staffDbPort;
	StaffAppointmentCommandDbPort appointmentDbPort;
	StaffPeriodCommandDbPort periodDbPort;
	HrmCodeSelectUseCase hrmCode;
	
	AppointmentProcessor(
			StaffCommandDbPort staffDbPort,
			StaffAppointmentCommandDbPort appointmentDbPort,
			StaffPeriodCommandDbPort periodDbPort,
			HrmCodeSelectUseCase hrmCode
			) {
		this.staffDbPort = staffDbPort;
		this.appointmentDbPort = appointmentDbPort;
		this.periodDbPort = periodDbPort;
		this.hrmCode = hrmCode;
	}

	@Override
	public void apply(String companyCode, String staffNo, Long seq) {
		AppointmentRecord record = appointmentDbPort.select(companyCode, staffNo, seq)
				.orElseThrow(() -> new EntityNotFoundException(staffNo + " 발령정보가 존재하지 않습니다."));
		
		Staff staff = staffDbPort.select(companyCode, staffNo)
				.orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원정보가 존재하지 않습니다."));
				
		HrmCodeSelectDTO appointmentCode = hrmCode.select("HR0000", record.getAppointmentTypeCode());
		
		boolean isJoin = (boolean)appointmentCode.extraInfo().getOrDefault("joinDateYn", false);						
		if (isJoin) {
			StaffPeriod period = staff.joinCompany(record.getAppointmentDate());
			periodDbPort.save(period);
		}
		
		boolean isRetire = (boolean)appointmentCode.extraInfo().getOrDefault("retireDateYn", false);						
		if (isRetire) {
			StaffPeriod period = staff.retireCompany(record.getAppointmentDate());
			periodDbPort.save(period);
		}

		staff.applyAppointmentRecord(record);
		
		staffDbPort.save(staff);
		
		record.complete();
		
		appointmentDbPort.save(record);
	}
	
	
}
