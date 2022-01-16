package tp;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	
	private Monopoly jeu;
	
	JPanel mainPanel;

	
	public MyFrame(String nom, Monopoly pJeu) {
		super(nom);
		this.jeu = pJeu;
		
		this.mainPanel = new JPanel();


	}
	
	static String TAB = "";

	
	
	public void refreshFrame() {
		
		this.mainPanel.removeAll();
		
		List<Joueur> joueurs = this.jeu.getJoueurs();
		List<Case> cases = this.jeu.getCases();
		
		
		for (Joueur j : joueurs) {

            JPanel p_joueurs = new JPanel(); 

			String nom =  j.getNom() + " : " + j.getArgent() + " €";
			
		    JLabel l = new JLabel("<html> <p>" + TAB +  nom + TAB + "</p> </html>");

		    
		    p_joueurs.add(l);
		    
	        mainPanel.add(p_joueurs);

		}

        
 
        for(Case c : cases) {
        	
            JPanel p_cases = new JPanel(); 
            
            String label = c.nom;

        	 
        	 if (c.getClass() == CasePropriete.class) {
        		 CasePropriete cp = (CasePropriete)c;
        		 
        		 label += " [" + this.nomEtat(cp.etat);
        		 
                 p_cases.setBackground(cp.getQuartier().getCouleur());
                 
                 if (cp.getProprietaire() != null) {
        			 label += cp.getProprietaire().getNom(); 
        			 
        			 if (cp.etat.getClass() == EtatConstructible.class) {
            			 label += " " + cp.getNombreMaison();
        			 }
        			 
        		 }
                 
                 
                 label += "]";
                 
                
        	 }
        	 
        	 for (Joueur j : joueurs) {
            	 if (j.getPosition() == c) {
            		 label += " (" + j.getNom() + ") ";
            	 }
             }
        	 
        	
        	 
        	 JLabel l = new JLabel("<html> <p>" + TAB + label + TAB + "</p> </html>");


 		    
        	 p_cases.add(l);
        	 
             mainPanel.add(p_cases);


        }
        
        
        this.add(mainPanel);
        this.setSize(1000, 1000);  
		this.setVisible(true);
	}
	
	
	public String nomEtat(EtatPropriete etat) {
		if (etat.getClass() == EtatLibre.class) {
			return "Libre";
		}
		else if (etat.getClass() == EtatAchete.class) {
			return "Acheté : ";
		}
		else if (etat.getClass() == EtatConstructible.class) {
			return "Constructible : ";
		}
		else if (etat.getClass() == EtatIbis.class) {
			return "Hôtel : ";
		}
	
		return "Etat inconnu";
		
	}

}
