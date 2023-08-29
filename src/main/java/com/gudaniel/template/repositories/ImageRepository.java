package com.gudaniel.template.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gudaniel.template.entities.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

	public Optional<Image> findByName(String name);

	public Optional<Image> findById(Long Id);

}