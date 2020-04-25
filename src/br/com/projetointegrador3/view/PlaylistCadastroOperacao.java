package br.com.projetointegrador3.view;

import br.com.projetointegrador3.exceptions.MusicNotLocalizedException;
import br.com.projetointegrador3.helpers.Input;
import br.com.projetointegrador3.model.Biblioteca;
import br.com.projetointegrador3.model.Musica;
import br.com.projetointegrador3.model.Playlist;

public class PlaylistCadastroOperacao implements Operacao {

	private Biblioteca biblioteca;
		
	public PlaylistCadastroOperacao(Biblioteca b) {
		this.biblioteca = b;
	}
	
	@Override
	public void execute() {
		
		int tamanhoDaBiblioteca = this.biblioteca.totalDeMusicas();
		int totalDePlaylists = this.biblioteca.totalDePlaylists();
		
		if(tamanhoDaBiblioteca > 0) {
			
			try {
				
				String nome = Input.inputString("Nome da playlist: ");
				int qtdeMusicas = Input.inputNumber("Quantidade de músicas a incluir nesta playlist: ");

				if(nome.isEmpty() || nome.isBlank()) {
					nome = "Playlist" + String.valueOf(totalDePlaylists + 1);
				}

				Playlist playlist = new Playlist(nome);

				if(qtdeMusicas <= tamanhoDaBiblioteca) {
					int w = qtdeMusicas;
					while (w > 0) {
						
						try {

							String nomeMusica = Input.inputString("Nome da Musica: ");
							Musica m = this.biblioteca.obterMusica(nomeMusica);
							if(m == null) {
								throw new MusicNotLocalizedException("não localizei esta música na biblioteca.");
							} else {
								playlist.getListaMusicas().incluirNoFim(m);
								w--;
							}							
						} catch (MusicNotLocalizedException e) {
				        	System.out.println(e.getMessage());
				        	String opcao = Input.inputString("Tecle [A] para abandonar a operação ou qualquer tecla para continuar");
				        	if("a".equalsIgnoreCase(opcao)) {
				        		break;
				        	}
						}
					}
					
					this.biblioteca.listaDePlaylists().incluirNoFim(playlist);
					
					System.out.println(">>> Playlist Criada: " + nome);
					System.out.println(">>> Musicas adicionadas a Playlist: ");
					
					for (Musica m : playlist.getListaMusicas().getMusicas()) {
						System.out.println(m);
					}					

				} else {
					System.out.println("a quantidade de músicas é superior a sua biblioteca.");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Quantidade de músicas deve ser um número.");
			}

		} else {
			System.out.println("a biblioteca de musicas encontra-se vazia.");
		}	

	}

}
