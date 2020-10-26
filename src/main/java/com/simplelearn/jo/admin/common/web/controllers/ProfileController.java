package com.simplelearn.jo.admin.common.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simplelearn.jo.admin.common.web.form.ProfileForm;
import com.simplelearn.jo.admin.user.entity.User;
import com.simplelearn.jo.admin.user.services.UserService;
import com.simplelearn.jo.admin.web.controller.constant.ControllerConstants;

import io.swagger.v3.oas.annotations.Hidden;

@Controller
@RequestMapping("/profile")
@Hidden
public class ProfileController {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder encoder;

	@GetMapping
	public ModelAndView profile() {
		ModelAndView mav = new ModelAndView(ControllerConstants.VIEW_PROFILE);

		mav.addObject("form", new ProfileForm());
		return mav;
	}

	@PostMapping
	public ModelAndView update(@ModelAttribute("form") ProfileForm form, BindingResult result,
			Authentication authentication) {
		ModelAndView mav = new ModelAndView(ControllerConstants.VIEW_PROFILE);
		User user = userService.findOneByUsername(authentication.getName()).get();

		if (validate(form, user.getPassword(), result)) {
			user.setPassword(form.getNewPassword());
			userService.save(user);
		}

		mav.addObject("form", new ProfileForm());
		mav.addObject("save", true);

		return mav;
	}

	private boolean validate(ProfileForm form, String password, BindingResult result) {
		boolean valid = true;

		if (form.getOldPassword() == null) {
			result.rejectValue(ControllerConstants.FIELD_OLD_PASSWORD, ControllerConstants.ERROR_EMPTY_FIELD);
			return false;
		} else if (!encoder.matches(form.getOldPassword(), password)) {
			result.rejectValue(ControllerConstants.FIELD_OLD_PASSWORD, ControllerConstants.ERROR_WRONG_PASSWORD);
			return false;
		}

		if (form.getNewPassword() == null) {
			result.rejectValue(ControllerConstants.FIELD_NEW_PASSWORD, ControllerConstants.ERROR_EMPTY_FIELD);
			return false;
		}

		return valid;
	}
}