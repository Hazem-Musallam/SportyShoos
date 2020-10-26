package com.simplelearn.jo.admin.common.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simplelearn.jo.admin.common.web.form.ProductForm;
import com.simplelearn.jo.admin.user.entity.Categories;
import com.simplelearn.jo.admin.user.entity.Products;
import com.simplelearn.jo.admin.user.services.CategoriesServ;
import com.simplelearn.jo.admin.user.services.ProductServ;
import com.simplelearn.jo.admin.web.controller.constant.ControllerConstants;

@Controller
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private ProductServ productService;
	@Autowired
	private CategoriesServ categoriesService;

	@RequestMapping(value = "add")
	public ModelAndView indexProducts(ModelAndView mav, @ModelAttribute("form") ProductForm form) {
		mav = new ModelAndView(ControllerConstants.VIEW_PRODUCTS_ADD);
		List<Categories> allCategories = categoriesService.findAllByIsDeleted(false);
		mav.addObject("categoies", allCategories);

		return mav;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView addProducts(ModelAndView mav, @ModelAttribute("form") ProductForm form) {
		mav = new ModelAndView(ControllerConstants.VIEW_PRODUCTS_ADD);
		Products product = new Products();
		product.setPrice(form.getPrice());
		product.setProductName(form.getProductName());
		Categories cat = categoriesService.findById(form.getCategory());
		product.getCategories().add(cat);
		productService.save(product);
		mav.addObject("save", true);
		form = new ProductForm();
		mav.addObject("form", form);
		List<Categories> allCategories = categoriesService.findAllByIsDeleted(false);
		mav.addObject("categoies", allCategories);

		return mav;
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView getProducts(@PathVariable("id") Products product, ModelAndView mav,
			@ModelAttribute("form") ProductForm form) {
		mav = new ModelAndView(ControllerConstants.VIEW_PRODUCTS_EDIT);
		form.setId(product.getId());
		form.setCategory(product.getCategories().get(0).getId());
		form.setPrice(product.getPrice());
		form.setProductName(product.getProductName());
		mav.addObject("form", form);
		List<Categories> allCategories = categoriesService.findAllByIsDeleted(false);
		mav.addObject("categoies", allCategories);
		return mav;
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public ModelAndView editProducts(ModelAndView mav, @ModelAttribute("form") ProductForm form) {
		mav = new ModelAndView(ControllerConstants.VIEW_PRODUCTS_EDIT);
		Products product = new Products();
		product.setId(form.getId());
		product.setProductName(form.getProductName());
		product.setPrice(form.getPrice());
		Categories cat = categoriesService.findById(form.getCategory());
		product.getCategories().add(cat);
		productService.save(product);
		mav.addObject("save", true);
		List<Categories> allCategories = categoriesService.findAllByIsDeleted(false);
		mav.addObject("categoies", allCategories);
		mav.addObject("form", form);
		return mav;
	}

	@GetMapping(value = "delete/{id}")
	public ModelAndView deleteProducts(@PathVariable("id") Products product, ModelAndView mav,
			@ModelAttribute("form") ProductForm form, @PageableDefault(page = 0, size = 10) Pageable page) {
		mav = new ModelAndView(ControllerConstants.VIEW_PRODUCTS_INDEX);
		productService.remove(product);
		Page<Products> allPRoducts = productService.findAllByIsDeleted(false, page);
		mav.addObject("entries", allPRoducts);
		return mav;
	}
}