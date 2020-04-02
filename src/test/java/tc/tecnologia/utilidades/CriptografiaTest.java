package tc.tecnologia.utilidades;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.rc.utilidades.Criptografia;

@RunWith(SpringRunner.class)
public class CriptografiaTest {
	
	@Test
	public void criptografar() {
		final String texto = "renato";
		final String textoEsperado = "renato";
		
		assertThat(Criptografia.criptografar(texto)).isEqualTo(textoEsperado);
	}
}
