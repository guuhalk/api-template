package com.gudaniel.template.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudaniel.template.entities.models.Profile;
import com.gudaniel.template.repositories.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	public Optional<Profile> getProfileById(String id) {

		if (id == null || id.isEmpty()) {
			return null;
		}

		Optional<Profile> profile = profileRepository.findById(Long.parseLong(id));
		return profile.isPresent() ? profile : null;
	}
	
	
}



