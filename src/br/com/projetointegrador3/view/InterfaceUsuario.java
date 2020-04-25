package br.com.projetointegrador3.view;

import br.com.projetointegrador3.exceptions.SairException;
import br.com.projetointegrador3.helpers.Input;
import br.com.projetointegrador3.model.Biblioteca;

public class InterfaceUsuario {

	private Operacao operacao;
	private Biblioteca biblioteca;
	
	public InterfaceUsuario() {
		this.biblioteca = new Biblioteca();
		
		executarMenu();
	}

	public void setOperacao(Operacao o) {
		this.operacao = o;
	}

	public void executaOperacao() {
		this.operacao.execute();
	}

	@Override
	public String toString() {

		StringBuilder menu = new StringBuilder();
		
		menu.append("[1] Cadastrar Musica\n");
		menu.append("[2] Apresentar músicas em ordem alfabética de nome\n");
		menu.append("[3] Apresentar os nomes das músicas de um determinado gênero\n");
		menu.append("[4] Apresentar os nomes das músicas de uma determinada banda\n");
		menu.append("[5] Apresentar os nomes das músicas lançadas em um determinado intervalo de anos\n");
		menu.append("[6] Cadastrar Playlist e adicionar músicas aleatórias\n");
		menu.append("[7] Cadastrar Playlist e adicionar músicas manualmente\n");
		menu.append("[8] Apresentar os nomes das Playlists cadastradas\n");
		menu.append("[9] Apresentar os nomes das músicas incluídas em uma Playlist\n");
		
		return menu.toString();
	}

	private void executarMenu() {
		try {
			
			while(true) {
				operacoesPrograma();
			}		

		} catch (SairException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		} finally {
			Input.close();
		}
	}
	
	private void operacoesPrograma() {
		
		while(true) {
			System.out.println(this);

			String opcao = Input.inputString("Escolha a opção desejada [1-9] ou [sair] para encerrar.");
			
			try {

				if("sair".equalsIgnoreCase(opcao)) {
					throw new SairException("O Programa foi encerrado.");
				} else if(Integer.parseInt(opcao) > 0 && Integer.parseInt(opcao) < 10) {
					switch (Integer.parseInt(opcao)) {
					case 1: {
						executarOpcao(new MusicaCadastroOperacao(biblioteca));
						break;
					}
					case 2: {
						executarOpcao(new MusicasOrdemAlfabeticaOperacao(biblioteca));
						break;
					}
					case 3: {
						executarOpcao(new MusicasPorGeneroOperacao(biblioteca));
						break;
					}
					case 4: {
						executarOpcao(new MusicasPorBandaOperacao(biblioteca));
						break;
					}
					case 5: {
						executarOpcao(new MusicasPorIntervaloAnosOperacao(biblioteca));
						break;
					}
					case 6: {
						executarOpcao(new PlaylistCadastroRandomOperacao(biblioteca));
						break;
					}
					case 7: {
						executarOpcao(new PlaylistCadastroOperacao(biblioteca));
						break;
					}

					case 8: {
						executarOpcao(new PlaylistsExibirNomesOperacao(biblioteca));
						break;
					}
					case 9: {
						executarOpcao(new PlaylistsExibirMusicasOperacao(biblioteca));
						break;
					}

					default:
					}
				} else {
					throw new IllegalArgumentException("Opção não esperada: " + Integer.parseInt(opcao));
				}
			} catch (NumberFormatException e) {
				System.out.println("Opção inválida.");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void executarOpcao(Operacao operacao) {
		setOperacao(operacao);
		executaOperacao();
		Input.inputString("\n\nTecle Qualquer tecla para continuar ");		
	}

}
