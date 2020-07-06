package br.com.telzir.falemais.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.telzir.falemais.model.Custo;
import br.com.telzir.falemais.model.Plano;
import br.com.telzir.falemais.model.PlanoComCusto;

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
	
	@Test
	public void calculaValordaLigacaoCom80minutosPlanoFaleMais60() {
		Plano faleMais = new Plano();
		faleMais.setNome("FaleMais60");
		faleMais.setFranquia(new BigDecimal(60.00));
		entityManager.persist(faleMais);
		
		Custo org11dest17 = new Custo();
		org11dest17.setOrigDDD("011");
		org11dest17.setDestDDD("017");
		org11dest17.setPreco(new BigDecimal("1.70"));
		entityManager.persist(org11dest17);
		
		entityManager.flush();
		
		BigDecimal tempoLigacao =  new BigDecimal("80.00");
		
		PlanoComCusto planoComCusto = planoRepository
			.calculoValorLigacao("011", "017", faleMais.getId(),tempoLigacao);
		
		BigDecimal valorComPlano = new BigDecimal("37.40");
		BigDecimal valorSemPlano = new BigDecimal("136.00");
		
		assertEquals(planoComCusto.getOrigem(), org11dest17.getOrigDDD());
		assertEquals(planoComCusto.getDestino(), org11dest17.getDestDDD());
		assertEquals(planoComCusto.getTempo(),tempoLigacao);
		assertEquals(planoComCusto.getPlano(),faleMais.getNome());
		assertEquals(planoComCusto.getValorComPlano(), valorComPlano);
		assertEquals(planoComCusto.getValorSemPlano(), valorSemPlano);
	
	}
}
