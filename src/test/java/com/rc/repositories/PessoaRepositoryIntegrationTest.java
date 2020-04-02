package com.rc.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rc.model.Pessoa;
import com.rc.utilidades.Criptografia;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PessoaRepositoryIntegrationTest {
	private final String nome = "Renato";
	private final String email = "renatomcn@gmail.com";
	private final String senha = "123456";
	
	@Autowired
    private PessoaRepository pessoaRepository;

	@Test
	public void salvarAndEncontrarPorEmailESenha() {		
		Pessoa renato = new Pessoa(null, nome, email, senha, null, false);
		pessoaRepository.save(renato);		
		assertNotNull(renato.getId());
		
		renato = pessoaRepository.findByEmailAndSenha(email, Criptografia.criptografar(senha));
		assertEquals(renato.getNome(), nome);		
	}
	
	// Desncessário, mas bacana para estudo. Na prática teria sido melhor testar o controller
	@Test
	public void salvarEmailInvalido() {		
		final String emailInvalido = "renatomcn";
		Pessoa renato = new Pessoa(null, nome, emailInvalido , Criptografia.criptografar(senha), null, false);
		
		try {
			pessoaRepository.saveAndFlush(renato);	
		} catch (ConstraintViolationException e) {
			
			// Deve ter somente um problema de validação com os dados informados
			assertEquals(1,  e.getConstraintViolations().size());
			
			ConstraintViolation<?> violation = e.getConstraintViolations().iterator().next();
			
			// O erro deve ser no campo e-mail
			assertEquals("email", violation.getPropertyPath().toString());
			
			// O erro deve ser por causa da annotation @Email
			assertEquals(Email.class, violation.getConstraintDescriptor().getAnnotation().annotationType());
			
		}
	}

	
}
