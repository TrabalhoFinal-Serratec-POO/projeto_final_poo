package org.serratec.grupo.humano;

import java.time.LocalDate;

public abstract class Pessoa {
	private String nome, cpf;
	private LocalDate localDate;
	
	public Pessoa(String nome, String cpf, LocalDate localDate) {
		this.nome = nome;
		this.cpf = cpf;
		this.localDate = localDate;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

}