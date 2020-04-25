package br.com.projetointegrador3.view;

import br.com.projetointegrador3.helpers.Input;
import br.com.projetointegrador3.model.Biblioteca;
import br.com.projetointegrador3.model.Playlist;

public class PlaylistsExibirMusicasOperacao implements Operacao {

	private Biblioteca biblioteca;
	
	public PlaylistsExibirMusicasOperacao(Biblioteca b) {
		this.biblioteca = b;
	}

	@Override
	public void execute() {

		String input = Input.inputString("Nome da playlist: ");

		System.out.println("Musicas nesta playlist: ");

		Playlist playlist = this.biblioteca.obterPlaylist(input);

		if(playlist != null) {
			playlist.getListaMusicas().getMusicas().stream()
				.forEach(p -> System.out.println(p));
		}

	}
	
}
