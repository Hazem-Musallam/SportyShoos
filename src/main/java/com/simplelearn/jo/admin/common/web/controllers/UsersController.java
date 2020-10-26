package com.simplelearn.jo.admin.common.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplelearn.jo.admin.data.UserRoles;
import com.simplelearn.jo.admin.user.entity.User;
import com.simplelearn.jo.admin.user.services.UserService;
import com.simplelearn.jo.admin.web.controller.constant.ControllerConstants;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "search")
	public ModelAndView indexUsers(ModelAndView mav, @RequestParam("nameSearch") String search,
			@PageableDefault(page = 0, size = 10) Pageable page) {
		mav = new ModelAndView(ControllerConstants.VIEW_USERS_INDEX);
		if (search == null || search.isEmpty()) {
			Page<User> findAll = userService.findAllUserRole(page, UserRoles.ROLE_USER);
			mav.addObject("entries", findAll);
		} else {
			Page<User> findAll = userService.findAllUserRoleAndSearch(search, page, UserRoles.ROLE_USER);
			mav.addObject("entries", findAll);
		}

		return mav;
	}
}