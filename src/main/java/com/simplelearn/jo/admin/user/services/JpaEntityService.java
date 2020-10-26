package com.simplelearn.jo.admin.user.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.simplelearn.jo.admin.user.entity.JpaEntity;
import com.simplelearn.jo.admin.user.repository.JpaEntityRepository;

@Service
public class JpaEntityService<T extends JpaEntity> {
	
	@Autowired
	JpaEntityRepository<T> repository;
	
	public long count() {
		return repository.count();
	}

	public long count(Example<T> example) {
		return repository.count(example);
	}

	public void delete(T entity) {
		repository.delete(entity);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public void deleteAll(Iterable<? extends T> entities) {
		repository.deleteAll(entities);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public boolean exists(Example<T> example) {
		return repository.exists(example);
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	public List<T> findAll() {
		return repository.findAll();
	}

	public List<T> findAll(Example<T> example) {
		return repository.findAll(example);
	}

	public Page<T> findAll(Example<T> example, Pageable pageable) {
		return repository.findAll(example, pageable);
	}

	public Page<T> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public List<T> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	public List<T> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}


	public Optional<T> findById(Long id) {
		return repository.findById(id);
	}

	public Optional<T> findOne(Example<T> example) {
		return repository.findOne(example);
	}

	public T save(T entity) {
		return repository.save(entity);
	}
}