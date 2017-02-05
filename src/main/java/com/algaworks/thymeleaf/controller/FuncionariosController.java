package com.algaworks.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.algaworks.thymeleaf.model.Funcionario;
import com.algaworks.thymeleaf.repository.Funcionarios;

@Controller
@RequestMapping("/funcionarios")
public class FuncionariosController {

	@Autowired
	private Funcionarios funcionarios;
	
	@GetMapping
	public String listar(Model model){
		model.addAttribute("funcionarios", funcionarios.findAll());
		return "funcionarios/funcionario-lista.jsp";
	}
	
	@ResponseBody
	@GetMapping("/todos")
	public List<Funcionario> todos(){
		return funcionarios.findAll();
	}
	
	@GetMapping(path="/novo")
	public String novo(Model model){
		model.addAttribute("funcionario", new Funcionario());
		return "funcionarios/funcionario-formulario.jsp"; 
	}
	
	@GetMapping("/{id}/edicao")
	public String edicao(Model model, @PathVariable Long id){
		model.addAttribute("funcionario", funcionarios.findOne(id));
		return "funcionarios/funcionario-formuilario.jsp";
	}
	
	@PostMapping("/salvar")
	public RedirectView salvar(Funcionario funcionario, RedirectAttributes redirectAttributes){
			funcionarios.save(funcionario);
			redirectAttributes.addFlashAttribute("mensagem","Cadastro feito com sucesso!");
			return new RedirectView("/funcionarios", true);
	}

}
