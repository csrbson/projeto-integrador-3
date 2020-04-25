package br.com.projetointegrador3.view;

import br.com.projetointegrador3.helpers.Input;
import br.com.projetointegrador3.model.Biblioteca;

public class MusicasPorIntervaloAnosOperacao implements Operacao {

	private Biblioteca biblioteca;
	
	public MusicasPorIntervaloAnosOperacao(Biblioteca b) {
		this.biblioteca = b;
	}

	@Override
	public void execute() {

		try {
			
			int ano1 = Input.inputNumber("Ano inicial: ");
			int ano2 = Input.inputNumber("Ano final  : ");
			
			System.out.println("Musicas lançadas entre os anos " + Integer.toString(ano1) + " e " + Integer.toString(ano2) + "\n\n");
			
			this.biblioteca.listaDeMusicas().getMusicas().stream()
			.filter(m -> (m.getAno() >= ano1 && m.getAno() <= ano2))
			.forEach(System.out::println);
			
		} catch (NumberFormatException e) {
			System.out.println("Ano informado deve ser um número.");
		}

	}
	
}
