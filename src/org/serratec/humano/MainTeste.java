package org.serratec.humano;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.serratec.excecoes.FuncionarioException;
import org.serratec.ioarquivo.EntradaDados;

public class MainTeste {

	public static void main(String[] args) throws Exception {

		System.out.println("Informe o caminho do arquivo.csv: ");
		Scanner sc = new Scanner(System.in);
		String caminho = sc.next();

		try (EntradaDados arquivo = new EntradaDados(caminho);) {
			arquivo.leituraArquivo();
			for (Funcionario fun : arquivo.getLista()) {
				fun.setDescontoInss();
				fun.setDescontoIR();
				System.out.println(fun);
			}
		} catch (NumberFormatException e) {
			System.out.println("Dados de salário inválidos!");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
		} catch (IOException e) {
			System.out.println("Falha na abertura do arquivo!");
			e.printStackTrace();
		} catch (FuncionarioException f) {
			System.out.println(f.getMessage());
		} finally {
			System.out.print("Deseja tentar novamente? [SIM/NÃO]: ");
			if ("SIM".equals(sc.next().toUpperCase())) {
				String[] arg = {};
				MainTeste.main(arg);
			} else {
				System.out.println("Programa finalizado.");
				sc.close();
			}
		}

//		Funcionario f1= new Funcionario("Rodrigo", "12345678", LocalDate.of(1995, 8, 24),7000);
//		Funcionario f2= new Funcionario("Rodrigo", "12345678", LocalDate.of(1995, 8, 24),2000);
//		f2.setDependentes(new Dependente ("�lec", "21458441", LocalDate.of(2020, 5, 20), Parentesco.FILHO));
//		
//		f2.setDescontoInss();
//		f2.setDescontoIR();
////		System.out.println(f1.getNome()+ ","+ f1.getCpf()+","+f1.getDescontoInss()+","+f1.getDescontoIR()+","
////		+ (f1.getSalarioB()-f1.getDescontoInss()-f1.getDescontoIR()));
//		
//		System.out.println(f2.getDescontoInss()+","+f2.getDescontoIR()+","
//				+ (f2.getSalarioB()-f2.getDescontoInss()-f2.getDescontoIR()));
	}

}
