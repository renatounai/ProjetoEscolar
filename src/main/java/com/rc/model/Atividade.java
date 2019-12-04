package com.rc.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
public class Atividade extends ObjetoPadrao {
	
	@Id
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Lob
	private String descricao;
	
	private LocalDateTime dataEntrega;
	
	@ManyToOne
	private SemestreDisciplina semestreDisciplina;
	
}
