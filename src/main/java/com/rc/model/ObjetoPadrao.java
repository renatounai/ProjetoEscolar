package com.rc.model;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class ObjetoPadrao {
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAlteracao;
}
