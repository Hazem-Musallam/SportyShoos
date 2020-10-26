package com.simplelearn.jo.admin.common.web.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simplelearn.jo.admin.common.web.form.PurchaseForm;
import com.simplelearn.jo.admin.user.entity.Products;
import com.simplelearn.jo.admin.user.entity.Purchase;
import com.simplelearn.jo.admin.user.entity.User;
import com.simplelearn.jo.admin.user.services.ProductServ;
import com.simplelearn.jo.admin.user.services.PurchaseServices;
import com.simplelearn.jo.admin.user.services.UserService;
import com.simplelearn.jo.admin.web.controller.constant.ControllerConstants;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	private ProductServ productService;
	@Autowired
	private UserService userService;
	@Autowired
	private PurchaseServices purchaseService;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addProducts(ModelAndView mav, @ModelAttribute("form") PurchaseForm form, Principal principal) {
		mav = new ModelAndView(ControllerConstants.VIEW_SUCCESS_PURCHASE);
		String name = principal.getName();
		Optional<User> findOneByUsername = userService.findOneByUsername(name);
		User user = findOneByUsername.get();
		List<Products> bookedProducts = new ArrayList<Products>();
		form.getItem().forEach((key, value) -> {
			Products findById = productService.findById(key);
			bookedProducts.add(findById);
		});

		Purchase p = new Purchase();
		p.setUser(user);
		p.setProducts(bookedProducts);
		purchaseService.save(p);

//		user.getUserPurchase().add(p);
//		userService.update(user);

		bookedProducts.forEach(product -> {
			product.getPurchases().add(p);
			productService.save(product);
		});

		return mav;
	}

}