package com.like.hrm.staff.adapter.out.db.partner;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.partner.data.PartnerCompanyStaffJpaRepository;
import com.like.hrm.staff.application.port.out.partner.PartnerCompanyStaffCommandDbPort;
import com.like.hrm.staff.domain.partner.PartnerCompanyStaff;
import com.like.hrm.staff.domain.staff.StaffId;

@Repository
public class PartnerCompanyStaffCommandDbAdapter implements PartnerCompanyStaffCommandDbPort {

	PartnerCompanyStaffJpaRepository repository;
	
	PartnerCompanyStaffCommandDbAdapter(PartnerCompanyStaffJpaRepository repository) {
		this.repository = repository;
	}
	 
	@Override
	public Optional<PartnerCompanyStaff> select(String companyCode, String staffNo) {
		return this.repository.findById(new StaffId(companyCode, staffNo));
	}

	@Override
	public void save(PartnerCompanyStaff entity) {
		this.repository.save(entity);
	}

	@Override
	public void delete(String companyCode, String staffNo) {
		this.repository.deleteById(new StaffId(companyCode, staffNo));
	}

}
