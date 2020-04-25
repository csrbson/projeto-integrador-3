package br.com.projetointegrador3.view;

import br.com.projetointegrador3.model.Biblioteca;

public class PlaylistsExibirNomesOperacao implements Operacao {

	private Biblioteca biblioteca;
		
	public PlaylistsExibirNomesOperacao(Biblioteca b) {
		this.biblioteca = b;
	}
	
	@Override
	public void execute() {

		System.out.println("Playlists cadastradas");

		this.biblioteca.listaDePlaylists().getPlaylists().stream()
			.forEach(System.out::println);

	}
}
