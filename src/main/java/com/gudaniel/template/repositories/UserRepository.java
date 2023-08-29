package com.gudaniel.template.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gudaniel.template.entities.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUserName(String userName);
}