package com.algaworks.thymeleaf.resouce.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.thymeleaf.model.Funcionario;
import com.algaworks.thymeleaf.repository.Funcionarios;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionariosResouce {

	@Autowired
	private Funcionarios funcionariosService;

	@GetMapping("/todos")
	public List<Funcionario> todos(){
		return funcionariosService.findAll();
	}
	
	@GetMapping("/{id}")
	public Funcionario buscar(@PathVariable Long id){
		return funcionariosService.findOne(id);
	}
}
