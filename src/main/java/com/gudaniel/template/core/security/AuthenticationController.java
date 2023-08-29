package com.gudaniel.template.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gudaniel.template.entities.dtos.UserTokenDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<String> AuthenticateFromApi(@RequestBody @Valid UserTokenDto userToken){
		try {
			var token = new UsernamePasswordAuthenticationToken(userToken.getUserName(), userToken.getPassword());
			var authentication = manager.authenticate(token); 				
			return ResponseEntity.ok(tokenService.generateToken(authentication.getName()));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
	}
}
