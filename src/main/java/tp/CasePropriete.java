package tp;

public class CasePropriete extends CaseAchetable {
	private int loyer1M;
	private int loyer2M;
	private int loyer3M;
	private int loyer4M;
	private int loyerHotel;
	private int nombreMaison;
	private boolean aHotel;
	
	
	public EtatPropriete etat;
	
	
	private ZonePropriete quartier;
	
	
	public CasePropriete(String nom, int prixAchat,  int loyer, int loyer1M, int loyer2M, int loyer3M, int loyer4M, int loyerHotel) {
		this.nom = nom;
		this.loyer = loyer;
		this.prixAchat = prixAchat;
		this.estAchete = false;
		this.loyer1M = loyer1M;
		this.loyer2M = loyer2M;
		this.loyer3M = loyer3M;
		this.loyer4M = loyer4M;
		this.loyerHotel = loyerHotel;
		this.nombreMaison = 0;
		this.aHotel = false;
		this.etat = new EtatLibre(this);
	}
	
	
	public void operationPossible(Joueur j) {
		etat.operationPossible(j);
		
		if (etat == new EtatAchete(this)) {
			etat.boucleSurQuartier(j);
		}
	
	}
	
	public void majEtat(EtatPropriete e) {
		etat = e;
	}
	
	public boolean estProprietaire(Joueur j) {
		if (this.getProprietaire() == j) {
			return true;
		}
		
		return false;
	}
	
	public boolean ajouterMaison(int nombre) {
		int prix = this.quartier.getPrixAchatMaison();
		Joueur proprio = this.getProprietaire();
		
		// Uniquement si le propriétaire a assez d'argent pour acheter une maison
		if (proprio.getArgent() >= prix) {
			proprio.paye(prix, true);
			this.nombreMaison += nombre;
			
			// Si a atteint les 5 maisons, la propriété passe à l'état IBIS (hôtel)
			if(this.nombreMaison == 5) {
				EtatIbis ei = new EtatIbis(this);
				this.majEtat(ei);
			}
			return true;
		}
		else {
			System.out.println("Vous n'avez pas assez d'argent pour ajouter une maison sur cette propriété.");
			return false;
		}
				
		
		
	}	
	
	public int donneLoyerConstructible() {
		switch(this.nombreMaison) {
			case 0 : return this.loyer*2;
			case 1 : return this.loyer1M;
			case 2 : return this.loyer2M;
			case 3 : return this.loyer3M;
			case 4 : return this.loyer4M;
			default : return 0;
		}
	}
	
	
	
	
	public int getLoyer1M() {
		return loyer1M;
	}
	public void setLoyer1M(int loyer1m) {
		loyer1M = loyer1m;
	}
	public int getLoyer2M() {
		return loyer2M;
	}
	public void setLoyer2M(int loyer2m) {
		loyer2M = loyer2m;
	}
	public int getLoyer3M() {
		return loyer3M;
	}
	public void setLoyer3M(int loyer3m) {
		loyer3M = loyer3m;
	}
	public int getLoyer4M() {
		return loyer4M;
	}
	public void setLoyer4M(int loyer4m) {
		loyer4M = loyer4m;
	}
	public int getLoyerHotel() {
		return loyerHotel;
	}
	public void setLoyerHotel(int loyerHotel) {
		this.loyerHotel = loyerHotel;
	}
	public int getNombreMaison() {
		return nombreMaison;
	}
	public void setNombreMaison(int nombreMaison) {
		this.nombreMaison = nombreMaison;
	}
	public boolean isaHotel() {
		return aHotel;
	}
	public void setaHotel(boolean aHotel) {
		this.aHotel = aHotel;
	}


	public ZonePropriete getQuartier() {
		return quartier;
	}


	public void setQuartier(ZonePropriete quartier) {
		this.quartier = quartier;
	}
}
