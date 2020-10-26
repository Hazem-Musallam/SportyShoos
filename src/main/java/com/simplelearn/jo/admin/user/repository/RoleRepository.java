package com.simplelearn.jo.admin.user.repository;

import org.springframework.stereotype.Repository;

import com.simplelearn.jo.admin.user.entity.Role;

@Repository
public interface RoleRepository extends JpaEntityRepository<Role> {

	Role findByName(String name);

}