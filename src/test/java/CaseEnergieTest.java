package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tp.Case;
import tp.CaseEnergie;
import tp.EtatLibre;
import tp.Joueur;
import tp.Main;
import tp.Monopoly;

class CaseEnergieTest {

	CaseEnergie energie1 = new CaseEnergie("Compagnie de distribution d'électricité", 150);
	
	Monopoly jeu = new Monopoly();
	Case depart = Main.creerCase(jeu);

	Joueur tom = new Joueur("Tom", depart, null);

	@Test
	void calculPrixAPayerTest() {
		
		tom.setNombreEnergie(1);
		int val = energie1.calculPrixAPayer(10, tom.getNombreEnergie());
		assertEquals(val, 40);
		
		tom.setNombreEnergie(2);
		int val2 = energie1.calculPrixAPayer(9, tom.getNombreEnergie());
		assertEquals(val2, 90);
	}

}
