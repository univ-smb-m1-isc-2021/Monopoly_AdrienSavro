package tp;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main {

	static String TAB = "______";
	

	public static void main(String[] args) {
		
		
		
		Monopoly jeu = new Monopoly();
		Case depart = creerCase(jeu);
		
		MyFrame f = new MyFrame("Panel", jeu);

		
	    Scanner clavier = new Scanner(System.in);

		
		System.out.println("Bienvenue au jeu du Monopoly ! ");
		
		System.out.println("Combien de joueurs êtes-vous ? (2-6) ");
		
		int nbJoueurs = clavier.nextInt();

		
		for(int i = 1; i <= nbJoueurs; i++) {
			System.out.println("Nom du joueur " + i + " : ");
			String nom = clavier.next();
			

			Joueur j = new Joueur(nom, depart, f);
			jeu.ajouteJoueur(j);
		}
		
		

		System.out.println("-- DÉBUT DE LA PARTIE --");
		
		
		
		 
		f.refreshFrame();
		     
       
        
		
		
		jeu.lancerPartie(f);
	}
	
	
	
	
	
	
	public static Case creerCase(Monopoly jeu) {
		
		// Liste de toutes les cases propriétés 
		// Param : Nom, loyerVide, loyer1Maison, loyer2Maisons, loyer3Maisons, loyer4Maisons, loyerHotel
		CasePropriete marron1 = new CasePropriete("Boulevard de Belleville", 60, 2, 10, 30, 90, 160, 250);
		CasePropriete marron2 = new CasePropriete("Rue Lecourbe", 60, 4, 20, 60, 180, 320, 450);
		
		CasePropriete bleuClair1 = new CasePropriete("Rue de Vaugirad", 100, 6, 30, 90, 270, 400, 550);
		CasePropriete bleuClair2 = new CasePropriete("Rue de Courcelles", 100, 6, 30, 90, 270, 400, 550);
		CasePropriete bleuClair3 = new CasePropriete("Avenue de la république", 120, 8, 40, 100, 300, 450, 600);
		
		CasePropriete rose1 = new CasePropriete("Boulevard de la villette", 140, 10, 50, 150, 450, 625, 750);
		CasePropriete rose2 = new CasePropriete("Avenue de  Neuilly", 140, 10, 50, 150, 450, 625, 750);
		CasePropriete rose3 = new CasePropriete("Rue du paradis", 160, 12, 60, 180, 500, 700, 900);
		
		CasePropriete orange1 = new CasePropriete("Avenue Mozart", 180, 14, 70, 200, 550, 750, 950);
		CasePropriete orange2 = new CasePropriete("Boulevard Saint-Michel", 180, 14, 70, 200, 550, 750, 950);
		CasePropriete orange3 = new CasePropriete("Place Pigalle", 200, 16, 80, 220, 600, 800, 1000);
		
		CasePropriete rouge1 = new CasePropriete("Avenue Matignon", 220, 18, 90, 250, 700, 875, 1050);
		CasePropriete rouge2 = new CasePropriete("Boulevard Malesherbes", 220, 18, 90, 250, 700, 875, 1050);
		CasePropriete rouge3 = new CasePropriete("Avenue Henri-Martin", 240, 20, 100, 300, 750, 925, 1100);
		
		CasePropriete jaune1 = new CasePropriete("Faubourg Saint-Honoré", 260, 22, 110, 330, 800, 975, 150);
		CasePropriete jaune2 = new CasePropriete("Place de la Bourse", 260, 22, 110, 330, 800, 975, 150);
		CasePropriete jaune3 = new CasePropriete("Rue de la fayette", 280, 24, 120, 360, 850, 1025, 1200);
		
		CasePropriete vert1 = new CasePropriete("Avenue de Breteuil", 300, 26, 130, 390, 900, 1100, 1275);
		CasePropriete vert2 = new CasePropriete("Avenue Foch", 300, 26, 130, 390, 900, 1100, 1275);
		CasePropriete vert3 = new CasePropriete("Boulevard des capucines", 320, 28, 150, 450, 1000, 1200, 1400);
		
		CasePropriete bleuFonce1 = new CasePropriete("Avenue des Champs-Élysées", 350, 35, 175, 500, 1100, 1300, 1500);
		CasePropriete bleuFonce2 = new CasePropriete("Rue de la paix", 400, 50, 200, 600, 1400, 1700, 2000);

		
		// Ajout des propriétés sous liste pour les quartiers
		List<CasePropriete> Lmarron = new ArrayList<CasePropriete>();
		Lmarron.add(marron1);
		Lmarron.add(marron2);

		List<CasePropriete> LbleuC = new ArrayList<CasePropriete>();
		LbleuC.add(bleuClair1);
		LbleuC.add(bleuClair2);
		LbleuC.add(bleuClair3);
		
		List<CasePropriete> Lrose = new ArrayList<CasePropriete>();
		Lrose.add(rose1);
		Lrose.add(rose2);
		Lrose.add(rose3);
		
		List<CasePropriete> Lorange = new ArrayList<CasePropriete>();
		Lorange.add(orange1);
		Lorange.add(orange2);
		Lorange.add(orange3);
		
		List<CasePropriete> Lrouge = new ArrayList<CasePropriete>();
		Lrouge.add(rouge1);
		Lrouge.add(rouge2);
		Lrouge.add(rouge3);
		
		
		List<CasePropriete> Ljaune = new ArrayList<CasePropriete>();
		Ljaune.add(jaune1);
		Ljaune.add(jaune2);
		Ljaune.add(jaune3);
		

		List<CasePropriete> Lvert = new ArrayList<CasePropriete>();
		Lvert.add(vert1);
		Lvert.add(vert2);
		Lvert.add(vert3);
		
		List<CasePropriete> LbleuF = new ArrayList<CasePropriete>();
		LbleuF.add(bleuFonce1);
		LbleuF.add(bleuFonce2);

		// Les cases taxes
		// Param : Nom, prixAPayer
		CaseTaxe taxe1 = new CaseTaxe("Impôts sur le revenu", 200);
		CaseTaxe taxe2 = new CaseTaxe("Taxe de luxe", 100);

		// Les cases gares
		// Param : Nom (loyer et prixAchat sont les mêmes pour tous)
		CaseGare gare1 = new CaseGare("Gare Montparnasse");
		CaseGare gare2 = new CaseGare("Gare de lyon");
		CaseGare gare3 = new CaseGare("Gare du nord");
		CaseGare gare4 = new CaseGare("Gare Saint-Lazard");

		// Les cases energies
		// Param : Nom, PrixAchat (pourrait ne pas y être))
		CaseEnergie energie1 = new CaseEnergie("Compagnie de distribution d'électricité", 150);
		CaseEnergie energie2 = new CaseEnergie("Compagnie de distribution des eaux", 150);

		// Les 4 cases dans les angles 
		CaseAngle depart = new CaseAngle("Départ", TypeCaseAngle.DEPART);
		CaseAngle visitePrison = new CaseAngle("Simple visite", TypeCaseAngle.VISITE_PRISON);
		CaseAngle parcGratuit = new CaseAngle("Parc gratuit", TypeCaseAngle.PARC_GRATUIT);
		CaseAngle prison = new CaseAngle("Prison", TypeCaseAngle.PRISON);
		
		
		
		Color c_marron = new Color(139, 49, 23);
		Color c_bleuClair = new Color(162, 223, 252); 
		Color c_rose = new Color(231, 0, 118); 
		Color c_orange = new Color(255, 119, 0); 
		Color c_rouge = new Color(244, 0, 0);
		Color c_jaune = new Color(255, 238, 0);
		Color c_vert = new Color(0, 157, 48); 
		Color c_bleuFonce = new Color(0, 81, 170); 



		// Les quartiers 
		// Param : couleur, nombrePropriete, prixAchatMaison, prixAchatHotel, listePropriété
		ZonePropriete marron = new ZonePropriete("Marron",c_marron, 2, 50, 50, Lmarron);
		ZonePropriete bleuClair = new ZonePropriete("Bleu Clair", c_bleuClair, 3, 50, 50, LbleuC);
		ZonePropriete rose = new ZonePropriete("Rose",c_rose,  3, 100, 100, Lrose);
		ZonePropriete orange = new ZonePropriete("Orange", c_orange, 3, 100, 100, Lorange);
		ZonePropriete rouge = new ZonePropriete("Rouge", c_rouge,  3, 150, 150, Lrouge);
		ZonePropriete jaune = new ZonePropriete("Jaune", c_jaune,  3, 150, 150, Ljaune);
		ZonePropriete vert = new ZonePropriete("Vert", c_vert, 3, 200, 200, Lvert);
		ZonePropriete bleuFonce = new ZonePropriete("Bleu Foncé", c_bleuFonce,  2, 200, 200, LbleuF);
		
		
		// Liste de toutes les cases dans l'ordre du plateau 
		List<Case> toutesLesCases = new ArrayList<Case>();
		toutesLesCases.add(depart);
		toutesLesCases.add(marron1);
		toutesLesCases.add(marron2);
		toutesLesCases.add(taxe1);
		toutesLesCases.add(gare1);
		toutesLesCases.add(bleuClair1);
		toutesLesCases.add(bleuClair2);
		toutesLesCases.add(bleuClair3);
		toutesLesCases.add(visitePrison);
		toutesLesCases.add(rose1);
		toutesLesCases.add(energie1);
		toutesLesCases.add(rose2);
		toutesLesCases.add(rose3);
		toutesLesCases.add(gare2);
		toutesLesCases.add(orange1);
		toutesLesCases.add(orange2);
		toutesLesCases.add(orange3);
		toutesLesCases.add(parcGratuit);
		toutesLesCases.add(rouge1);
		toutesLesCases.add(rouge2);
		toutesLesCases.add(rouge3);
		toutesLesCases.add(gare3);
		toutesLesCases.add(jaune1);
		toutesLesCases.add(jaune2);
		toutesLesCases.add(energie2);
		toutesLesCases.add(jaune3);
		toutesLesCases.add(prison);
		toutesLesCases.add(vert1);
		toutesLesCases.add(vert2);
		toutesLesCases.add(vert3);
		toutesLesCases.add(gare4);
		toutesLesCases.add(bleuFonce1);
		toutesLesCases.add(taxe2);
		toutesLesCases.add(bleuFonce2);
		
		
		depart.setCaseSuivante(marron1);
		marron1.setCaseSuivante(marron2);
		marron2.setCaseSuivante(taxe1);
		taxe1.setCaseSuivante(gare1);
		gare1.setCaseSuivante(bleuClair1);
		bleuClair1.setCaseSuivante(bleuClair2);
		bleuClair2.setCaseSuivante(bleuClair3);
		bleuClair3.setCaseSuivante(visitePrison);
		visitePrison.setCaseSuivante(rose1);
		rose1.setCaseSuivante(energie1);
		energie1.setCaseSuivante(rose2);
		rose2.setCaseSuivante(rose3);
		rose3.setCaseSuivante(gare2);
		gare2.setCaseSuivante(orange1);
		orange1.setCaseSuivante(orange2);
		orange2.setCaseSuivante(orange3);
		orange3.setCaseSuivante(parcGratuit);
		parcGratuit.setCaseSuivante(rouge1);
		rouge1.setCaseSuivante(rouge2);
		rouge2.setCaseSuivante(rouge3);
		rouge3.setCaseSuivante(gare3);
		gare3.setCaseSuivante(jaune1);
		jaune1.setCaseSuivante(jaune2);
		jaune2.setCaseSuivante(energie2);
		energie2.setCaseSuivante(jaune3);
		jaune3.setCaseSuivante(prison);
		prison.setCaseSuivante(vert1);
		vert1.setCaseSuivante(vert2);
		vert2.setCaseSuivante(vert3);
		vert3.setCaseSuivante(gare4);
		gare4.setCaseSuivante(bleuFonce1);
		bleuFonce1.setCaseSuivante(taxe2);
		taxe2.setCaseSuivante(bleuFonce2);
		bleuFonce2.setCaseSuivante(depart);
		
		
		marron1.setQuartier(marron);
		marron2.setQuartier(marron);

		bleuClair1.setQuartier(bleuClair);
		bleuClair2.setQuartier(bleuClair);
		bleuClair3.setQuartier(bleuClair);

		rose1.setQuartier(rose);
		rose2.setQuartier(rose);
		rose3.setQuartier(rose);

		orange1.setQuartier(orange);
		orange2.setQuartier(orange);
		orange3.setQuartier(orange);

		rouge1.setQuartier(rouge);
		rouge2.setQuartier(rouge);
		rouge3.setQuartier(rouge);

		jaune1.setQuartier(jaune);
		jaune2.setQuartier(jaune);
		jaune3.setQuartier(jaune);

		vert1.setQuartier(vert);
		vert2.setQuartier(vert);
		vert3.setQuartier(vert);

		bleuFonce1.setQuartier(bleuFonce);
		bleuFonce2.setQuartier(bleuFonce);
		
		
		jeu.setCases(toutesLesCases);

		
		return depart;
}
	
	
}
