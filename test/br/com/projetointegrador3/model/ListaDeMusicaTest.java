package br.com.projetointegrador3.model;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.projetointegrador3.exceptions.MusicDuplicateException;

public class ListaDeMusicaTest {

	private ListaDeMusica lm = new ListaDeMusica();
	private Musica musica1;
	private Musica musica2;
	private Musica musica3;
	private Musica musica4;
	private Musica musica5;
	
	@BeforeEach
	void setup() {
		
		musica1 = new Musica("Alive", "Perl Jam", "Pearl Jam", "Ten", "Rock Alternativo", 1991);
		musica2 = new Musica("Hunting high and low", "a-ha", "a-ha", "Hunting high and low", "Pop", 1985);
		musica3 = new Musica("Streets of Philadelphia", "Bruce Springsteen", "Bruce Springsteen", "Philadelphia (Music from the Motion Picture)", "Soundtrack", 1994);
		musica4 = new Musica("A Sky Full of Stars", "Coldplay", "Coldplay", "Ghost Stories", "Alternativo", 2014);
		
		musica5 = new Musica("Alive", "Perl Jam", "Pearl Jam", "Ten", "Rock Alternativo", 1991);

	}
	
	
	@Test
	void deveLancarExcecaoAoIncluirMusicasIguaisNaLista() {

		lm.incluirNoFim(musica1);
		
		assertThrows(MusicDuplicateException.class, () -> {
			lm.incluirNoFim(musica5);
		});		
	}
	
	@Test
	void deveLancarExcecaoAoBuscarMusicaInexistente() {
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			 Musica m = lm.get(1);
		});
	}
	
	@Test
	void deveIncluirMusicaNoInicioDaLista() {
		
		lm.incluirNoInicio(musica1);
		lm.incluirNoInicio(musica2);

		assertEquals(lm.get(0), musica2);

		lm.incluirNoInicio(musica3);

		assertEquals(lm.get(0), musica3);

	}

	@Test
	void deveIncluirMusicaNoFinalDaLista() {
		
		int tamanho;
		lm.incluirNoFim(musica1);
		lm.incluirNoFim(musica2);

		tamanho = lm.tamanho() -1;
		assertEquals(lm.get(tamanho), musica2);

		lm.incluirNoFim(musica3);
		tamanho = lm.tamanho() -1;
		
		assertEquals(lm.get(tamanho), musica3);

	}

	@Test
	void testeMusicaEstaPresenteNaLista() {

		lm.incluirNoInicio(musica1);
		lm.incluirNoInicio(musica2);
		lm.incluirNoInicio(musica3);
		lm.incluirNoInicio(musica4);
		
		assertTrue(lm.hasMusic(musica1));
		assertTrue(lm.hasMusic(musica2));
		assertTrue(lm.hasMusic(musica3));
		assertTrue(lm.hasMusic(musica4));
	}

	@Test
	void testeMusicaNaoEstaPresenteNaLista() {

		lm.incluirNoInicio(musica1);
		lm.incluirNoInicio(musica2);
		lm.incluirNoInicio(musica3);
		
		assertFalse(lm.hasMusic(musica4));
	}

	@Test
	void testeObterMusicaPorIndiceNaLista() {

		lm.incluirNoInicio(musica1);

		assertEquals(lm.get(0), musica1);
	}

	@Test
	void testeTamanhoDaLista() {

		lm.incluirNoInicio(musica1);
		lm.incluirNoInicio(musica2);
		lm.incluirNoInicio(musica3);
		lm.incluirNoInicio(musica4);

		assertEquals(4, lm.tamanho());
	}

}
