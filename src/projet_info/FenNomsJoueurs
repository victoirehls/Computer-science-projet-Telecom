package projet_info;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenNomsJoueurs extends JFrame implements ActionListener {
	
	private JPanel container = new NomsJoueurs();

	private JLabel nom1 = new JLabel("Joueur 1");
	private JLabel nom2 = new JLabel("Joueur 2");
	private static JTextField joueur1 = new JTextField();
	private static JTextField joueur2 = new JTextField();
	private JButton jouer = new JButton("JOUER");

	


	public FenNomsJoueurs() {
		super();
		this.setTitle("Menu joueurs");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		container.setLayout(new FlowLayout());
		
		nom1.setForeground(Color.WHITE);
		container.add(nom1);
		
		
		joueur1.setColumns(10);
		container.add(joueur1);

		nom2.setForeground(Color.WHITE);
		container.add(nom2);
		
	
		joueur2.setColumns(10);
		container.add(joueur2);
		

		container.add(jouer);
		jouer.addActionListener(this);
		
		this.setContentPane(container);
		this.setVisible(true);
		
	}
	
	 public static String getJTextField1() {	 
         return joueur1.getText();
    }
	 
	 public static String getJTextField2() {
         return joueur2.getText();
    }
	
	public void actionPerformed(ActionEvent arg0) { 
		 if(arg0.getSource() == jouer) {
			 this.setVisible(false);
		 	 JFrame fenetre = new Fenetre();
		 	 fenetre.setVisible(true);
		 }
	}
	
	
}

	

