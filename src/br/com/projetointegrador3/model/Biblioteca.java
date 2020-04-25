package br.com.projetointegrador3.model;

import java.util.ArrayList;
import java.util.Optional;

import br.com.projetointegrador3.util.JSONFileReader;

public class Biblioteca {

	private ListaDeMusica listaDeMusicas;
	private ListaDePlaylist listaDePlaylist;
	
	public Biblioteca() {
		ArrayList<Musica> musicas = JSONFileReader.loadMusicas("musicas.json");
		ArrayList<Playlist> playlists = JSONFileReader.loadPlaylists("playlist.json");

		this.listaDeMusicas = new ListaDeMusica(musicas);
		this.listaDePlaylist = new ListaDePlaylist(playlists);
	}
		
	public ListaDeMusica listaDeMusicas() {
		return this.listaDeMusicas;
	}

	public ListaDePlaylist listaDePlaylists() {
		return this.listaDePlaylist;
	}
	
	public Playlist obterPlaylist(String nome) {
		
		Optional<Playlist> playlist = this.listaDePlaylists().getPlaylists().stream()
				.filter(p -> p.getNome().equalsIgnoreCase(nome))
				.findFirst();
		
		if(playlist.isPresent()) {
			return playlist.get();
		} else {
			return null;
		}
	}

	public Musica obterMusica(String nome) {
		Optional<Musica> musica = this.listaDeMusicas().getMusicas().stream()
				.filter(m -> m.getNome().equalsIgnoreCase(nome))
				.findFirst();
		
		if(musica.isPresent()) {
			return musica.get();
		} else {
			return null;
		}		
	}
	
	public int totalDeMusicas() {
		return listaDeMusicas().tamanho();
	}
	
	public int totalDePlaylists() {
		return listaDePlaylists().tamanho();
	}

}
