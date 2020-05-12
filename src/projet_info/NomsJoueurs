package projet_info;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NomsJoueurs extends JPanel {

	
	public NomsJoueurs() {
		super();
        
		this.setFocusable(true);
		this.requestFocusInWindow();
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

	 
	
