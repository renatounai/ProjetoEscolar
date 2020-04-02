package com.rc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.rc.model.Pessoa;
import com.rc.repositories.PessoaRepository;

@Repository
public class PessoaService implements UserDetailsService  {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Pessoa pessoa = pessoaRepository.findByEmail(email);
		
		if (pessoa == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		
		return pessoa;
	}

}
