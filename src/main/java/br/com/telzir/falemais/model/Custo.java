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
@Table(name = "custo")
public class Custo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6957346861044331163L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)		
	private Long id;
	
	@Column(name = "origDDD", nullable = false)
	private String origDDD;
	
	@Column(name = "destDDD", nullable = false)
	private String destDDD;
	
	@Column(name = "preco", nullable = false)
	private BigDecimal preco;
	
	public Custo() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getOrigDDD() {
		return origDDD;
	}

	
	public void setOrigDDD(String origDDD) {
		this.origDDD = origDDD;
	}

	
	public String getDestDDD() {
		return destDDD;
	}

	
	public void setDestDDD(String destDDD) {
		this.destDDD = destDDD;
	}

	
	public BigDecimal getPreco() {
		return preco;
	}

	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}
