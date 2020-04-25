package br.com.projetointegrador3.view;

import br.com.projetointegrador3.helpers.Input;
import br.com.projetointegrador3.model.Biblioteca;

public class MusicasPorGeneroOperacao implements Operacao {

	private Biblioteca biblioteca;
		
	public MusicasPorGeneroOperacao(Biblioteca b) {
		this.biblioteca = b;
	}

	@Override
	public void execute() {

		String genero = Input.inputString("Gênero da música: ");
		
		System.out.println("Musicas do genero: " + genero);

		this.biblioteca.listaDeMusicas().getMusicas().stream()
			.filter(m -> m.getGenero().toLowerCase().equals(genero.toLowerCase()))
			.forEach(System.out::println);		
	}

}
