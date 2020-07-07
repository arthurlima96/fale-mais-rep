package br.com.telzir.falemais.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.telzir.falemais.model.Plano;
import br.com.telzir.falemais.model.PlanoComCustoRequest;
import br.com.telzir.falemais.model.PlanoComCustoResponse;
import br.com.telzir.falemais.repository.PlanoRepository;

@RestController
@RequestMapping("/plano")
public class PlanoController {
	
	@Autowired
	private PlanoRepository planoRepository;
	
	@GetMapping("/")
	public Collection<Plano> findPlanos() {
		return planoRepository.findAll();
	}
	
	@PostMapping(
		name = "/simulacao",
		produces = MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Map<String,Object>> calculoValorLigacao(@Valid @RequestBody PlanoComCustoRequest planoComCustoRQ) {
		PlanoComCustoResponse planoComCustoRP = planoRepository.calculoValorLigacao(
			planoComCustoRQ.getOrigem(), planoComCustoRQ.getDestino(), planoComCustoRQ.getPlanoId(),
			planoComCustoRQ.getTempo()
		);
		Map<String,Object> response = new HashMap<>();
		if (planoComCustoRP != null) {
			response.put("result", planoComCustoRP);
			return ResponseEntity.ok(response);
		}
		response.put("error", "Não existe tarifa para a Origem e Destino informado!");
		return ResponseEntity.badRequest().body(response);
	}
}
