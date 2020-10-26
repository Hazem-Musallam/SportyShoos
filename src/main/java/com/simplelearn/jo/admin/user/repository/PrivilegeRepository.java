package com.simplelearn.jo.admin.user.repository;

import org.springframework.stereotype.Repository;

import com.simplelearn.jo.admin.user.entity.Privilege;

@Repository
public interface PrivilegeRepository extends JpaEntityRepository<Privilege> {

}