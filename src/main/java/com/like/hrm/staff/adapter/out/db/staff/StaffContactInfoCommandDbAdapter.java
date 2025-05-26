package com.like.hrm.staff.adapter.out.db.staff;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.adapter.out.db.staff.data.StaffContactInfoJpaRepository;
import com.like.hrm.staff.application.port.out.staff.StaffContactInfoCommandDbPort;
import com.like.hrm.staff.domain.staff.contact.ContactInfo;
import com.like.hrm.staff.domain.staff.contact.ContactInfoId;

@Repository
public class StaffContactInfoCommandDbAdapter implements StaffContactInfoCommandDbPort {

	StaffContactInfoJpaRepository repository;
	
	StaffContactInfoCommandDbAdapter(StaffContactInfoJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<ContactInfo> select(ContactInfoId id) {
		return this.repository.findById(id);
	}

	@Override
	public ContactInfo save(ContactInfo entity) {
		return this.repository.save(entity);
	}
	
	@Override
	public void save(List<ContactInfo> entityList) {
		this.repository.saveAll(entityList);
		
	}

	@Override
	public void delete(ContactInfoId id) {
		this.repository.deleteById(id);
	}

	

}
