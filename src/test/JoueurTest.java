package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tp.Joueur;

class JoueurTest {

	@Test
	void testPayeCredit() {
		
		Joueur tom = new Joueur("Tom", null, null); // L'argent de Tom est initialisé à 5000 €

		tom.paye(200, true); // Tom doit etre débité de 200 €
				
		assertEquals(tom.getArgent(), 4800);
	}
	
	

}
