package br.com.projetointegrador3.view;

import br.com.projetointegrador3.helpers.Input;
import br.com.projetointegrador3.model.Biblioteca;

public class MusicasPorBandaOperacao implements Operacao {

	private Biblioteca biblioteca;
	
	public MusicasPorBandaOperacao(Biblioteca b) {
		this.biblioteca = b;
	}

	@Override
	public void execute() {
		
		String banda = Input.inputString("Nome da banda: ");
		
		System.out.println("Musicas da banda: " + banda);
		
		this.biblioteca.listaDeMusicas().getMusicas().stream()
			.filter(m -> m.getBanda().toLowerCase().equals(banda.toLowerCase()))
			.forEach(System.out::println);		
	}
	
}
