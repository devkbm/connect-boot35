package com.like.hrm.staff.application.port.in.staff.appointment.save;

import java.util.Optional;

import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.appointment.AppointmentApplyType;
import com.like.hrm.staff.domain.staff.appointment.AppointmentInformation;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;

public class StaffAppointmentRecordDTOMapper {
	
	public static AppointmentRecord newEntity(StaffAppointmentRecordDTO dto, Staff staff) {		
		AppointmentInformation info = newAppointmentInformation(dto);
		
		return AppointmentRecord
				.builder()
				.staff(staff)
				.appointmentTypeCode(dto.appointmentTypeCode())
				.applyType(AppointmentApplyType.of(dto.applyType()))
				.appointmentDate(dto.appointmentDate())
				.appointmentEndDate(dto.appointmentEndDate())
				.recordName(dto.recordName())
				.comment(dto.comment())
				.info(info)
				.build();
								
	}
	
	public static AppointmentRecord modifyEntity(StaffAppointmentRecordDTO dto, AppointmentRecord entity) {
		
		AppointmentInformation info = newAppointmentInformation(dto);
				
		entity.modifyBuilder()			
			.applyType(AppointmentApplyType.of(dto.applyType()))
			.appointmentDate(dto.appointmentDate())
			.appointmentEndDate(dto.appointmentEndDate())
			.recordName(dto.recordName())
			.comment(dto.comment())
			.info(info)	
			.modify();					
		
		return entity;
	}
			
	public static StaffAppointmentRecordDTO toDTO(AppointmentRecord entity) {
		if (entity == null) return null;																													

		Optional<AppointmentInformation> info = Optional.ofNullable(entity.getInfo());
		
		return StaffAppointmentRecordDTO
				.builder()											 
				.staffNo(entity.getStaff().getId().staffNo())
				.staffName(entity.getStaff().getName().getName())
				.seq(entity.getId().getSeq())
				.appointmentTypeCode(entity.getAppointmentTypeCode())
				.applyType(entity.getApplyType().getCode())
				.appointmentDate(entity.getAppointmentDate())
				.appointmentEndDate(entity.getAppointmentEndDate())
				.recordName(entity.getRecordName())
				.comment(entity.getComment())
				.isCompleted(entity.getIsCompleted())
				.blngDeptCode(info.map(AppointmentInformation::getBlngDeptCode).orElse(null))
				.workDeptCode(info.map(AppointmentInformation::getWorkDeptCode).orElse(null))
				.jobGroupCode(info.map(AppointmentInformation::getJobGroupCode).orElse(null))
				.jobPositionCode(info.map(AppointmentInformation::getJobPositionCode).orElse(null))
				.occupationCode(info.map(AppointmentInformation::getOccupationCode).orElse(null))
				.jobGradeCode(info.map(AppointmentInformation::getJobGradeCode).orElse(null))
				.payStepCode(info.map(AppointmentInformation::getPayStepCode).orElse(null))
				.jobCode(info.map(AppointmentInformation::getJobCode).orElse(null))
				.dutyResponsibilityCode(info.map(AppointmentInformation::getDutyResponsibilityCode).orElse(null))
				.build();									
	}
	
	private static AppointmentInformation newAppointmentInformation(StaffAppointmentRecordDTO dto) {
		return new AppointmentInformation(
				dto.blngDeptCode(),
				dto.workDeptCode(),
				dto.jobGroupCode(),
				dto.jobPositionCode(),
				dto.occupationCode(),
				dto.jobGradeCode(),
				dto.payStepCode(),
				dto.jobCode(),
				dto.dutyResponsibilityCode()
				);
	}
}
