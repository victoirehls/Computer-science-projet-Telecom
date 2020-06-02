package projet_info;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Accueil extends JPanel {
	
	public Accueil() {
		super();
		              
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		
		/* this.setLayout(new FlowLayout());
		
		JButton jouer = new JButton(new ActionJouer(this,"JOUER"));
		this.add(jouer);
		
		JButton param = new JButton("PARAMETRES");
		this.add(param);
		
		JButton aide = new JButton("AIDE");
		this.add(aide);*/
		
		/*JLabel menu = new JLabel("MENU PRINCIPAL");
		Font police = new Font("Tahoma", Font.BOLD, 16);
		menu.setFont(police);
		menu.setForeground(Color.blue);
		menu.setHorizontalAlignment(JLabel.CENTER);
		this.add(menu);*/
		
		/*this.setLayout(new BorderLayout());
		this.add(jouer, BorderLayout.CENTER);
		this.add(param, BorderLayout.CENTER);
		this.add(aide, BorderLayout.SOUTH);
		this.add(menu, BorderLayout.NORTH);*/
	}
	
		public void paintComponent(Graphics g) {  //méthode qui gère la peinture de l'écran
			super.paintComponents(g);
			Graphics gc = (Graphics2D)g;
			
			 try {
			      Image img = ImageIO.read(new File("fond.jpg"));
			      g.drawImage(img,0,0, this);
			     
			    } catch (IOException e) {
			      e.printStackTrace();
			    }
		}
			
	
	
	}
	
