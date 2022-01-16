package tp;

public class CaseEnergie extends CaseAchetable {
	
	public CaseEnergie(String nom, int prixAchat) {
		this.nom = nom;
		this.loyer = 0;
		this.estAchete = false;
		this.prixAchat = prixAchat;
	}
	
	
	public void operationEnergie(Joueur j) {
		if (this.estAchete) {
			Joueur proprio = this.getProprietaire();
			
			int nbEnergies = proprio.getNombreEnergie();
			
			int des = j.lancerDes();
			
			int prixAPayer = this.calculPrixAPayer(des, nbEnergies);
			
			j.paye(prixAPayer, true); // Paye
			proprio.paye(prixAPayer, false); // Est payé
			
		}else {
			boolean achete = j.renvoieAchete(this.prixAchat);
			if (achete) {
				j.paye(prixAchat, true);
				j.ajoutePropriete(this);
				this.setProprietaire(j);
			}		
		}
	}
	
	private int calculPrixAPayer(int des, int nombre) {
		int multiplicateur = (nombre == 1 ? 4 : 10);
		
		return 150 * multiplicateur * des;
	}
}
