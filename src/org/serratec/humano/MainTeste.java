package org.serratec.humano;

import java.time.LocalDate;

public class MainTeste {

	public static void main(String[] args) {
		Funcionario f1= new Funcionario("Rodrigo", "12345678", LocalDate.of(1995, 8, 24),7000);
		Funcionario f2= new Funcionario("Rodrigo", "12345678", LocalDate.of(1995, 8, 24),2000);
		f2.setDependentes(new Dependente ("Álec", "21458441", LocalDate.of(2020, 5, 20), Parentesco.FILHO));
		
		f2.setDescontoInss();
		f2.setDescontoIR();
//		System.out.println(f1.getNome()+ ","+ f1.getCpf()+","+f1.getDescontoInss()+","+f1.getDescontoIR()+","
//		+ (f1.getSalarioB()-f1.getDescontoInss()-f1.getDescontoIR()));
		
		System.out.println(f2.getDescontoInss()+","+f2.getDescontoIR()+","
				+ (f2.getSalarioB()-f2.getDescontoInss()-f2.getDescontoIR()));
	}

}
