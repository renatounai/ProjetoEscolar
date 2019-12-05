package com.rc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rc.model.Pessoa;
import com.rc.repositories.PessoaRepository;

@RestController
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Transactional()
	@GetMapping("/pessoa/{id}")
	private Pessoa pessoa(String id) {
		System.out.println("Id: " + pessoaRepository);
		return pessoaRepository.findById(Integer.parseInt(id)).get();
	}
	
	@Transactional()
	@GetMapping("/teste")
	public String teste() {
		Pessoa pessoa = new Pessoa();
		pessoa.setName("Renato");
		pessoaRepository.save(pessoa);
		System.out.println("salvei o miserável!");
		return "nosaaaaaaaa!";
	}
}
