package org.serratec.humano;

import java.time.LocalDate;

public class Dependente extends Pessoa {
	private Parentesco parente;

	public Dependente(String nome, String cpf, LocalDate localDate, Parentesco parente) {
		super(nome, cpf, localDate);
		this.parente = parente;
	}

	@Override
	public String toString() {
		return super.toString() + "Dependente [parente=" + parente + "]";
	}

	// Sobrescrita dos Métodos: hashCode e equals.

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((parente == null) ? 0 : parente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		// Verificação inicial de cpf ao adicionar o dependente.
		return this.getCpf().equals(((Dependente) obj).getCpf());
	}

}
