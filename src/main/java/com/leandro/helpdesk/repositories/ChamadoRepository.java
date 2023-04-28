package com.leandro.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
