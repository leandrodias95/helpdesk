package com.leandro.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leandro.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
