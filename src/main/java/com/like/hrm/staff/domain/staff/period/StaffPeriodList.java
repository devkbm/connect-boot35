package com.like.hrm.staff.domain.staff.period;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.like.hrm.staff.domain.staff.Staff;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class StaffPeriodList {

	@OrderBy("seq asc")
	@OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
	Set<StaffPeriod> periodList = new LinkedHashSet<>();
	
	public Stream<StaffPeriod> getStream() {
		return this.periodList.stream();
	}
	
	public StaffPeriod get(Staff staff, String periodType, Long seq) {
		return this.periodList
				.stream()
				.filter(e -> e.getId().equals(new StaffPeriodId(staff, periodType, seq)))
				.findFirst()
				.orElse(null);
	}
	
	public StaffPeriod getMax(Staff staff, String periodType) {
		return this.periodList
				.stream()			
				.filter(e -> e.getId().getPeriodType().equals(periodType))
				.max((s1, s2) -> Long.compare(s1.getId().getSeq(), s2.getId().getSeq()))				
				.orElse(null);
	}
	
	
	public void add(StaffPeriod period) {
		this.periodList.add(period);
	}
	
	
	long getNextSequence() {
		long maxSeq = 0;
		
		if (this.periodList == null || this.periodList.isEmpty()) {
			maxSeq = 0;
		} else {			
			maxSeq = this.periodList.stream()
							  		.mapToLong(e -> e.getId().getSeq())
							  		.max()
							  		.getAsLong();							 
		}
					
		return maxSeq + 1;
	}
	
}
