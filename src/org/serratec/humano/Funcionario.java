package org.serratec.humano;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
	private double salarioB, descontoInss, descontoIR;
	private Parentesco parente;

	public Funcionario(String nome, String cpf, LocalDate localDate, double salarioB, double descontoInss,
			double descontoIR) {
		super(nome, cpf, localDate);
		this.salarioB = salarioB;
		this.descontoInss = descontoInss;
		this.descontoIR = descontoIR;
	}

	public double getSalarioB() {
		return salarioB;
	}

	public void setSalarioB(double salarioB) {
		this.salarioB = salarioB;
	}

	public double getDescontoInss() {
		return descontoInss;
	}

	public void setDescontoInss(double descontoInss) {
		this.descontoInss = descontoInss;
	}

	public double getDescontoIR() {
		return descontoIR;
	}

	public void setDescontoIR(double descontoIR) {
		this.descontoIR = descontoIR;
	}

}
