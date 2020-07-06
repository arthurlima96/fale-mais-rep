package br.com.telzir.falemais.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.telzir.falemais.model.Plano;
import br.com.telzir.falemais.model.PlanoComCusto;


public interface PlanoRepository extends JpaRepository<Plano, Long>{
	
	public Plano findByNome (String nome);
	
	@Query(value = 
	          "SELECT new br.com.telzir.falemais.model.PlanoComCusto( "
	        + "c.origDDD, "
			+ "c.destDDD, "
			+ "CAST(:tempoLigacao AS big_decimal), "
			+ "p.nome,"
			+ "CAST(CASE WHEN :tempoLigacao <= p.franquia THEN 0 ELSE ROUND(((:tempoLigacao - p.franquia) * c.preco + (((:tempoLigacao - p.franquia) * c.preco * 10)/100)),2) END AS big_decimal),"
			+ "CAST(ROUND(:tempoLigacao * c.preco,2) AS big_decimal)) "
			+ "FROM Custo c, Plano p where "
			+ "c.origDDD = :origemDDD AND "
			+ "c.destDDD = :destinoDDD AND p.id = :planoId")
	public PlanoComCusto calculoValorLigacao(@Param("origemDDD")String origem,@Param("destinoDDD") String destino,@Param("planoId") Long planoId,@Param("tempoLigacao") BigDecimal tempoLigacao);
}
