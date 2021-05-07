package org.serratec.ioarquivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntradaDados {
	private String caminho;
	private BufferedReader br = null;
	private String linha = "";
	private List <String[]> lista; 
	private String divisorDeConteudo = ";";
	
	public EntradaDados(String caminho) {
		super();
		this.caminho = caminho;
		this.lista = new ArrayList<>();
	}
	
	public void leituraArquivo() throws FileNotFoundException, IOException {
		this.br = new BufferedReader(new FileReader(this.caminho));
		String[] conteudo;
		while((linha = br.readLine()) != null) {
			conteudo = linha.split(divisorDeConteudo);
			lista.add(conteudo);
			String texto = "", texto2 = "";

			if (!conteudo[0].equals("")) {
				texto = "Nome: " + conteudo[0] + " CPF: " + conteudo[1] + " Data nascimento: " + conteudo[2];
				
				if (conteudo[3].equals("FILHO") || conteudo[3].equals("SOBRINHO") || conteudo[3].equals("OUTROS")) {
					texto2 = texto + " Parentesco:  " + conteudo[3];
				} else {
					texto2 = texto + " Salario: " + conteudo[3];
				}

			}
			System.out.println(texto2);
			
		}
		br.close();
		
		
	}
	
	
	


}
	

