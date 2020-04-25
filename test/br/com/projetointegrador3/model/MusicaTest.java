package br.com.projetointegrador3.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MusicaTest {

	@Test
	public void testeMusicasIguais() {

		Musica m1 = new Musica("Alive", "Perl Jam", "Pearl Jam", "Ten", "Rock Alternativo", 1991);
		Musica m2 = new Musica("Alive", "Perl Jam", "Pearl Jam", "Ten", "Rock Alternativo", 1991);

		assertEquals(m1, m2);	
	}

}
