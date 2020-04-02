package com.rc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class SemestreAluno extends ObjetoPadrao {
	
	@Id
	@EqualsAndHashCode.Include	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	@ManyToOne
	@JoinColumn(name = "semestre")
	private Semestre semestre;
	
	@ManyToOne
	@JoinColumn(name = "aluno")
	private Pessoa aluno;
	
}
