package com.simplelearn.jo.admin.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplelearn.jo.admin.user.entity.Role;
import com.simplelearn.jo.admin.user.repository.RoleRepository;

@Service
@SuppressWarnings("unused")
public class RoleService extends JpaEntityService<Role> {

	@Autowired
	private RoleRepository repository;

	public Role findByName(String name) {
		return repository.findByName(name);
	}
}