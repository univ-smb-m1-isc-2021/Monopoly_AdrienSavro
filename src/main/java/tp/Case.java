package tp;

public abstract class Case {

	protected String nom;
	
	private Case caseSuivante;
	
	
	public Case caseDans(int nombreDes) {
		
		Case actuel = this;
		for(int i = 1; i <= nombreDes; i++) {
			actuel = actuel.caseSuivante;
		}
		
		return actuel;
	}
	
	public boolean passeCaseDepart(int nombreDes) {
		
		Case actuel = this;
		for(int i = 1; i <= nombreDes; i++) {
			actuel = actuel.caseSuivante;
			if (actuel.nom == "Départ") {
				return true;
			}
		}
		
		return false;
	}
	
	
	


	public Case getCaseSuivante() {
		return caseSuivante;
	}
	
	public String getNom() {
		return this.nom;
	}


	public void setCaseSuivante(Case caseSuivante) {
		this.caseSuivante = caseSuivante;
	}
	
	
	public void opPossible(Joueur j) {
		if (this.getClass() == CasePropriete.class) {
			CasePropriete c = (CasePropriete)this;
			c.operationPossible(j);
		}
		
		if (this.getClass() == CaseGare.class) {
			CaseGare c = (CaseGare)this;
			c.operationGare(j);

		} 
		
		if (this.getClass() == CaseEnergie.class) {
			CaseEnergie c = (CaseEnergie)this;
			c.operationEnergie(j);
		}
		
		if (this.getClass() == CaseTaxe.class) {
			CaseTaxe ct = (CaseTaxe)this;
			ct.fairePayer(j);
		}
		
		if (this.getClass() == CaseAngle.class) {
			
		}
	}
	
	
	
	
	
	
}
