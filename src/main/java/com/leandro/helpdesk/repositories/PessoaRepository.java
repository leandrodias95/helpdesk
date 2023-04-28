package com.leandro.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
