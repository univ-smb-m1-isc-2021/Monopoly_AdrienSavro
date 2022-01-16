package tp;

public class EtatLibre extends EtatPropriete {
	
	public EtatLibre(CasePropriete casePropriete) {
		super(casePropriete);
	}

	@Override
	public void operationPossible(Joueur j) {
		
		int prixAchat = etatDeCase.prixAchat;
		
		boolean achete = j.renvoieAchete(prixAchat);
		
		if (achete) {
			j.paye(prixAchat, true);
			
			etatDeCase.setProprietaire(j);
			
			j.ajoutePropriete(etatDeCase);
			
			
			EtatAchete etatAchete = new EtatAchete(etatDeCase);
			
			etatDeCase.majEtat(etatAchete);
			
			etatAchete.boucleSurQuartier(j);
		}
		
		
		
	}
}
