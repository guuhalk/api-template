package com.gudaniel.template.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gudaniel.template.entities.models.Profile;
import com.gudaniel.template.services.ProfileService;

@RestController
@RequestMapping("profiles")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Profile>> getProfileById(@PathVariable String id) {
		Optional<Profile> profile = profileService.getProfileById(id);
		return profile != null ? ResponseEntity.ok(profile) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
