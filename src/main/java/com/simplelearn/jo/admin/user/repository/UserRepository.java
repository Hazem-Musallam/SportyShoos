package com.simplelearn.jo.admin.user.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.simplelearn.jo.admin.user.entity.User;

@Repository
public interface UserRepository extends JpaEntityRepository<User> {

	Optional<User> findOneByUsername(String username);

	Page<User> findAllByRolesNameIgnoreCase(String name, Pageable page);

	Page<User> findAllByUsernameIgnoreCaseAndRolesNameIgnoreCase(String search, String name, Pageable page);
}