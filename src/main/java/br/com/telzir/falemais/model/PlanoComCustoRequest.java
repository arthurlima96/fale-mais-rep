package br.com.telzir.falemais.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PlanoComCustoRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4602970688925940627L;

	private String origem;
	
	private String destino;
	
	private BigDecimal tempo;
	
	private Long planoId;
	
	public PlanoComCustoRequest() {
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public BigDecimal getTempo() {
		return tempo;
	}
	
	public void setTempo(BigDecimal tempo) {
		this.tempo = tempo;
	}
	
	public Long getPlanoId() {
		return planoId;
	}
	
	public void setPlanoId(Long planoId) {
		this.planoId = planoId;
	}
	
}
