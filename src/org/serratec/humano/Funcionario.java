package org.serratec.humano;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
	private double salarioB, descontoInss, descontoIR;
	private Dependente dependentes[];

	public Funcionario(String nome, String cpf, LocalDate localDate, double salarioB, double descontoInss,
			double descontoIR) {
		super(nome, cpf, localDate);
		this.salarioB = salarioB;
		this.descontoInss = descontoInss;
		this.descontoIR = descontoIR;
	}

	public Dependente[] getDependentes() {
		return dependentes;
	}

	public void setDependentes(Dependente[] dependentes) {
		this.dependentes = dependentes;
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
		}else if (salarioB < 2203.49) {
			descontoInss = salarioB * .09 - 16.5;
		}else if (salarioB < 3305.23) {
			descontoInss = salarioB * .12 - 82.61;
		}else if (salarioB < 6433.58) {
			descontoInss = salarioB * .14 - 148.72;
		}else {
			descontoInss = 751.98;
		}
	}

	public double getDescontoIR() {
		return descontoIR;
	}

	public void setDescontoIR(double descontoIR) {
		double dep;
		if (getDescontoInss() == 0) {
			setDescontoInss();
		}
		if (dependentes == null) {
			dep = 0;
		}else {
			dep = dependentes.length * 189.59;
		}
		if (salarioB < 1903.99) {
			descontoIR = 0;
		}else if (salarioB < 2826.66) {
			descontoIR = (salarioB - dep - descontoInss) * .075 - 142.8;
		}else if (salarioB < 3751.06) {
			descontoIR = (salarioB - dep - descontoInss) * .15 - 354.8;
		}else if (salarioB < 4664.68) {
			descontoIR = (salarioB - dep - descontoInss) * .225 - 636.13;
		}else {
			descontoIR = (salarioB - dep - descontoInss) * .275 - 869.36;
		}
	}

}
