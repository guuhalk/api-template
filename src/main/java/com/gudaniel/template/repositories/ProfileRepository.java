package com.gudaniel.template.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gudaniel.template.entities.models.Profile;


public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
