package model;

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
public class Semestre extends ObjetoPadrao {
	
	@Id
	@EqualsAndHashCode.Include
	private Integer id;	
	
	private Integer ano;
	
	private Integer semestre;
	
}
