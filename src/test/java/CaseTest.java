import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tp.Case;
import tp.CasePropriete;
import tp.Joueur;
import tp.Main;
import tp.Monopoly;

class CaseTest {

	Monopoly jeu = new Monopoly();
	Case depart = Main.creerCase(jeu);
	
	CasePropriete marron1 = (CasePropriete)jeu.getCases().get(1);
	CasePropriete lastCase = (CasePropriete)jeu.getCases().get(33);
	
	Joueur tom = new Joueur("Tom", lastCase, null); // L'argent de Tom est initialisé à 5000 €
	
	@Test
	public void testCaseDans() {
		Case caseRenvoye = lastCase.caseDans(2);
		
		assertEquals(caseRenvoye, marron1);
	}
	
	@Test
	public void testPasseCaseDepart() {
		boolean test = lastCase.passeCaseDepart(5);
		
		assertTrue(test);
	}

}
