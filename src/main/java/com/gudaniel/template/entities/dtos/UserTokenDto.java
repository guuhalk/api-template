package com.gudaniel.template.entities.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserTokenDto {
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String password;
}