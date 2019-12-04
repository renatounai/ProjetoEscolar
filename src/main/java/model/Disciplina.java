package model;

import javax.persistence.Column;
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
public class Disciplina extends ObjetoPadrao {
	
	@Id
	@EqualsAndHashCode.Include	
	private Integer id;	
	
	@Column(length = 100)
	private String disciplina;
	
	@ManyToOne
	private Pessoa professor;
	
	
}
