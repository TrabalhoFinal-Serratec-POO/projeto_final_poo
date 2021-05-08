package org.serratec.humano;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
	private double salarioB, descontoInss, descontoIR;
	private List<Dependente> dependentes = new ArrayList<Dependente>();

	public Funcionario(String nome, String cpf, LocalDate localDate, double salarioB) {
		super(nome, cpf, localDate);
		this.salarioB = salarioB;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(Dependente dependentes) {
		this.dependentes.add(dependentes);
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
		return this.getNome() + ";" + this.getCpf() + ";" + String.format("%.2f", descontoInss) + ";" +
				String.format("%.2f", descontoIR) + ";" + String.format("%.2f", (salarioB - descontoInss - descontoIR)) + this.getDependentes();
	}

}
