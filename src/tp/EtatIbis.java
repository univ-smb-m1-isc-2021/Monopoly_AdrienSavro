package tp;

public class EtatIbis extends EtatPropriete {
	
	public EtatIbis(CasePropriete casePropriete) {
		super(casePropriete);
	}

	@Override
	public void operationPossible(Joueur j) {
		
		Joueur proprio = etatDeCase.getProprietaire();
		
		if (proprio == j) {
			System.out.print("Vous êtes sur une de vos propriétés");
		}else {
			int loyer = etatDeCase.getLoyerHotel();
			j.paye(loyer, true);
			proprio.paye(loyer, false);
			
		}
		
	}

}
