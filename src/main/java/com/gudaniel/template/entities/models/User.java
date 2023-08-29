package com.gudaniel.template.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SYS_USUARIO")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USU_ID")
	private Long id;

	@Column(name = "USU_LOGIN")
	private String userName;

	@Column(name = "USU_SENHA")
	private String password;

	@Column(name = "USU_NOME")
	private String name;

	@Column(name = "USU_EMAIL")
	private String email;

	@Column(name = "USU_STATUS")
	private Integer status;

	@Column(name = "USU_IDIMAGEM")
	private Integer idImagem;

	@JoinColumn(name = "USUPRF_ID")
	private Integer profile;
}