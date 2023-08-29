package com.gudaniel.template.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gudaniel.template.core.base.BasePage;
import com.gudaniel.template.entities.models.User;
import com.gudaniel.template.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	public BasePage<User> getAllUsers(Pageable pageable) {
		Page<User> listPage = userRepository.findAll(pageable);
		return new BasePage<>(pageable, new PageImpl<>(listPage.getContent(), pageable, listPage.getTotalElements())); 
	}

	public Optional<User> getUserById(Long id) {

		if (id == null) {
			return null;
		}

		Optional<User> user = userRepository.findById(id);
		return user != null  ? user : null;
	}

	public User saveUser(User user) {

		if (user == null) {
			return null;
		}

		user.setPassword(encoder.encode(user.getPassword()));
		User userSaved = userRepository.save(user);

		return userSaved.getName() != null ? user : null;
	}

}