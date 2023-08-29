package com.gudaniel.template.entities.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SYS_IMAGE")
public class Image {

	@Id
	@GeneratedValue
	@Column(name = "IMG_ID")
	private Long idImage;

	@Column(name = "IMG_NOME")
	private String name;

	@Column(name = "IMG_PATH")
	private String path;

}