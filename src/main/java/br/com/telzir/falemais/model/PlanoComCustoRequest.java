package br.com.telzir.falemais.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PlanoComCustoRequest {
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -4602970688925940627L;

	@NotBlank(message = "Informe um DDD de Origem")
	private String origem;
	
	@NotBlank(message = "Informe um DDD de Destino")
	private String destino;
	
	@NotNull(message = "Informe o tempo da ligação")
	private BigDecimal tempo;
	
	@NotNull(message = "Selecione um plano")
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
