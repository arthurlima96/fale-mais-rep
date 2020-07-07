package br.com.telzir.falemais.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
				
		Plano buscaFalemais = planoRepository.findByNome(faleMais.getNome());
		
		assertThat(buscaFalemais.getNome())
			.isEqualTo(faleMais.getNome());
	}
	
	@Test
	public void buscaFaleMais60() {
		Plano faleMais = new Plano();
		faleMais.setNome("FaleMais60");
		faleMais.setFranquia(new BigDecimal(60.00));
				
		Plano buscaFalemais = planoRepository.findByNome(faleMais.getNome());
		
		assertThat(buscaFalemais.getNome())
			.isEqualTo(faleMais.getNome());
	}
	
	
	@Test
	public void buscaFaleMais120() {
		Plano faleMais = new Plano();
		faleMais.setNome("FaleMais120");
		faleMais.setFranquia(new BigDecimal(120.00));
				
		Plano buscaFalemais = planoRepository.findByNome(faleMais.getNome());
		
		assertThat(buscaFalemais.getNome())
			.isEqualTo(faleMais.getNome());
	}
	
	@Test
	public void calculaValordaLigacaoCom20minutosPlanoFaleMais30() {
		Plano faleMais = new Plano();
		faleMais.setNome("FaleMais30");
		faleMais.setFranquia(new BigDecimal(30.00));
		
		Plano buscaFalemais = planoRepository.findByNome(faleMais.getNome());
		
		Custo org11dest16 = new Custo();
		org11dest16.setOrigDDD("011");
		org11dest16.setDestDDD("016");
		org11dest16.setPreco(new BigDecimal("1.90"));
		
		BigDecimal tempoLigacao =  new BigDecimal("20.00");
		
		PlanoComCusto planoComCusto = planoRepository
			.calculoValorLigacao("011", "016", buscaFalemais.getId(),tempoLigacao);
		
		BigDecimal valorComPlano = new BigDecimal("0.00");
		BigDecimal valorSemPlano = new BigDecimal("38.00");
		
		assertEquals(planoComCusto.getOrigem(), org11dest16.getOrigDDD());
		assertEquals(planoComCusto.getDestino(), org11dest16.getDestDDD());
		assertEquals(planoComCusto.getTempo(),tempoLigacao);
		assertEquals(planoComCusto.getPlano(),faleMais.getNome());
		assertEquals(planoComCusto.getValorComPlano(), valorComPlano);
		assertEquals(planoComCusto.getValorSemPlano(), valorSemPlano);
	
	}
	
	@Test
	public void calculaValordaLigacaoCom80minutosPlanoFaleMais60() {
		Plano faleMais = new Plano();
		faleMais.setNome("FaleMais60");
		faleMais.setFranquia(new BigDecimal(60.00));
		
		Plano buscaFalemais = planoRepository.findByNome(faleMais.getNome());
		
		Custo org11dest17 = new Custo();
		org11dest17.setOrigDDD("011");
		org11dest17.setDestDDD("017");
		org11dest17.setPreco(new BigDecimal("1.70"));
		
		BigDecimal tempoLigacao =  new BigDecimal("80.00");
		
		PlanoComCusto planoComCusto = planoRepository
			.calculoValorLigacao("011", "017", buscaFalemais.getId(),tempoLigacao);
		
		BigDecimal valorComPlano = new BigDecimal("37.40");
		BigDecimal valorSemPlano = new BigDecimal("136.00");
		
		assertEquals(planoComCusto.getOrigem(), org11dest17.getOrigDDD());
		assertEquals(planoComCusto.getDestino(), org11dest17.getDestDDD());
		assertEquals(planoComCusto.getTempo(),tempoLigacao);
		assertEquals(planoComCusto.getPlano(),faleMais.getNome());
		assertEquals(planoComCusto.getValorComPlano(), valorComPlano);
		assertEquals(planoComCusto.getValorSemPlano(), valorSemPlano);
	
	}
	
	@Test
	public void calculaValordaLigacaoCom200minutosPlanoFaleMais120() {
		Plano faleMais = new Plano();
		faleMais.setNome("FaleMais120");
		faleMais.setFranquia(new BigDecimal(120.00));
		
		Plano buscaFalemais = planoRepository.findByNome(faleMais.getNome());
		
		Custo org18dest11 = new Custo();
		org18dest11.setOrigDDD("018");
		org18dest11.setDestDDD("011");
		org18dest11.setPreco(new BigDecimal("1.90"));
		
		BigDecimal tempoLigacao =  new BigDecimal("200.00");
		
		PlanoComCusto planoComCusto = planoRepository
			.calculoValorLigacao("018", "011", buscaFalemais.getId(),tempoLigacao);
		
		BigDecimal valorComPlano = new BigDecimal("167.20");
		BigDecimal valorSemPlano = new BigDecimal("380.00");
		
		assertEquals(planoComCusto.getOrigem(), org18dest11.getOrigDDD());
		assertEquals(planoComCusto.getDestino(), org18dest11.getDestDDD());
		assertEquals(planoComCusto.getTempo(),tempoLigacao);
		assertEquals(planoComCusto.getPlano(),faleMais.getNome());
		assertEquals(planoComCusto.getValorComPlano(), valorComPlano);
		assertEquals(planoComCusto.getValorSemPlano(), valorSemPlano);
	
	}
	
	@Test
	public void calculaValordaLigacaoCom100minutosPlanoFaleMais30() {
		Plano faleMais = new Plano();
		faleMais.setNome("FaleMais30");
		faleMais.setFranquia(new BigDecimal(30.00));
		
		Plano buscaFalemais = planoRepository.findByNome(faleMais.getNome());
		
		Custo org18dest17 = new Custo();
		org18dest17.setOrigDDD("018");
		org18dest17.setDestDDD("017");
		
		BigDecimal tempoLigacao =  new BigDecimal("100.00");
		
		PlanoComCusto planoComCusto = planoRepository
			.calculoValorLigacao("018", "017", buscaFalemais.getId(),tempoLigacao);
		
		assertNull(planoComCusto);
	}
}
