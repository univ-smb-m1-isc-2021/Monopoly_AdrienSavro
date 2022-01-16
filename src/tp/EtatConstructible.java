package tp;

public class EtatConstructible extends EtatPropriete  {
	
	

	public EtatConstructible(CasePropriete casePropriete) {
		super(casePropriete);
	}

	@Override
	public void operationPossible(Joueur j) {
		
		Joueur proprio = etatDeCase.getProprietaire();
		
		if (proprio == j) {
			System.out.print("Vous êtes sur une de vos propriétés");
		}else {
			int loyer = etatDeCase.donneLoyerConstructible();
			j.paye(loyer, true);
			proprio.paye(loyer, false);

		}
		
	}

}
