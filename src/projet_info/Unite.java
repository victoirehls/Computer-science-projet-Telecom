package projet_info;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Unite {
	//*** VARIABLES ***//
	private int x,y ;
	private int largeur, hauteur;
	
	protected Image imgObj;
	protected ImageIcon icoObj;
	
	//*** CONSTRUCTEUR ***//
	public Unite(int x,int y, int largeur, int hauteur) {
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	//*** GETTER ***//
	@SuppressWarnings("exports")
	public Image getImgObj() {return imgObj;}
	public int getX() {return x;}
	public int getY() {return y;}
	
	
	//*** METHODES ***//
	public void deplacement(){
		if (Fenetre.scene.getxFond() != 0 || Fenetre.scene.getyFond() != 0 ) {
				this.x += Fenetre.scene.getDx();
				this.y += Fenetre.scene.getDy();
		}
	}
	
}

