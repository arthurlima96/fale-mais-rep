package br.com.telzir.falemais.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plano")
public class Plano implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3780787055890155454L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "franquia", nullable = false)
	private BigDecimal franquia;
	
	@Column(name = "obs")
	private String obs;
}
