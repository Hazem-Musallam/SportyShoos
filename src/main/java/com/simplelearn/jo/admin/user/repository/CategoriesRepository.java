package com.simplelearn.jo.admin.user.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.simplelearn.jo.admin.user.entity.Categories;

@Repository
public interface CategoriesRepository extends PagingAndSortingRepository<Categories, Long> {

	Page<Categories> findAllByIsDeleted(boolean b, Pageable page);

	List<Categories> findAllByIsDeleted(boolean b);

	Categories findByCategoryName(String category);

}