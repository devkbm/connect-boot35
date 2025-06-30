package com.like.hrm.staff.application.service.staff.appointment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.application.port.in.staff.appointment.StaffAppointmentApplyUseCase;
import com.like.hrm.staff.application.port.in.staff.appointment.save.StaffAppointmentRecordDTO;
import com.like.hrm.staff.application.port.in.staff.appointment.save.StaffAppointmentRecordDTOMapper;
import com.like.hrm.staff.application.port.in.staff.appointment.save.StaffAppointmentSaveUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffAppointmentCommandDbPort;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;

import jakarta.persistence.EntityNotFoundException;

@Transactional
@Service
public class StaffAppointmentSaveService implements StaffAppointmentSaveUseCase {

	StaffCommandDbPort staffDbPort;
	StaffAppointmentCommandDbPort appointmentDbPort;
	
	StaffAppointmentApplyUseCase apply;
	
	StaffAppointmentSaveService(
			StaffCommandDbPort staffDbPort, 
			StaffAppointmentCommandDbPort appointmentDbPort,
			StaffAppointmentApplyUseCase apply
			) {
		this.staffDbPort = staffDbPort;
		this.appointmentDbPort = appointmentDbPort;
		this.apply = apply;
	}
	
	@Override
	public void save(StaffAppointmentRecordDTO dto) {		
		
		Staff staff = staffDbPort.select(dto.companyCode(), dto.staffNo())
								 .orElseThrow(() -> new EntityNotFoundException(dto.staffNo() + " 직원정보가 존재하지 않습니다."));		
				
		AppointmentRecord entity = this.appointmentDbPort.select(dto.companyCode(), dto.staffNo(), dto.seq()).orElse(null);		
		if (entity == null) {
			entity = StaffAppointmentRecordDTOMapper.newEntity(dto, staff);
		} else {
			StaffAppointmentRecordDTOMapper.modifyEntity(dto, entity);
			//dto.modifyEntity(entity);
		}
		entity = this.appointmentDbPort.save(entity);
						
		apply.apply(entity.getId().getCompanyCode(), entity.getId().getStaffNo(), entity.getId().getSeq());							
	}
	
}
