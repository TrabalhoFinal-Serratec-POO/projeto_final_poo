package org.serratec.humano;

import java.time.LocalDate;

public class Dependente extends Pessoa {
	private Parentesco parente;
	
	public Dependente(String nome, String cpf, LocalDate localDate, Parentesco parente) {
		super(nome, cpf, localDate);
		this.parente= parente;
     }
}
