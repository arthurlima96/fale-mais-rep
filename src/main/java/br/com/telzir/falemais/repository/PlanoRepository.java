package br.com.telzir.falemais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.telzir.falemais.model.Plano;


public interface PlanoRepository extends JpaRepository<Plano, Long>{
	
	public Plano findByNome (String nome);
}
