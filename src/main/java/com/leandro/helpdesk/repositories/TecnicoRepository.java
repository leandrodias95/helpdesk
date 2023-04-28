package com.leandro.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
