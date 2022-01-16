package tp;

public class EtatAchete extends EtatPropriete{
	
	public EtatAchete(CasePropriete casePropriete) {
		super(casePropriete);
	}

	@Override
	public void boucleSurQuartier(Joueur j) {
		ZonePropriete quartier = etatDeCase.getQuartier();
		
		
		boolean estConstructible = quartier.boucleSurQuartier(j);
		
		if (estConstructible) {
			System.out.println("Le quartier " + quartier.getNomCouleur() +  " devient constructible.");

			for (CasePropriete c : quartier.proprietes) {
				System.out.println(c.nom);


				EtatConstructible etatConstructible = new EtatConstructible(etatDeCase);

				c.majEtat(etatConstructible);
			}
			
		}
		
		
	}
	
	@Override
	public void operationPossible(Joueur j) {
		
		Joueur proprio = etatDeCase.getProprietaire();
		
		if (proprio == j) {
			System.out.print("Vous êtes sur une de vos propriétés");
		}else {
			
			int loyer = this.calculPrixAPayer();
			j.paye(loyer, true);
			proprio.paye(loyer, false);
		}
		
	}

}
