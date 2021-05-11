package org.serratec.ioarquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import org.serratec.humano.Funcionario;

public class SaidaDados{
	private String caminho;
	
	public SaidaDados ( String caminho){
		this.caminho=caminho;	
	}
	
	public void gravacaoArquivo(Set<Funcionario> lista) throws IOException {
		BufferedWriter bw= new BufferedWriter(new FileWriter(caminho));
		for (Funcionario fun : lista) {
			fun.setDescontoInss();
			fun.setDescontoIR();
			bw.append(fun.toString()+ "\n");
		}
		bw.close();
	}
}
