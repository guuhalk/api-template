package com.gudaniel.template.base;

import java.util.Optional;

import com.gudaniel.template.entities.dtos.UserDto;
import com.gudaniel.template.entities.models.User;

public class MocksUtils {

	public static User mockUser() {
		User usu = new User();
		usu.setId(1L);
		usu.setUserName("gustavo.daniel");
		usu.setPassword("admin");
		usu.setName("Gustavo Daniel");
		usu.setEmail("gustavo.daniel@teste.com.br");
		usu.setStatus(1);
		usu.setIdImagem(1);
		usu.setProfile(1);
		return usu;
	}

	public static UserDto mockUserDto() {
		UserDto usuDto = new UserDto();
		usuDto.setIdUser(1L);
		usuDto.setUserName("gustavo.daniel");
		usuDto.setName("Gustavo Daniel");
		usuDto.setEmail("gustavo.daniel@teste.com.br");
		usuDto.setStatus(1);
		usuDto.setIdImagem(1);
		usuDto.setProfile(1);
		return usuDto;
	}
	
	public static Optional<User> mockOptionalUser() {
		return Optional.of(mockUser()); 
	}
	
	
	

}
