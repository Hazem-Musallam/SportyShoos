package com.simplelearn.jo.admin.user.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.simplelearn.jo.admin.user.entity.Categories;

public interface CategoriesServ {

	Page<Categories> findAll(Pageable page);

	Categories save(Categories product);

	void remove(Categories product);

	Categories findById(Long key);

	Page<Categories> findAllByIsDeleted(boolean b, Pageable page);

	List<Categories> findAllByIsDeleted(boolean b);

	Categories findByCategoryName(String category);

}
