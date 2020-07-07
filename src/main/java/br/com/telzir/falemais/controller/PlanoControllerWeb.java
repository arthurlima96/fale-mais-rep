package br.com.telzir.falemais.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.telzir.falemais.model.Plano;
import br.com.telzir.falemais.model.PlanoComCustoRequest;
import br.com.telzir.falemais.model.PlanoComCustoResponse;
import br.com.telzir.falemais.repository.PlanoRepository;

@Controller
public class PlanoControllerWeb {
	
	@Autowired
	private PlanoRepository planoRepository;
	
	@GetMapping("/")
	public String formSimulaao(@ModelAttribute("planoComCustoRQ") PlanoComCustoRequest planoForm, Model model) {
		Collection<Plano> planos = planoRepository.findAll();
		model.addAttribute("planos", planos);
		return "index";
	}
	
	@PostMapping("/simulacao")
	public String calculoValorLigacao(@Valid @ModelAttribute("planoComCustoRQ")PlanoComCustoRequest planoComCustoRQ, BindingResult result,
		Model model) {
		 if (result.hasErrors()) {
	            return "index";
	        }
		PlanoComCustoResponse planoComCusto = planoRepository
			.calculoValorLigacao(
				planoComCustoRQ.getOrigem(), planoComCustoRQ.getDestino(), planoComCustoRQ.getPlanoId(),
				planoComCustoRQ.getTempo()
			);
		
		model.addAttribute("planoComCusto", planoComCusto);
		return "result-simulacao";
	}
}
