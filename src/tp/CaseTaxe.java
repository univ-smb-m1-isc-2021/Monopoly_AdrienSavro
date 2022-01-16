package tp;

public class CaseTaxe extends CaseNonAchetable {
	private int prixAPayer;
	
	
	public CaseTaxe(String nom, int prixAPayer) {
		this.nom = nom;
		this.setPrixAPayer(prixAPayer);
	}


	public int getPrixAPayer() {
		return prixAPayer;
	}


	public void setPrixAPayer(int prixAPayer) {
		this.prixAPayer = prixAPayer;
	}
	
	public void fairePayer(Joueur j) {
		System.out.println("Vous êtes sur " + this.nom + " vous devez payer " + this.prixAPayer);
		j.paye(this.prixAPayer, true);
	}
}
