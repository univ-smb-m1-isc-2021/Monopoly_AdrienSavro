import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tp.Case;
import tp.CasePropriete;
import tp.Joueur;
import tp.Main;
import tp.Monopoly;
import tp.ZonePropriete;

class ZoneProprieteTest {

	Monopoly jeu = new Monopoly();
	Case depart = Main.creerCase(jeu);
	
	CasePropriete marron1 = (CasePropriete)jeu.getCases().get(1);
	CasePropriete marron2 = (CasePropriete)jeu.getCases().get(2);
	ZonePropriete marron = marron1.getQuartier();
	
	Joueur tom = new Joueur("Tom", marron1, null); // L'argent de Tom est initialisé à 5000 €
	
	@Test
	void testBoucleSurQuartierFalse() {
		marron1.setProprietaire(tom);
		boolean test = marron.boucleSurQuartier(tom);
		
		assertTrue(!test);
	}

	@Test
	void testBoucleSurQuartierTrue() {
		marron1.setProprietaire(tom);
		marron2.setProprietaire(tom);
		boolean test = marron.boucleSurQuartier(tom);
		
		assertTrue(test);
	}
}
