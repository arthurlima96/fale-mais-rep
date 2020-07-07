package br.com.telzir.falemais.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PlanoComCustoResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2409641606184977975L;
	private String origem;
	private String destino;
	private BigDecimal tempo;
	private String plano;
	private BigDecimal valorComPlano;
	private BigDecimal valorSemPlano;
	
	public PlanoComCustoResponse() {
	}
	
	public PlanoComCustoResponse(String origem, String destino, BigDecimal tempo, String plano, BigDecimal valorComPlano,
		BigDecimal valorSemPlano) {
		this.origem = origem;
		this.destino = destino;
		this.tempo = new BigDecimal(String.valueOf(tempo));
		this.plano = plano;
		this.valorComPlano = valorComPlano;
		this.valorSemPlano = valorSemPlano;
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
	
	public String getPlano() {
		return plano;
	}
	
	public void setPlano(String plano) {
		this.plano = plano;
	}
	
	public BigDecimal getValorComPlano() {
		return valorComPlano;
	}
	
	public void setValorComPlano(BigDecimal valorComPlano) {
		this.valorComPlano = valorComPlano;
	}
	
	public BigDecimal getValorSemPlano() {
		return valorSemPlano;
	}
	
	public void setValorSemPlano(BigDecimal valorSemPlano) {
		this.valorSemPlano = valorSemPlano;
	}

	@Override
	public String toString() {
		return "PlanoComCusto [origem=" + origem + ", destino=" + destino + ", tempo=" + tempo + ", plano=" + plano
				+ ", valorComPlano=" + valorComPlano + ", valorSemPlano=" + valorSemPlano + "]";
	}
}
