package com.simplelearn.jo.admin.data;

import java.time.Instant;

import org.springframework.stereotype.Component;

@Component
public class ApplicationAttributes {

	private Instant currentDate;

	public Instant getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Instant currentDate) {
		this.currentDate = currentDate;
	}
}