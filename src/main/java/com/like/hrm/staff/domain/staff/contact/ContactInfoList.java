package com.like.hrm.staff.domain.staff.contact;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class ContactInfoList {

	@OrderBy("CONTACT_TYPE asc")
	@OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
	Set<ContactInfo> contactList = new LinkedHashSet<>();
	
	public Stream<ContactInfo> getStream() {
		return this.contactList.stream();
	}
	
	public void add(ContactInfo contact) {
		this.contactList.add(contact);
	}
	
	public Optional<ContactInfo> get(String type) {
		return this.contactList
				   .stream()	
				   .filter(e -> e.id.type.equals(type))
				   .findFirst();
	}
}
