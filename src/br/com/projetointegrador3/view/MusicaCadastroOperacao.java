package br.com.projetointegrador3.view;

import br.com.projetointegrador3.exceptions.MusicDuplicateException;
import br.com.projetointegrador3.helpers.Input;
import br.com.projetointegrador3.model.Biblioteca;
import br.com.projetointegrador3.model.Musica;

public class MusicaCadastroOperacao implements Operacao {

	private Biblioteca biblioteca;
	
	public MusicaCadastroOperacao(Biblioteca b) {
		this.biblioteca = b;
	}
	
	@Override
	public void execute() {

		try {
			
			System.out.println("Informe os dados da música:");
			
			String nome = Input.inputString("Nome da música: ");
			String cantor = Input.inputString("Nome do cantor: ");
			String banda = Input.inputString("Nome da banda: ");
			String album = Input.inputString("Nome do Album: ");
			String genero = Input.inputString("Gênero da música: ");
			int ano = Input.inputNumber("Ano de lançamento: ");
			
			Musica musica = new Musica(nome, cantor, banda, album, genero, ano);	
			
			this.biblioteca.listaDeMusicas().incluirNoFim(musica);
			System.out.printf("Musica [ %s ] adicionada na biblioteca.", musica.getNome());
			
		} catch (MusicDuplicateException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Ano de lançamento inválido");
		}
	}

}
