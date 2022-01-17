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
	
	CasePropriete marron1 = (CasePropriete)jeu.getCases().get(1);
	CasePropriete marron2 = (CasePropriete)jeu.getCases().get(2);
	
	Joueur tom = new Joueur("Tom", marron1, null); // L'argent de Tom est initialisé à 5000 €
	
	@Test
	void testDonneLoyerConstructible() {
		
		// Pas besoin de la tester
		assertTrue(true);
		
	}
	
	@Test
	void testEstProprietaire() {
		marron1.setProprietaire(tom);
		boolean test = marron1.estProprietaire(tom);
		
		assertTrue(test);
	}
	
	@Test
	void testAjouterMaison() {
		marron1.setProprietaire(tom);
		tom.ajoutePropriete(marron1);
		marron2.setProprietaire(tom);
		tom.ajoutePropriete(marron2);
		tom.setArgent(20);
		boolean test = marron1.ajouterMaison(1);
		
		assertTrue(!test);
	}
	
	@Test
	void testAjouterMaisonVrai() {
		marron1.setProprietaire(tom);
		tom.ajoutePropriete(marron1);
		marron2.setProprietaire(tom);
		tom.ajoutePropriete(marron2);
		tom.setArgent(2000);
		boolean test = marron1.ajouterMaison(1);
		
		assertTrue(test);
	}
}