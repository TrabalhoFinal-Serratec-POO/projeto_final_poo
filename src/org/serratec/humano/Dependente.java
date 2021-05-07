package org.serratec.humano;

import java.time.LocalDate;

import org.serratec.excecoes.DepedenteException;

public class Dependente extends Pessoa {
	private Parentesco parente;

	public Dependente(String nome, String cpf, LocalDate localDate, Parentesco parente) {
		super(nome, cpf, localDate);
		this.parente = parente;
	}

	public void setIdade(int idade) throws DepedenteException {
		if (idade < 18) {
			System.out.println("Apto");
		} else {
			throw new DepedenteException();
		}
	}

	@Override
	public String toString() {
		return "Dependente [parente=" + parente + "]";
	}

}
