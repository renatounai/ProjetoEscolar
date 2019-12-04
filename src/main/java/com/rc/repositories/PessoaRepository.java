package com.rc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rc.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
