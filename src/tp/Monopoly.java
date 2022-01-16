package tp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;

public class Monopoly {
	
	private List<Joueur> joueurs;
	private Plateau plateau;
	private List<Case> cases;
	
	public void lancerPartie(MyFrame j) {
		
		setOrdreDeJeu();
		
		
		while (true) {
			for (Joueur joueur : joueurs) {
				joueur.prendreMain(j, joueur);
			}
		}
	}
		
	
	public Monopoly() {
		joueurs = new ArrayList<Joueur>();
		
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	
	public void ajouteJoueur(Joueur j) {
		this.joueurs.add(j);
	}
	
	public void setOrdreDeJeu() {
        Collections.shuffle(this.joueurs);
        
		System.out.println("Voici l'ordre du jeu : ");
		
		for(Joueur j : this.joueurs) {
			System.out.println(j.getNom());
		}

	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}


	public List<Case> getCases() {
		return cases;
	}


	public void setCases(List<Case> cases) {
		this.cases = cases;
	}

}
