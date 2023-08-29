package com.gudaniel.template.entities.dtos;

import lombok.Data;

@Data
public class UserDto {

	private Long idUser;
	private String userName;
	private String name;
	private String email;
	private Integer status;
	private Integer idImagem;
	private String token;
	private Integer profile;

}