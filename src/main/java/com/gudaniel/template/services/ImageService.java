package com.gudaniel.template.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gudaniel.template.entities.models.Image;
import com.gudaniel.template.repositories.ImageRepository;

@Service
public class ImageService {

	final String pathImage = "CAMINHO ONDE ESTA AS FOTOS";

	@Autowired
	private ImageRepository imgRepository;

	public Optional<Image> getImageById(Long id) {

		if (id != null) {
			return imgRepository.findById(id);
		} else {
			return null;
		}

	}

	public Optional<Image> saveImage(MultipartFile arquivo) {
		try {
			Path caminho = Paths.get(pathImage + arquivo.getOriginalFilename());
			Files.write(caminho, arquivo.getBytes());

			Image img = new Image();
			img.setName(arquivo.getOriginalFilename());
			img.setPath(caminho.toString());

			imgRepository.save(img);

			Optional<Image> imageSaved = imgRepository.findByName(img.getName());
			return imageSaved.isPresent() ? imageSaved : null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
