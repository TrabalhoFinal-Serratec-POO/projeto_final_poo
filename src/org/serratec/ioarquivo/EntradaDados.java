package org.serratec.ioarquivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.serratec.humano.Dependente;
import org.serratec.humano.Funcionario;
import org.serratec.humano.Parentesco;

public class EntradaDados implements AutoCloseable {
	private String caminho;
	private BufferedReader br = null;
	private String linha = "";
	private List<Funcionario> lista;
	private String divisorDeConteudo = ";";

	public EntradaDados(String caminho) {
		super();
		this.caminho = caminho;
		this.lista = new ArrayList<Funcionario>();

	}

	public void leituraArquivo() throws FileNotFoundException, IOException, NumberFormatException {
		this.br = new BufferedReader(new FileReader(this.caminho));
		String[] conteudo;
		int contagem = 0;
		while ((linha = br.readLine()) != null) {
			conteudo = linha.split(divisorDeConteudo);

			// lista.add(conteudo);

			// Visualização do arquivo.
//			String texto = "", texto2 = "";
//
//			if (!conteudo[0].equals("")) {
//				texto = "Nome: " + conteudo[0] + " CPF: " + conteudo[1] + " Data nascimento: " + conteudo[2];
//
//				if (conteudo[3].equals("FILHO") || conteudo[3].equals("SOBRINHO") || conteudo[3].equals("OUTROS")) {
//					texto2 = texto + " Parentesco:  " + conteudo[3];
//					lista.get(contagem - 1)
//							.setDependentes(new Dependente(conteudo[0], conteudo[1], null, Parentesco.FILHO));
//					;
//				} else {
//					texto2 = texto + " Salario: " + conteudo[3];
//					lista.add(new Funcionario(conteudo[0], conteudo[1], null, Double.parseDouble(conteudo[3])));
//					contagem++;
//				}
//			}
//			System.out.println(texto2);

			if (!conteudo[0].equals("")) {

				if (conteudo[3].equals("FILHO") || conteudo[3].equals("SOBRINHO") || conteudo[3].equals("OUTROS")) {
					lista.get(contagem - 1)
							.setDependentes(new Dependente(conteudo[0], conteudo[1], null, Parentesco.FILHO));

				} else {
					lista.add(new Funcionario(conteudo[0], conteudo[1], null, Double.parseDouble(conteudo[3])));
					contagem++;
				}
			}
		}
	}

	// Ao implementar a interface AutoCloseable, Não vamos nos preocupar em fechar o
	// BufferReader.
	@Override
	public void close() throws Exception {
		br.close();
	}

	public List<Funcionario> getLista() {
		return lista;
	}

}
