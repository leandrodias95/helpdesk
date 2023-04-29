package com.leandro.helpdesk.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.helpdesk.domain.Chamado;
import com.leandro.helpdesk.domain.Cliente;
import com.leandro.helpdesk.domain.Tecnico;
import com.leandro.helpdesk.domain.enums.Perfil;
import com.leandro.helpdesk.domain.enums.Prioridade;
import com.leandro.helpdesk.domain.enums.Status;
import com.leandro.helpdesk.repositories.ChamadoRepository;
import com.leandro.helpdesk.repositories.ClienteRepository;
import com.leandro.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Valdir Cesar", "37136865646", "valdircesar@email.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Tolvards", "20948399317", "tolvards@email.com", "123");
		cli1.addPerfil(Perfil.CLIENTE);
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1)); //estou passando e  salvando uma lista
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
