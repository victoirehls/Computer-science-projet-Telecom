package projet_info;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//*** a faire *** faire une touche pour donner une vue générale du jeu, en réinitialisant la taille de l'image pour écran plein,
// et les coord du fond a (0,0)
//**** a faire**** :il faut que ça stoppe net (pas quand on lache) aux extremités du jeu

public class Clavier implements KeyListener{
	@SuppressWarnings("exports")
	public void keyPressed(KeyEvent e) {    //penser qu'il faudra déplacer tous les éléments graphiques!!
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) { //si le code de la touche = touche fleche vers la droite
			if(Fenetre.scene.getxFond() > -2590+1280) { 
				Fenetre.scene.setDx(-20);
				Fenetre.scene.setDxrect1(-20);}    //
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(Fenetre.scene.getxFond() < 0) { 
				Fenetre.scene.setDx(20);
				Fenetre.scene.setDxrect1(20);}     //
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(Fenetre.scene.getyFond() < 0) {
				Fenetre.scene.setDy(20);
				Fenetre.scene.setDyrect1(20);}     //
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(Fenetre.scene.getyFond() > -1920+830) {
				Fenetre.scene.setDy(-20);
				Fenetre.scene.setDyrect1(-20);}	//
		}
	}
	@SuppressWarnings("exports")
	public void keyReleased(KeyEvent e) {
		Fenetre.scene.setDx(0); // quand on lache la touche, on veut que dx revienne à 0
		Fenetre.scene.setDy(0);
		Fenetre.scene.setDxrect1(0);  //
		Fenetre.scene.setDyrect1(0);  //
	}
	@SuppressWarnings("exports")
	public void keyTyped(KeyEvent e) {}

}
