package br.com.projetointegrador3.view;

import br.com.projetointegrador3.model.Biblioteca;

public class MusicasOrdemAlfabeticaOperacao implements Operacao {

	private Biblioteca biblioteca;
	
	public MusicasOrdemAlfabeticaOperacao(Biblioteca b) {
		this.biblioteca = b;
	}

	@Override
	public void execute() {
		
		System.out.println(">>> Musicas em Ordem Alfabética de Nome\n"); 
		
		this.biblioteca.listaDeMusicas().getMusicas()
			.stream()
			.sorted((m1, m2) -> m1.getNome().compareToIgnoreCase(m2.getNome()))
			.forEach(System.out::println);
		
	}

}
