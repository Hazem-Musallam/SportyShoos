package com.simplelearn.jo.admin.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplelearn.jo.admin.user.entity.Privilege;
import com.simplelearn.jo.admin.user.repository.PrivilegeRepository;

@Service
@SuppressWarnings("unused")
public class PrivilegeService extends JpaEntityService<Privilege> {

	@Autowired
	private PrivilegeRepository repository;
}