package br.com.projetointegrador3.model;

import java.util.ArrayList;

import br.com.projetointegrador3.exceptions.MusicDuplicateException;

public class ListaDeMusica {

	private ArrayList<Musica> musicas = new ArrayList<>();
	private int tamanho;

	public ListaDeMusica() {
	}
	
	public ListaDeMusica(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}

	public ArrayList<Musica> getMusicas() {
		return musicas;
	}

	public int tamanho() {		
		this.tamanho = this.musicas.size(); 
		return this.tamanho;		
	}
	
	public Musica get(int index) {
		return this.musicas.get(index);
	}

	public boolean hasMusic(Musica m) {
		return this.musicas.contains(m);
	}
	
	public void incluirNoInicio(Musica m) {
		if(isDuplicate(m)) throw new MusicDuplicateException("Esta música já faz parte da sua biblioteca");
		musicas.add(0, m);
	}

	public void incluirNoFim(Musica m) {
		if(isDuplicate(m)) throw new MusicDuplicateException("Esta música já faz parte da sua biblioteca");
		musicas.add(m);
	}

	public void incluirEmOrdem(Musica m) {
		if(isDuplicate(m)) throw new MusicDuplicateException("Esta música já faz parte da sua biblioteca");		
		//TODO Implementar código
		
	}
	
	public void removerDoInicio() {
		musicas.remove(0);
	}
	
	public void removerDoFim() {
		musicas.remove(tamanho);
	}
	
	private boolean isDuplicate(Musica m) {
		return this.musicas.contains(m); 
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for (Musica musica : getMusicas()) {
			sb.append(musica.toString() + "\n");
		}
		
		return sb.toString();
		
	}
	
	
	
}
