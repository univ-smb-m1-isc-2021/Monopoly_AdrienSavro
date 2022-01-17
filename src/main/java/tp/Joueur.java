package tp;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

public class Joueur {

	private String nom;
	private boolean estEnPrison;
	private int nombreGare;
	private int nombreEnergie;
	private String couleur;
	
	private int argent;
	
	
	private Case position;
	
	private List<CaseAchetable> mesCases;
	
	private MyFrame f;
	
	
    Scanner clavier = new Scanner(System.in);

	
	public Joueur(String nom, Case depart, MyFrame f) {
		this.nom = nom;
		this.nombreGare = 0;
		this.nombreEnergie = 0;
		this.argent = 5000;
		this.position = depart;
		this.couleur = "BBB";
		
		this.f = f;
		
		this.mesCases = new ArrayList<CaseAchetable>();
		
	}	
	
	public void prendreMain(MyFrame f, Joueur j) {
		// Saisie utilisateur
		
		System.out.println(j.nom + " : Que souhaitez-vous faire ?");
		System.out.println("1. Lancer les dés");
		System.out.println("2. Ajouter une maison/hôtel");
		
		int decision = clavier.nextInt();

		
		if (decision == 1) {
			j.jouerTour();
		}else if (decision == 2) {
			j.veutAjouterMaison();
		}else {
			// R.
		}

		// // this.f.refreshFrame();

		
	}
	
	public void jouerTour() {
		int des = this.lancerDes();
		
		System.out.println("Résultat du lancer de dés : " + des);
		
		this.avancerPion(des);
		this.afficherPosition();
		
	
		position.opPossible(this);
		
		System.out.println(this.nom + " : Que souhaitez-vous faire ?");
		System.out.println("1. Ajouter une maison/hôtel");
		System.out.println("2. Terminer le tour");
		
		int decision = clavier.nextInt();

		if (decision == 1) {
			this.veutAjouterMaison();
		}else {
			// R.
		}
		
		
		
		

	}
	
	public int lancerDes() {
		return (int) (Math.random() * ( 12 - 1 ));
	}
	
	
	public void avancerPion(int nombre) {
		boolean passeCaseDepart = position.passeCaseDepart(nombre);
		if (passeCaseDepart) {
			this.argent += 200;
			System.out.println(this.nom + " est passé par la case départ et à reçu 200 €");
		}
		position = position.caseDans(nombre);
	}
	
	public void afficherPosition() {
		System.out.println("Vous êtes sur la case : '" + position.nom + "'");
	}
	
	public boolean renvoieAchete(int prixAchat) {
		if (argent >= prixAchat) {
			System.out.println("Voulez vous acheter : '" + position.nom + "' ? (1/0)");
			// Saisie utilisateur
			int choix = clavier.nextInt();
		
			return choix == 1 ? true : false;
			
		}else {
			return false;
		}
	}
	
	public void paye(int montant, boolean estDebite) {
		if (estDebite) {
			System.out.println(this.nom + " a été debité de " + montant + " €");
			this.argent = this.argent - montant;
		}else {
			System.out.println(this.nom + " a été crédité de " + montant + " €");
			this.argent = this.argent + montant;
		}
		
		//// this.f.refreshFrame();
	}
	
	public void ajoutePropriete(CaseAchetable c) {
		this.mesCases.add(c);
	}
	
	
	public List<CasePropriete> donneProprietesConstructible() {
		
		List<CasePropriete> tous = new ArrayList<CasePropriete>();
		

		for(CaseAchetable c : mesCases) {
			if (c.getClass() == CasePropriete.class) {
				CasePropriete enCours = (CasePropriete)c;
				
				
				if (enCours.etat.getClass() == EtatConstructible.class) {
					tous.add(enCours);
				}
			}
		}
		
		return tous;
	}
	
	public void veutAjouterMaison() {
		List<CasePropriete> mesTerrainsConstructibles = this.donneProprietesConstructible();
			
		if (mesTerrainsConstructibles.size() > 0) {

			this.afficheTerrainsConstructibles(mesTerrainsConstructibles);
			
			int nb = clavier.nextInt();
			
			if (nb > 0) {
				
				CasePropriete choix = mesTerrainsConstructibles.get(nb - 1);
				boolean estAjoute = choix.ajouterMaison(1);
				
				if (estAjoute) System.out.println("Vous avez ajouté " + 1 + " maison sur '" + choix.nom + "'");

			}
			
		}else {
			System.out.println("Vous n'avez aucun terrain constructible.");
		}
	}
	
	private void afficheTerrainsConstructibles(List<CasePropriete> propriete) {
		
		System.out.println("0 : Annuler");

		int increment = 1;
		
		for(CasePropriete c : propriete) {
			System.out.println(increment + " : " + c.nom  + " (" + c.getNombreMaison() + ")");
			increment += 1;
		}

		
		System.out.print("-> Choississez un nombre : ");

	}
	
	
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public int getNombreGare() {
		return nombreGare;
	}

	public void setNombreGare(int nombreGare) {
		this.nombreGare = nombreGare;
	}

	public int getNombreEnergie() {
		return nombreEnergie;
	}

	public void setNombreEnergie(int nombreEnergie) {
		this.nombreEnergie = nombreEnergie;
	}

	public int getArgent() {
		return argent;
	}

	public void setArgent(int argent) {
		this.argent = argent;
	}

	public boolean isEstEnPrison() {
		return estEnPrison;
	}

	public void setEstEnPrison(boolean estEnPrison) {
		this.estEnPrison = estEnPrison;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Case getPosition() {
		return position;
	}

	public void setPosition(Case position) {
		this.position = position;
	}

	public List<CaseAchetable> getMesCases() {
		return mesCases;
	}

	public void setMesCases(List<CaseAchetable> mesCases) {
		this.mesCases = mesCases;
	}
}
