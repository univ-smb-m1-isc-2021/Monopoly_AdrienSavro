package tp;

public class CaseAngle extends CaseNonAchetable {

	private TypeCaseAngle typeCase;
	
	public CaseAngle(String nom, TypeCaseAngle typeCase) {
		this.nom = nom;
		this.typeCase = typeCase;
	}

	public TypeCaseAngle getTypeCase() {
		return typeCase;
	}

	public void setTypeCase(TypeCaseAngle typeCase) {
		this.typeCase = typeCase;
	}
}
