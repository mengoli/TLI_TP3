

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
//he ho
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import org.omg.CORBA.Bounds;

public class main implements Runnable {
	
	public void run() {
	
		// Creation d'une fenetre
		JFrame frame = new JFrame("VLC");

		// Un clic sur le bouton de fermeture clos l'application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelFrame = new JPanel();		
	
		JPanel principal = new JPanel();
		
		principal.setLayout(new BorderLayout());

		//Panel du nord 
		JPanel north = new JPanel();
		north.setLayout(new BorderLayout());
		JPanel titre = new JPanel();
		titre.add(new JLabel("Lecteur multimedia VLC"));
		
		//Bouton rouge, jaune , vert
		JPanel boutonTitre = new JPanel();
		JButton fermer = new JButton("O");
		JButton reduire = new JButton("O");
		JButton aggrandir = new JButton("O");
		boutonTitre.add(fermer,BorderLayout.WEST);
		boutonTitre.add(reduire,BorderLayout.CENTER);
		boutonTitre.add(aggrandir,BorderLayout.EAST);
		
		//Ajout des composant du nord 
		north.add(boutonTitre,BorderLayout.WEST);
		north.add(titre,BorderLayout.CENTER);
		north.add(new JButton(" "),BorderLayout.EAST);
		
		//Panel du west
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(2, 0));
		//bouton <<, >, >> 
		JPanel lecture = new JPanel();
		lecture.setLayout(new BorderLayout());
		JButton precedent = new JButton(" << ");
		JButton jouer = new JButton(" > ");
		JButton suivant = new JButton(" >> ");
		
		//Ajout des boutons au panel lecture
		lecture.add(precedent,BorderLayout.WEST);
		lecture.add(jouer,BorderLayout.CENTER);
		lecture.add(suivant,BorderLayout.EAST);
		
		JPanel option = new JPanel();
		option.setLayout(new BorderLayout());
		JButton retour = new JButton(" |<< ");
		JButton stop = new JButton(" [] ");
		JButton suite = new JButton(" >>| ");
		
		//Ajout des boutons au panel lecture
		option.add(retour,BorderLayout.WEST);
		option.add(stop,BorderLayout.CENTER);
		option.add(suite,BorderLayout.EAST);
		
		//Ajout panel center
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		
		//panel affichage
		JPanel affichage = new JPanel();
		affichage.setLayout(new BorderLayout());
		JPanel texte = new JPanel();
		texte.setLayout(new BorderLayout());
		JLabel afficheTexte = new JLabel("lecteur multimédia VLC");
		JLabel afficheTemps = new JLabel("02:10");
		texte.add(afficheTexte,BorderLayout.WEST);
		texte.add(afficheTemps,BorderLayout.EAST);
		affichage.add(texte,BorderLayout.NORTH);
		affichage.add(new JSlider(),BorderLayout.CENTER);	
		
		//panel sonore
		JPanel sonore = new JPanel();
		sonore.setLayout(new BorderLayout());
		
		//bouton -, volume, +
		JPanel volume = new JPanel();
		volume.setLayout(new BorderLayout());
		JLabel plus = new JLabel("+");
		JLabel moins = new JLabel("-");
		volume.add(plus, BorderLayout.WEST);
		volume.add(new JSlider(),BorderLayout.CENTER);		
		volume.add(moins, BorderLayout.EAST);
		
		//equaliseur
		JPanel equa = new JPanel();
		equa.setLayout(new BorderLayout());
		JToggleButton equaliseur = new JToggleButton("P");
		JToggleButton bibliotheque = new JToggleButton("Q");
		equa.add(equaliseur, BorderLayout.WEST);	
		equa.add(bibliotheque, BorderLayout.EAST);
		
		//ajouter composants à sonore
		sonore.add(volume, BorderLayout.WEST);
		sonore.add(equa, BorderLayout.EAST);
		
		
		//Ajout des composant a center
		center.add(affichage,BorderLayout.CENTER);
		center.add(sonore,BorderLayout.SOUTH);
		center.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		
		
		//Ajout des panel au panel west
		west.add(lecture,BorderLayout.NORTH);
		west.add(option,BorderLayout.CENTER);
		
		
		
		//Ajout des composant au panel principal
		principal.add(north,BorderLayout.NORTH);
		principal.add(west,BorderLayout.WEST);
		principal.add(center,BorderLayout.CENTER);
		
		panelFrame.setLayout(new BorderLayout());
		panelFrame.add(principal,BorderLayout.NORTH);
		
		JPanel bibliothequeTable = new JPanel();
		
		panelFrame.add(bibliothequeTable,new BorderLayout().CENTER);

		//Ajout panel
		frame.addComponentListener(new EcouteurComposant(frame));
		// On fixe la taille et on demarre
	/*	frame.setMinimumSize(new Dimension(700,140));
		frame.setMaximumSize(new Dimension(1500,140));*/
		frame.add(panelFrame);
		frame.setSize(700, 140);
		frame.setVisible(true);
	}

	public static void main(String [] args) {
		SwingUtilities.invokeLater(new main());
	}
}
