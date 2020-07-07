package br.com.telzir.falemais.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.telzir.falemais.model.Plano;
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
}
