package com.like.core.p6spylog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.FormattedLogger;

/**
 * SPRING SESSION JDBC 사용시 주기적으로 조회되는  DELETE SPRING_SESSION SQL 제외하기 위해 
 * CUSTOM LOGGER 사용 
 */
public class P6spyCustomSlf4JLogger extends FormattedLogger {
	private Logger log;

	public P6spyCustomSlf4JLogger() {
		 log = LoggerFactory.getLogger("p6spy");
	}

	@Override
	public void logException(Exception e) {
		log.info("", e);
	}

	@Override
	public void logText(String text) {
		log.info(text);
	}

	@Override
	public void logSQL(int connectionId, String now, long elapsed, Category category, String prepared, String sql, String url) {
		
		if (sql.isBlank()) return;
		
		// JDBC SPRING SESSION sql 로깅 제외
		if ( sql.contains("SELECT") && sql.contains("SPRING_SESSION")) return;
		if ( sql.contains("INSERT") && sql.contains("SPRING_SESSION")) return;
		if ( sql.contains("UPDATE") && sql.contains("SPRING_SESSION")) return;
    	if ( sql.contains("DELETE") && sql.contains("SPRING_SESSION")) return;
    	
		final String msg = strategy.formatMessage(connectionId, now, elapsed, category.toString(), prepared, sql, url);

		if (Category.ERROR.equals(category)) {
			log.error(msg);
		} else if (Category.WARN.equals(category)) {
			log.warn(msg);
		} else if (Category.DEBUG.equals(category)) {
			log.debug(msg);
		} else {
			log.info(msg);
		}
	}

	@Override
	public boolean isCategoryEnabled(Category category) {
		if (Category.ERROR.equals(category)) {
			return log.isErrorEnabled();
		} else if (Category.WARN.equals(category)) {
			return log.isWarnEnabled();
		} else if (Category.DEBUG.equals(category)) {
			return log.isDebugEnabled();
		} else {
			return log.isInfoEnabled();
		}
	}
}