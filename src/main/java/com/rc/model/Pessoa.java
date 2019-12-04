package com.rc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa extends ObjetoPadrao {
	
	@Id
	@EqualsAndHashCode.Include
	private Integer id;	
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 100)
	private String email;
	
	@Column(length = 100)
	private String senha;
	
	@Column(length = 15)
	private String telefone;
		
}
