package com.rc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rc.model.Pessoa;
import com.rc.repositories.PessoaRepository;

@RestController
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping("/pessoa/:id")
	private Pessoa pessoa(int id) {
		return pessoaRepository.findById(id).get();
	}
}
