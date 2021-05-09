package org.serratec.ioarquivo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

import org.serratec.excecoes.DependenteException;
import org.serratec.excecoes.FuncionarioException;
import org.serratec.humano.Dependente;
import org.serratec.humano.Funcionario;
import org.serratec.humano.Parentesco;

public class EntradaDados implements AutoCloseable {
	private String caminho;
	private BufferedReader br = null;
	private String linha = "";
	private Set<Funcionario> lista;
	private String divisorDeConteudo = ";";

	public EntradaDados(String caminho) {
		this.caminho = caminho;
		this.lista = new HashSet<Funcionario>();
	}

	public void leituraArquivo() throws FileNotFoundException, IOException, NumberFormatException, DependenteException, FuncionarioException {
		this.br = new BufferedReader(new InputStreamReader(new FileInputStream(this.caminho), "UTF-8"));
		String[] conteudo;
		String cpfFunc = null;
		while ((linha = br.readLine()) != null) {
			conteudo = linha.split(divisorDeConteudo);

			if (!conteudo[0].equals("")) {	

				int ano = 0, mes = 0, dia = 0;
				ano = Integer.parseInt(conteudo[2].substring(0, 4));
				mes = Integer.parseInt(conteudo[2].substring(4, 6));
				dia = Integer.parseInt(conteudo[2].substring(6, 8));
				Parentesco parentesco = Parentesco.FILHO;

				if (conteudo[3].equals("FILHO") || conteudo[3].equals("SOBRINHO") || conteudo[3].equals("OUTROS")) {
					
					// Criação de try/catch para tratar a exceção de dependente maior de idade e tradando a exceção internamente.
					try {
						if (Period.between(LocalDate.of(ano, mes, dia), LocalDate.now()).getYears() < 18) {
							switch (conteudo[3]) {
							case "FILHO" -> parentesco = Parentesco.FILHO;
							case "SOBRINHO" -> parentesco = Parentesco.SOBRINHO;
							case "OUTROS" -> parentesco = Parentesco.OUTROS;
							}
							// Criação de um try/catch interno para tratar internamente a exceção de CPF repetido.
							try {
								for (Funcionario func : lista) {
									if (func.getCpf().equals(cpfFunc)) {
										if (func.setDependentes(new Dependente(conteudo[0], conteudo[1],
												LocalDate.of(ano, mes, dia), parentesco))) {

										} else {
											
											//Lançamento da exceção de CPF repetido.
											throw new DependenteException(
													"Dependente " + conteudo[0] + " com CPF repetido");
										}

									}
								}
							} catch (DependenteException e) {
								System.out.println(e.getMessage());
							}

						} else {
							
							// Lançamento da exceção de dependente maior.
							throw new DependenteException("Dependente " + conteudo[0] + "maior de idade.");
						}
					} catch (DependenteException e) {
						System.out.println(e.getMessage());
					}
				} else {
					
					// Verificando se o funcionario foi relamente adicionado.
					if(lista.add(new Funcionario(conteudo[0], conteudo[1], LocalDate.of(ano, mes, dia),
							Double.parseDouble(conteudo[3])))) {
						cpfFunc = conteudo[1];
					} else {
						
						// Em caso de não ser adicionado, é lançado a exceção de Funcionario com CPF repetido.
						throw new FuncionarioException("Funcionario " + conteudo[0] + " com CPF repetido.");
					}
				}
			}
		}
	}

	// Ao implementar a interface AutoCloseable, n�o vamos nos preocupar em fechar o
	// BufferReader.
	@Override
	public void close() throws Exception {
		br.close();
	}

	public Set<Funcionario> getLista() {
		return lista;
	}

}
