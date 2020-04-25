package br.com.projetointegrador3.view;

import java.util.Random;

import br.com.projetointegrador3.helpers.Input;
import br.com.projetointegrador3.model.Biblioteca;
import br.com.projetointegrador3.model.Musica;
import br.com.projetointegrador3.model.Playlist;

public class PlaylistCadastroRandomOperacao implements Operacao {

	private Biblioteca biblioteca;
		
	public PlaylistCadastroRandomOperacao(Biblioteca b) {
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
				Playlist pl = new Playlist(nome);
				
				if(qtdeMusicas <= tamanhoDaBiblioteca) {
					int w = qtdeMusicas;
					while (w > 0) {
						Random random = new Random();
						int number = random.nextInt(qtdeMusicas + 1);
						Musica m = this.biblioteca.listaDeMusicas().get(number);
						if (!pl.getListaMusicas().hasMusic(m)) {
							pl.getListaMusicas().incluirNoFim(m);
							w--;					
						}
					}

					this.biblioteca.listaDePlaylists().incluirNoFim(pl);
					
					System.out.println(">>> Playlist Criada: " + pl.getNome());
					System.out.println(">>> Musicas adicionadas a Playlist: ");
					
					for (Musica m : pl.getListaMusicas().getMusicas()) {
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
