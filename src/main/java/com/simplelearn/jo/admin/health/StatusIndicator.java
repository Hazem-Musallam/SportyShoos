package com.simplelearn.jo.admin.health;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@RequestMapping("/api/wof/v1/status")
@Hidden
public class StatusIndicator {

	final static String OK = "ok";
	final static String KO = "ko";

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public StatusDetails health(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		boolean inUp = ping(inEndpoint);
		boolean inUp = true;
		List<StatusDetails> componentDetails = new ArrayList<>();

		StatusDetails main = new StatusDetails();
		main.setName("Wheel of Fortune");
		main.setStatus(inUp ? OK : KO);
		main.setVersion("1.0");

		main.setComponents(componentDetails);

		return main;
	}
}