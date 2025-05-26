package com.like.hrm.staff.domain.staff.license;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.like.hrm.staff.domain.staff.Staff;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.NoArgsConstructor;

/**
 * 자격면허
 * @author 김병민
 *
 */
@NoArgsConstructor
@Embeddable
public class StaffLicenseList {
	
	@OrderBy("seq asc")
	@OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
	Set<StaffLicense> licenseList = new LinkedHashSet<>();
	
	public Stream<StaffLicense> getStream() {
		return this.licenseList.stream();
	}
	
	public StaffLicense get(Staff staff, Long seq) {		
		return this.licenseList.stream()
							   .filter(e -> e.getId().equals(new StaffLicenseId(staff, seq)))
							   .findFirst()
							   .orElse(null);
	}
	
	public void add(StaffLicense license) {		
		this.licenseList.add(license);
	}	
	
	public void remove(Staff staff, Long seq) {		
		this.licenseList.removeIf(e -> e.getId().equals(new StaffLicenseId(staff, seq)));			
	}
		
	long getNextSequence() {
		long maxSeq = 0;
		
		if (this.licenseList == null || this.licenseList.isEmpty()) {
			maxSeq = 0;
		} else {			
			maxSeq = this.licenseList.stream()
							  		 .mapToLong(e -> e.getId().getSeq())
							  		 .max()
							  		 .getAsLong();							 
		}
					
		return maxSeq + 1;
	}
}
