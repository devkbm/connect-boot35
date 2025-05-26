package com.like.system.webresource.domain;

public enum WebResourceType {
		
	IMAGE("이미지");
	
	private String label;
	
	private WebResourceType(final String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}
}
