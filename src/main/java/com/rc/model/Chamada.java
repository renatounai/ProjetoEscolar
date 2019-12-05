package com.rc.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Chamada extends ObjetoPadrao {
	
	@Id
	@EqualsAndHashCode.Include
	private Integer id;	
	
	private LocalDate data;
	
	private Integer aula;
	
	@ManyToOne
	private Semestre semestre;
	
	@ManyToOne
	private Disciplina disciplina;
	
}
