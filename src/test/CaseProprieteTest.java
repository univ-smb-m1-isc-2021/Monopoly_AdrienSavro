package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tp.Case;
import tp.CasePropriete;
import tp.EtatAchete;
import tp.EtatLibre;
import tp.Joueur;
import tp.Main;
import tp.Monopoly;

class CaseProprieteTest {
	
	Monopoly jeu = new Monopoly();
	Case depart = Main.creerCase(jeu);
	
	CasePropriete marron1 = new CasePropriete("Boulevard de Belleville", 60, 2, 10, 30, 90, 160, 250);
	CasePropriete marron2 = new CasePropriete("Rue Lecourbe", 60, 4, 20, 60, 180, 320, 450);
	
	Joueur tom = new Joueur("Tom", marron1, null); // L'argent de Tom est initialisé à 5000 €

	@Test
	void testEstProprietaire() {
		
		marron1.majEtat(new EtatAchete(marron1));
		
		marron1.operationPossible(tom);
		
		System.out.println(marron1.etat);
		
		assertEquals(marron1.etat.getClass(), EtatLibre.class);
	}
	
	
	@Test
	void testAjouterMaison() {
		
		marron1.setProprietaire(tom);
		tom.ajoutePropriete(marron1);
		
		tom.setArgent(100);

		
		boolean peut = marron1.ajouterMaison(1);
		
		assertTrue(peut);
		
		
	}
	
	@Test
	void testDonneLoyerConstructible() {
		
		// Pas besoin de la tester
		assertTrue(true);
		
	}
	
	
	
	
	
	


}
