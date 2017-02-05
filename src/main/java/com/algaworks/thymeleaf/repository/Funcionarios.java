package com.algaworks.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.thymeleaf.model.Funcionario;

public interface Funcionarios extends JpaRepository<Funcionario, Long>{

}
