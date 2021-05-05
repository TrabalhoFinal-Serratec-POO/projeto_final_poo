package org.serratec.teste;

import java.time.LocalDate;

import org.serratec.humano.Dependente;
import org.serratec.humano.Parentesco;

public class DependenteTeste {
	public static void main(String[] args) {
		Dependente d = new Dependente("Teste", "12345678912", LocalDate.of(2000, 10, 10), Parentesco.FILHO);
		try {
			d.setIdade(18);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
