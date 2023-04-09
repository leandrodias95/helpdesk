package com.leandro.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leandro.helpdesk.domain.enums.Perfil;

@Entity
public abstract class Pessoa implements Serializable { //implements Serializable serve para que o codigo seja convertido em bits para ser
	//trafegados na internet
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String nome;
	@Column(unique = true)
	protected String cpf;
	@Column(unique = true)
	protected String email;
	protected String senha;
	@ElementCollection(fetch = FetchType.EAGER)//aseguro que a lista perfil vira junto com o usuário
	@CollectionTable(name= "PERFIS") //la no banco de dados terá uma tabela com o nome Perfis, que ontem a lista de usuários
	protected Set<Integer> perfis = new HashSet<>(); //hashset não permite ponteiro nulo, já o set não permite que tenham perfis repetidos
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	public Pessoa() {
		super();
		addPerfil(Perfil.CLIENTE);
	}
	public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		addPerfil(Perfil.CLIENTE);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet()); //mapeando e chamando o perfil
	}
	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo()); //não passa o valor direto, adiciona os valores na lista
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
	
	
}
