package com.gudaniel.template.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gudaniel.template.entities.models.Image;
import com.gudaniel.template.entities.models.User;
import com.gudaniel.template.services.ImageService;
import com.gudaniel.template.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ImageService imageService;

	@GetMapping
	public ResponseEntity<Page<User>> getAllUsers(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		Page<User> userPage = userService.getAllUsers(pageable);
		return userPage.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<Page<User>>(userPage, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> get(@PathVariable Long id) {
		Optional<User> user = userService.getUserById(id);
		return user != null ? ResponseEntity.ok(user) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/photo/{id}")
	public ResponseEntity<Optional<Image>> getImageById(@PathVariable Long id) {
		Optional<Image> image = imageService.getImageById(id);
		return image != null ? ResponseEntity.ok(image) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/photos")
	public ResponseEntity<?> savePhotoUser(@RequestParam("file") MultipartFile arquivo) {
		Optional<Image> img = imageService.saveImage(arquivo);
		return img != null ? ResponseEntity.ok(img) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		User UserSaved = userService.saveUser(user);
		return UserSaved != null ? ResponseEntity.ok(UserSaved) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

}
