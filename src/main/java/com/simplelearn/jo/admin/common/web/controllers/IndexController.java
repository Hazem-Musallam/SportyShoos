package com.simplelearn.jo.admin.common.web.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplelearn.jo.admin.common.web.form.PurchaseForm;
import com.simplelearn.jo.admin.data.UserRoles;
import com.simplelearn.jo.admin.user.entity.Categories;
import com.simplelearn.jo.admin.user.entity.Products;
import com.simplelearn.jo.admin.user.entity.Purchase;
import com.simplelearn.jo.admin.user.entity.User;
import com.simplelearn.jo.admin.user.services.CategoriesServ;
import com.simplelearn.jo.admin.user.services.ProductServ;
import com.simplelearn.jo.admin.user.services.PurchaseServ;
import com.simplelearn.jo.admin.user.services.UserService;
import com.simplelearn.jo.admin.web.controller.constant.ControllerConstants;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private ProductServ productService;
	@Autowired
	private UserService userService;

	@Autowired
	private PurchaseServ purchaseService;

	@Autowired
	private CategoriesServ catsService;

	@RequestMapping
	public ModelAndView index(ModelAndView mav) {
		mav = new ModelAndView(ControllerConstants.VIEW_INDEX);
		return mav;
	}

	@RequestMapping(value = "products")
	public ModelAndView indexProducts(ModelAndView mav, @PageableDefault(page = 0, size = 10) Pageable page) {
		mav = new ModelAndView(ControllerConstants.VIEW_PRODUCTS_INDEX);
		Page<Products> allPRoducts = productService.findAllByIsDeleted(false, page);
		mav.addObject("entries", allPRoducts);
		return mav;
	}

	@RequestMapping(value = "categories")
	public ModelAndView indexCategories(ModelAndView mav, @PageableDefault(page = 0, size = 10) Pageable page) {
		mav = new ModelAndView(ControllerConstants.VIEW_CATEGORIES_INDEX);
		Page<Categories> allCats = catsService.findAllByIsDeleted(false, page);
		mav.addObject("entries", allCats);
		return mav;
	}

	@RequestMapping(value = "users")
	public ModelAndView indexUsers(ModelAndView mav, @PageableDefault(page = 0, size = 10) Pageable page) {
		mav = new ModelAndView(ControllerConstants.VIEW_USERS_INDEX);
		Page<User> findAll = userService.findAllUserRole(page, UserRoles.ROLE_USER);
		mav.addObject("entries", findAll);

		return mav;
	}

	@RequestMapping(value = "reports")
	public ModelAndView indexReports(ModelAndView mav, @PageableDefault(page = 0, size = 10) Pageable page) {

		mav = new ModelAndView(ControllerConstants.VIEW_REPORTS_INDEX);

		Page<Purchase> findAll = purchaseService.findAll(page);
		mav.addObject("entries", findAll);

		return mav;
	}

	@RequestMapping(value = "reports/search")
	public ModelAndView indexReportsSearch(@RequestParam(name = "date") String dateString, //
			@RequestParam(name = "category") String category, //
			ModelAndView mav, @PageableDefault(page = 0, size = 10000) Pageable page) {
//This Part Can Be Enhanced
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Instant instant = null;
		try {
			date = sp.parse(dateString);
			instant = date.toInstant();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mav = new ModelAndView(ControllerConstants.VIEW_REPORTS_INDEX);

		Page<Purchase> findAll = purchaseService.findSearch(instant, category, page);
		mav.addObject("entries", findAll);

		return mav;
	}

	@RequestMapping(value = "shop")
	public ModelAndView indexShop(@ModelAttribute("form") PurchaseForm form, ModelAndView mav,
			@PageableDefault(page = 0, size = 10) Pageable page) {
		mav = new ModelAndView(ControllerConstants.VIEW_SHOP_INDEX);
		Page<Products> allPRoducts = productService.findAll(page);
		mav.addObject("entries", allPRoducts);
		mav.addObject("form", form);
		return mav;
	}

}