package com.simplelearn.jo.admin.health;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class StatusDetails {
	private List<StatusDetails> components;

	private String name;

	private String status;

	private String version;

	public List<StatusDetails> getComponents() {
		return components;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public String getVersion() {
		return version;
	}

	public void setComponents(List<StatusDetails> components) {
		this.components = components;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}