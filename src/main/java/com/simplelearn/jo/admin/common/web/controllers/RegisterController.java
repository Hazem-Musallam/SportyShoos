package com.simplelearn.jo.admin.common.web.controllers;

import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simplelearn.jo.admin.common.web.form.RegistrationForm;
import com.simplelearn.jo.admin.data.UserRoles;
import com.simplelearn.jo.admin.user.entity.Role;
import com.simplelearn.jo.admin.user.entity.User;
import com.simplelearn.jo.admin.user.services.RoleService;
import com.simplelearn.jo.admin.user.services.UserService;
import com.simplelearn.jo.admin.web.controller.constant.ControllerConstants;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;

	@RequestMapping()
	public ModelAndView indexProducts(ModelAndView mav, @ModelAttribute("form") RegistrationForm form) {
		mav = new ModelAndView(ControllerConstants.VIEW_USERS_REGISTER);

		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addProducts(ModelAndView mav, HttpServletRequest request, //
			@ModelAttribute("form") RegistrationForm form) throws ServletException {

		Role userRole = roleService.findByName(UserRoles.ROLE_USER.name());
		try {
			mav = new ModelAndView(ControllerConstants.VIEW_INDEX);
			User user = new User();
			user.setUsername(form.getUsername());
			user.setPassword(form.getPassword());
			user.setRoles(Arrays.asList(userRole));
			userService.save(user);
			request.login(form.getUsername(), form.getPassword());
		} catch (Exception e) {
			mav = new ModelAndView(ControllerConstants.VIEW_USERS_REGISTER);
			mav.addObject("err", "UserName Used");
		}
		return mav;
	}

}