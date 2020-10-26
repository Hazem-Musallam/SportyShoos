package com.simplelearn.jo.admin.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.simplelearn.jo.admin.user.entity.Categories;
import com.simplelearn.jo.admin.user.repository.CategoriesRepository;

@Service
public class CategoriesServices implements CategoriesServ {
	@Autowired
	private CategoriesRepository categoriesServices;

	@Override
	public Page<Categories> findAll(Pageable page) {
		return categoriesServices.findAll(page);
	}

	@Override
	public Categories save(Categories product) {
		return categoriesServices.save(product);
	}

	@Override
	public void remove(Categories product) {
		categoriesServices.delete(product);
	}

	@Override
	public Categories findById(Long id) {
		return categoriesServices.findById(id).get();
	}

	@Override
	public Page<Categories> findAllByIsDeleted(boolean b, Pageable page) {
		return categoriesServices.findAllByIsDeleted(b, page);
	}

	@Override
	public List<Categories> findAllByIsDeleted(boolean b) {
		return categoriesServices.findAllByIsDeleted(false);
	}

	@Override
	public Categories findByCategoryName(String category) {
		// TODO Auto-generated method stub
		return categoriesServices.findByCategoryName(category);
	}

}
