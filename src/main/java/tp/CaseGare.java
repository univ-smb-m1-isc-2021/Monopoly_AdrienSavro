package tp;

public class CaseGare extends CaseAchetable {
	
	
	private int PRIX_BASE_A_PAYER = 150;
	
	public CaseGare(String nom) {
		this.nom = nom;
		this.loyer = 25;
		this.estAchete = false;
		this.prixAchat = 150;
	}
	
	
	public void operationGare(Joueur j) {
		if (this.estAchete) {
			Joueur proprio = this.getProprietaire();
			
			int nbGares = proprio.getNombreGare();
			
			
			int prixAPayer = PRIX_BASE_A_PAYER * nbGares;
			
			j.paye(prixAPayer, true); // Paye
			proprio.paye(prixAPayer, false); // Est payé
			
		}else {
			boolean achete = j.renvoieAchete(PRIX_BASE_A_PAYER);
			if (achete) {
				j.paye(prixAchat, true);
				j.ajoutePropriete(this);
				this.setProprietaire(j);
			}
		}
	}

}
