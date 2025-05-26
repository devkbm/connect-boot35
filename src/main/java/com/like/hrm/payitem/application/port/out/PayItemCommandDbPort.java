package com.like.hrm.payitem.application.port.out;

import java.util.Optional;

import com.like.hrm.payitem.domain.PayItem;
import com.like.hrm.payitem.domain.PayItemId;

public interface PayItemCommandDbPort {
	
	Optional<PayItem> select(PayItemId id);
	
	void save(PayItem entity);
	
	void delete(PayItemId id);	
}
