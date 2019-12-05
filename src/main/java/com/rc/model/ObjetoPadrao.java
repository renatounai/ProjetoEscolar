package com.rc.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class ObjetoPadrao {
	
	@Column(updatable = false)
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAlteracao;
	
	@PrePersist
	protected void prePersist() {
		dataCadastro = LocalDateTime.now();
	}
	
	@PreUpdate
	protected void preUpdate() {
		dataAlteracao = LocalDateTime.now();
	}
}
