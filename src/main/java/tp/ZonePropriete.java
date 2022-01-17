package tp;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class ZonePropriete {
	private String nomCouleur;
	private Color couleur;
	private int nombrePropriete;
	private int prixAchatMaison;
	private int prixAchatHotel;
	
	public List<CasePropriete> proprietes;
	
	
	public ZonePropriete(String nomCouleur, Color couleur, int nombrePropriete, int prixAchatMaison, int prixAchatHotel, List<CasePropriete> proprietes) {
		this.setNomCouleur(nomCouleur);
		this.couleur = couleur;
		this.nombrePropriete = nombrePropriete;
		this.prixAchatMaison = prixAchatMaison;
		this.prixAchatHotel = prixAchatHotel;
		this.proprietes = proprietes;
	}
	
	
	public boolean boucleSurQuartier(Joueur j) {
		for(CasePropriete c : this.proprietes) {
			if (!c.estProprietaire(j)) {
				return false;
			}
		}
		return true;
	}
	
	


	public Color getCouleur() {
		return couleur;
	}


	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}


	public int getNombrePropriete() {
		return nombrePropriete;
	}


	public void setNombrePropriete(int nombrePropriete) {
		this.nombrePropriete = nombrePropriete;
	}


	public int getPrixAchatMaison() {
		return prixAchatMaison;
	}


	public void setPrixAchatMaison(int prixAchatMaison) {
		this.prixAchatMaison = prixAchatMaison;
	}


	public int getPrixAchathotel() {
		return prixAchatHotel;
	}


	public void setPrixAchathotel(int prixAchathotel) {
		this.prixAchatHotel = prixAchathotel;
	}


	public String getNomCouleur() {
		return nomCouleur;
	}


	public void setNomCouleur(String nomCouleur) {
		this.nomCouleur = nomCouleur;
	}
}
