package br.com.projetointegrador3.model;

public class Playlist {
	
	private String nome;
	private ListaDeMusica musicasPlaylist;
	
	public Playlist(String nome) {
		this.nome = nome;
		this.musicasPlaylist = new ListaDeMusica();
	}
	
	public Playlist(String nome, ListaDeMusica musicasPlaylist) {
		this.nome = nome;
		this.musicasPlaylist = musicasPlaylist;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public ListaDeMusica getListaMusicas() {
		return this.musicasPlaylist;
	}
	
	public int totalMusicas() {
		return this.musicasPlaylist.tamanho();
	}

	@Override
	public String toString() {
		return "Playlist [nome=" + nome + ", músicas na playlist=" + totalMusicas() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlist other = (Playlist) obj;
//		if (musicasPlaylist == null) {
//			if (other.musicasPlaylist != null)
//				return false;
//		} else if (!musicasPlaylist.equals(other.musicasPlaylist))
//			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equalsIgnoreCase(nome))
			return false;
		return true;
	}
	
	

}