package com.like.common.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class LocalDateTimePeriod implements Serializable {
		
	private static final long serialVersionUID = 7878134378918877300L;

	@Column(name="FROM_DT")
	private LocalDateTime from;
	
	@Column(name="TO_DT")
	private LocalDateTime to;
	
	
	public LocalDateTimePeriod(LocalDateTime from, LocalDateTime to) {
		this.from = from;
		this.to = to;
		
		if (!isValid()) {
			throw new IllegalArgumentException(		
				String.format(
						"시작일시[%s]가 종료일시[%s]보다 클 수 없습니다.",
						from.toString(),
						to.toString()
						)
			);
		}	
	}
	
	
	public LocalDateTimePeriod(LocalDate from, LocalDate to) {
		this.from = from.atStartOfDay();
		this.to = to.atTime(23, 59, 59);
		
		if (!isValid()) {
			throw new IllegalArgumentException(		
				String.format(
						"시작일시[%s]가 종료일시[%s]보다 클 수 없습니다.",
						from.toString(),
						to.toString()
						)
			);
		}	
	}
	
	private boolean isValid() {		
		return from.isAfter(to) ? false : true;
	}
}
