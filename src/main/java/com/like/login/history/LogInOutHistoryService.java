package com.like.login.history;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.like.login.event.LoginSuccessEvent;
import com.like.login.history.LogInOutHistory.LOG_TYPE;

@Transactional
@Service
public class LogInOutHistoryService {

	private LogInOutHistoryRepository repository;
	
	public LogInOutHistoryService(LogInOutHistoryRepository repository) {
		this.repository = repository;
	}
	
	public void saveLogInOutHistory(LogInOutHistory entity) {
		repository.save(entity);
	}
	
	@Async
	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void loginSuccessRegist(LoginSuccessEvent event) {
		LogInOutHistory entity = new LogInOutHistory(event.userId(),LOG_TYPE.LOGIN, event.clientIp(), true);
		this.repository.save(entity);
	}
}
