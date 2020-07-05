package br.com.telzir.falemais.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.telzir.falemais.model.Plano;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
public class PlanoRepositoryTest {
	
	@Autowired
	private PlanoRepository planoRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void buscaFaleMais30() {
		 Plano faleMais = new Plano();
		 faleMais.setNome("FaleMais30");
		 faleMais.setFranquia(new BigDecimal(30.00));
		    
		 entityManager.persist(faleMais);
		 entityManager.flush();
		 
		  Plano buscaFalemais = planoRepository.findByNome(faleMais.getNome());
		 
		  assertThat(buscaFalemais.getNome())
		      .isEqualTo(faleMais.getNome());
	}
}
