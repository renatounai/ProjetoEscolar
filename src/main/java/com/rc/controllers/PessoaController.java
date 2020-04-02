package com.rc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rc.model.Pessoa;
import com.rc.repositories.PessoaRepository;

@RestController()
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> pessoa(@PathVariable int id) {
		return pessoaRepository.findById(id).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                							.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@Transactional()
	@PostMapping()
	public void salvar(@Valid @RequestBody Pessoa pessoa) {		
		pessoaRepository.save(pessoa);		
	}
	
	@GetMapping
	public List<Pessoa> lista() {
		return pessoaRepository.findAll();
	}
	
	@Transactional()
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		if (pessoaRepository.existsById(id))
			pessoaRepository.deleteById(id);
	}
}
