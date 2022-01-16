package tp;

public abstract class CaseAchetable extends Case{

	protected int prixAchat;
	protected int loyer;
	protected boolean estAchete;
	
	private Joueur proprietaire;

	public Joueur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
	}
}
