package org.serratec.humano;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Funcionario extends Pessoa {
	private double salarioB, descontoInss, descontoIR;
	private Set<Dependente> dependentes = new HashSet<Dependente>();

	public Funcionario(String nome, String cpf, LocalDate localDate, double salarioB) {
		super(nome, cpf, localDate);
		this.salarioB = salarioB;
	}

	public Set<Dependente> getDependentes() {
		return dependentes;
	}

	public boolean setDependentes(Dependente dependentes) {
		return this.dependentes.add(dependentes);
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

	public void setDescontoInss() {
		if (salarioB < 1100.01) {
			descontoInss = salarioB * .075;
		} else if (salarioB < 2203.49) {
			descontoInss = salarioB * .09 - 16.5;
		} else if (salarioB < 3305.23) {
			descontoInss = salarioB * .12 - 82.61;
		} else if (salarioB < 6433.58) {
			descontoInss = salarioB * .14 - 148.72;
		} else {
			descontoInss = 751.98;
		}
	}

	public double getDescontoIR() {
		return descontoIR;
	}

	public void setDescontoIR() {
		double dep;
		if (getDescontoInss() == 0) {
			setDescontoInss();
		}
		if (dependentes == null) {
			dep = 0;
		} else {
			dep = dependentes.size() * 189.59;
		}

		double salarioBase = salarioB - dep - descontoInss;
		if (salarioBase < 1903.99) {
			descontoIR = 0;
		} else if (salarioBase < 2826.66) {
			descontoIR = salarioBase * .075 - 142.8;
		} else if (salarioBase < 3751.06) {
			descontoIR = salarioBase * .15 - 354.8;
		} else if (salarioBase < 4664.68) {
			descontoIR = salarioBase * .225 - 636.13;
		} else {
			descontoIR = salarioBase * .275 - 869.36;
		}
	}

	@Override
	public String toString() {
		return this.getNome() + ";" + this.getCpf() + ";" + String.format("%.2f", descontoInss) + ";"
				+ String.format("%.2f", descontoIR) + ";"
				+ String.format("%.2f", (salarioB - descontoInss - descontoIR)) + this.getDependentes();
	}

	// Sobrescrita dos Métodos: hashCode e equals.

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dependentes == null) ? 0 : dependentes.hashCode());
		long temp;
		temp = Double.doubleToLongBits(descontoIR);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(descontoInss);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(salarioB);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		// Verificação inicial de cpf ao adicionar o funcionario.
		return this.getCpf().equals(((Funcionario) obj).getCpf());
	}

}
