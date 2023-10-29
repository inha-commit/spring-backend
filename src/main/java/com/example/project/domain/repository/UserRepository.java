package com.example.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.domain.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {}
