package com.simplelearn.jo.admin.common.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simplelearn.jo.admin.common.web.form.ProductForm;
import com.simplelearn.jo.admin.web.controller.constant.ControllerConstants;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping
	public ModelAndView indexProducts(ModelAndView mav, @ModelAttribute("form") ProductForm form) {
		mav = new ModelAndView(ControllerConstants.VIEW_LOGIN_INDEX);

		return mav;
	}

}