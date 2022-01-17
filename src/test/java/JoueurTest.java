import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import tp.Case;
import tp.CasePropriete;
import tp.EtatConstructible;
import tp.Joueur;
import tp.Main;
import tp.Monopoly;

class JoueurTest {
	
	Monopoly jeu = new Monopoly();
	Case depart = Main.creerCase(jeu);

	Joueur tom = new Joueur("Tom", depart, null); // L'argent de Tom est initialisé à 5000 €
	
	CasePropriete marron1 = new CasePropriete("Boulevard de Belleville", 60, 2, 10, 30, 90, 160, 250);
	CasePropriete marron2 = new CasePropriete("Rue Lecourbe", 60, 4, 20, 60, 180, 320, 450);
	CasePropriete vert1 = new CasePropriete("Avenue de Breteuil", 300, 26, 130, 390, 900, 1100, 1275);



	@Test
	void testPaye() {
		
		
		tom.paye(200, true); // Tom doit etre débité de 200 €
		assertEquals(tom.getArgent(), 4800);

		
		tom.paye(200, false); // Tom doit etre débité de 200 €
		assertEquals(tom.getArgent(), 5000);

	}
	
	@Test
	void testAvancerPion() {
		tom.avancerPion(9);
		assertEquals(tom.getPosition().getNom(), "Boulevard de la villette");
	}
	
	@Test
	void testAvancerPionDepart() {
		
		Case champsElysees = jeu.getCases().get(31);
		tom.setPosition(champsElysees);
		tom.setArgent(1000);
		
		tom.avancerPion(5);
		
		assertEquals(tom.getArgent(), 1200);
	}
	
	@Test
	void testDonneProprietesConstructible() {
		
		tom.ajoutePropriete(marron1);
		tom.ajoutePropriete(marron2);
		tom.ajoutePropriete(vert1);
		
		marron1.majEtat(new EtatConstructible(marron1));
		marron2.majEtat(new EtatConstructible(marron2));
		
		List<CasePropriete> prop = tom.donneProprietesConstructible();
		
		assertEquals(prop.size(), 2);
		assertEquals(prop.get(0).getNom(), "Boulevard de Belleville");
		assertEquals(prop.get(1).getNom(), "Rue Lecourbe");

		
		
		
	}
	
	
	

}
