package org.serratec.executavel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.serratec.excecoes.FuncionarioException;
import org.serratec.ioarquivo.EntradaDados;
import org.serratec.ioarquivo.SaidaDados;

public class Main {
	public static void main(String[] args) throws Exception {
	boolean boleano= false;
	System.out.println("Informe o caminho do arquivo.csv: ");
	Scanner sc = new Scanner(System.in);
	String caminho = sc.next();
	System.out.println("Informe onde deseja gravar o arquivo de saída: ");
	String saida = sc.next();

	try (EntradaDados arquivo = new EntradaDados(caminho)) {
		arquivo.leituraArquivo();
		SaidaDados saidaDados = new SaidaDados(saida);
		saidaDados.gravacaoArquivo(arquivo.getLista());
	} catch (NumberFormatException e) {
		System.out.println("Dados de salário inválidos!");
	} catch (FileNotFoundException e) {
		boleano=true;
		System.out.println("Arquivo não encontrado!");
	} catch (IOException e) {
		boleano=true;
		System.out.println("Falha na abertura do arquivo!");
		e.printStackTrace();
	} catch (FuncionarioException f) {
		System.out.println(f.getMessage());
	} finally {
		if (boleano) {
			System.out.print("Deseja tentar novamente? [SIM/NÃO]: ");
			if ("SIM".equals(sc.next().toUpperCase())) {
				String[] arg = {};
				Main.main(arg);
			}
		} else {
			System.out.println("Programa finalizado.");
			sc.close();
		}
	}
	}
}
