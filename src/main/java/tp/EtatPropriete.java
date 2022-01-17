package tp;

public abstract class EtatPropriete {

	protected CasePropriete etatDeCase;
	
	public void operationPossible(Joueur j) {}
	
	public void boucleSurQuartier(Joueur j) {}
	
	public EtatPropriete(CasePropriete casePropriete) {
		this.etatDeCase = casePropriete;
	}

	public CasePropriete getEtatdeCase() {
		return etatDeCase;
	}

	public void setEtatdeCase(CasePropriete etatdeCase) {
		this.etatDeCase = etatdeCase;
	}
	
	public int calculPrixAPayer() {
		int nbMaisons = etatDeCase.getNombreMaison();
		
		if (nbMaisons == 0) {
			System.out.println(etatDeCase.nom + " :  il n'y a pas de maison, il faut payer " + etatDeCase.loyer);
			return etatDeCase.loyer;
		}
		
		else if (nbMaisons == 1) {
			System.out.println(etatDeCase.nom + " :  il y a 1 maison, il faut payer " + etatDeCase.getLoyer1M());
			return etatDeCase.getLoyer1M();
		}
		
		else if (nbMaisons == 2) {
			System.out.println(etatDeCase.nom + " :  il y a 2 maisons, il faut payer " + etatDeCase.getLoyer2M());
			return etatDeCase.getLoyer2M();
		}
		
		else if (nbMaisons == 3) {
			System.out.println(etatDeCase.nom + " :  il y a 3 maisons, il faut payer " + etatDeCase.getLoyer3M());
			return etatDeCase.getLoyer3M();
		}
		
		else if (nbMaisons == 4) {
			System.out.println(etatDeCase.nom + " :  il y a 4 maisons, il faut payer " + etatDeCase.getLoyer4M());
			return etatDeCase.getLoyer4M();
		}
		
		else {
			System.out.println(etatDeCase.nom + " :  il y a un hôtel, il faut payer " + etatDeCase.getLoyerHotel());
			return etatDeCase.getLoyerHotel();
		}
		
		
	}
	
}
