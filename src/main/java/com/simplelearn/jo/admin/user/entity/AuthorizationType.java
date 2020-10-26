package com.simplelearn.jo.admin.user.entity;

public enum AuthorizationType {

	BEARER("Bearer"), BASIC("Basic");

	private String value;

	AuthorizationType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public String getAuthorization(String suffix) {
		return this.value + " " + suffix;
	}
}