package com.like.hrm.payitem.application.port.out;

import java.util.Optional;

import com.like.hrm.payitem.domain.PayTable;

public interface PayTableCommandDbPort {	
	
	Optional<PayTable> select(String id);
	
	void save(PayTable entity);
	
	void delete(String id);
}
