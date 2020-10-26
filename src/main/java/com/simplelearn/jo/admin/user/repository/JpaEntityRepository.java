package com.simplelearn.jo.admin.user.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplelearn.jo.admin.user.entity.JpaEntity;

@Primary
public interface JpaEntityRepository<T extends JpaEntity> extends JpaRepository<T, Long> {
}