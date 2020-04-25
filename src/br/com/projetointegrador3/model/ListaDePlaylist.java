package br.com.projetointegrador3.model;

import java.util.ArrayList;

public class ListaDePlaylist {

	private ArrayList<Playlist> playlists = new ArrayList<>();
	private int tamanho;
	
	public ListaDePlaylist() {
	}
	
	public ListaDePlaylist(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}

	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	public Playlist get(int index) {
		return this.playlists.get(index);
	}

	public int tamanho() {
		this.tamanho = this.playlists.size(); 
		return this.tamanho;		
	}

	void incluirNoInicio(Playlist p) {
		playlists.add(0, p);		
	}

	public void incluirNoFim(Playlist p) {
		playlists.add(p);		
	}

	public void incluirEmOrdem(Playlist p) {		
		//TODO implementar esse método conforme orientações	
	}
	
	public void removerDoInicio() {		
		playlists.remove(0);		
	}
	
	public void removerDoFim() {		
		playlists.remove(playlists.size()-1);		
	}
	
}