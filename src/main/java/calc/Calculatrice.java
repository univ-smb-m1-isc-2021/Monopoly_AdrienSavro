package calc;

// pour l'interface graphique
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;

/**
 * La classe <code>Calculatrice</code> est l'interface graphique d'une
 * calculatrice simple. Le calcul des résultats sera effectué par un moteur de
 * calcul séparé spécifié par l'interface <code>IMoteurCalcul</code>.
 * 
 */

// fenetre qui gere elle meme ses evenements
public class Calculatrice extends JFrame implements ActionListener {
	
	Socket socket;
	
	private IMoteurCalcul moteurCalcul;

	// tableau de boutons
	private JButton[] buttons;

	// ecran de la calculatrice
	private TextField ecran;

	// tableau des legendes des boutons
	private static String[] labels = { "(", ")", "EFF", "OFF", "7", "8", "9",
			"*", "4", "5", "6", "/", "1", "2", "3", "-", "0", ".", "=", "+" };

	// pour savoir s'il faut effacer l'ecran ou non
	boolean estCalcule = false;

	// constructeur
	public Calculatrice(IMoteurCalcul moteur_calcul) throws IOException{		
		// la fenetre a pour titre "Calculatrice"
		super("Calculatrice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		socket = new Socket("localhost", 2000);
		
		this.moteurCalcul = moteur_calcul;

		setLayout(new BorderLayout());
		// l'ecran occupe le haut de la fenetre
		ecran = new TextField("");
		add(BorderLayout.NORTH, ecran);

		// creation du clavier
		JPanel clavier = new JPanel();
		clavier.setLayout(new GridLayout(5, 4));

		// on cree chaque bouton
		buttons = new JButton[labels.length];
		for (int i = 0; i < labels.length; i++) {
			buttons[i] = new JButton(labels[i]);
			clavier.add(buttons[i]);
			buttons[i].addActionListener(this);
		}

		// ajout du clavier au centre de la fenetre
		add(BorderLayout.CENTER, clavier);
		pack();
		setVisible(true);
	}

	// gestion des clics sur bouton
	public void actionPerformed(ActionEvent e) {
		// recuperation de la commande associee
		// (i.e. la legende du bouton)
		String s = e.getActionCommand();
		// chaque commande est identifiable par son premier caractere
		char c = s.charAt(0);
		switch (c) {
		// effacement de l'ecran
		case 'E':
			ecran.setText("");
			break;
		// on quitte
		case 'O':
			try {
				socket.close();
			}catch(IOException e1) {
				e1.printStackTrace();
			}
			System.exit(0);
			
		// calcul et affichage de l'expression
		case '=':
			try {
				PrintWriter PW = new PrintWriter(socket.getOutputStream());
				PW.println(ecran.getText());
				PW.flush();
				
				InputStreamReader ISR = new InputStreamReader(socket.getInputStream());
				BufferedReader BR = new BufferedReader(ISR);
				String resultat = BR.readLine();
				
				ecran.setText(resultat);
			}
			// plantage du programme
			catch (Exception ex) {
				JOptionPane.showMessageDialog(this,
						"<html>Erreur interne :<br>" + ex.getMessage()
								+ "<html>");
				ecran.selectAll();
			}
			break;
		// toutes les autres touches : ajout du caractere correspondant
		default:
			if (estCalcule)
				ecran.setText("");
			StringBuffer temp = new StringBuffer(ecran.getText());
			temp.append(c);
			ecran.setText(new String(temp));
			estCalcule = false;
			break;
		}
	}
}
