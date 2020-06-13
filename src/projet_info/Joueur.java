package projet_info;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;


//DEFINITION DES CHAMPS
public class Joueur extends Unite{
		//*** DEFINITION DES CHAMPS ***//
		String nom;
		int points_conquetes;
		double experience; //en pourcentage
		int niveau; // entier compris entre 1 et 3
		public ArrayList<Astre> territoires;// on mettra un tableau extensible par la suite
		int tour; //compte le nombre de tours de la partie
		int points_dactions;
		int main;
		int territoires_conquis; 

		//*** CONSTRUCTEUR ***//
		public Joueur(String nom, int x, int y) {
			super(x,y,30,30);
			this.nom = nom;
			this.points_conquetes = 1000; //on initialise tout Ã  0 pour l'instant
			this.niveau = 1;
			this.experience = 0;
			this.tour=1;
			this.points_dactions = 10;
			super.icoObj = new ImageIcon(getClass().getResource("joueur3.png")); 
			super.imgObj = this.icoObj.getImage(); 
			this.territoires = new ArrayList<Astre>();
			this.territoires_conquis = 0;	
		}
	
		//*** GETTERS ET SETTERS ***//
		
		
		public double getExp() {return experience; }		 	
		public int getPoints_conquetes() {return points_conquetes;}
		public double getExperience() {return experience;}
		public int getNiveau() {return niveau;}
		public int getTour() {return this.tour;}
		public void setTour(int tour) {this.tour = tour;}
		public void setNom(String nom) {this.nom = nom;}
		public int getMain() {return this.main;}
		public int getPoints_dactions() {return points_dactions;}
		public void setPoints_dactions(int points_dactions) {this.points_dactions = points_dactions;}
		public void setPoints_conquetes(int points_conquetes) {this.points_conquetes = points_conquetes;}
		public void setExperience(double experience) {this.experience = experience;}
		public ArrayList<Astre> getTerritoires() {return territoires;}
		public void setTerritoires(ArrayList<Astre> territoires) {this.territoires = territoires;}
		

		//*** METHODES ***//
		public static void passer_tour(Joueur joueurquijoue, Joueur autre) { // Ã  appeler Ã  chaque tour d'un seul joueur
			joueurquijoue.tour += 1;
			joueurquijoue.main = 0;
			autre.main = 1;
			if (joueurquijoue.niveau == 1) { joueurquijoue.points_dactions = 10;}
			else if (joueurquijoue.niveau == 2) { joueurquijoue.points_dactions = 20;}
			else if (joueurquijoue.niveau == 3) { joueurquijoue.points_dactions = 30;}
			
		}
		
		public void points(Joueur j, Astre a) {
			j.points_conquetes = j.points_conquetes - a.points_conquetes;
		}
		
		public int compter_territoires () {
			return this.territoires.size();}
		
		public void conquerir(Astre a, Joueur j) {
			if (this.main == 1) {
				if (this.points_dactions >= 0) {
					//if (j.points_conquetes >= a.points_conquetes)
						
						this.points_conquetes -= a.getPoints_conquetes();
						this.experience += a.getTaille();
						this.points_dactions -= 1;
						this.territoires.add(a);
						a.setConquis(true);
						this.territoires_conquis +=1;   
						System.out.println(territoires_conquis);  
				}
			}
		}
		
		public void attaquer(Joueur j, Astre a) {
				if (this.main == 1) {
					if (this.points_dactions >= 5) {
						System.out.println("Le joueur" + this.nom + " attaque l'astre " + a.nom + "de" + j.nom);
						if ((this.points_conquetes >= a.points_conquetes) && (a.getX() == this.getX()) && (a.getY() == this.getY())) {
							this.conquerir(a,j);
							j.territoires.remove(a); 		
						}
								System.out.println("Le joueur" + this.nom + " a conquit l'astre " + a.nom + "de" + j.nom);
				
							}
							this.points_dactions -= 7;
						}
					
				
						else {
							System.out.println("Le joueur" + this.nom + " n'a pas assez de points conquêtes pour conquérir l'astre " + a.nom + "de" + j.nom + " en plus il est moche ");}
					
		}
				
		
		public void evoluer(Joueur j) { //correspond au changement de niveau
			if (j.main == 1) {
				if (j.points_conquetes < 50000) { 
					System.out.println("Vous n'avez pas assez de points conquêtes pour réaliser cette action ");
					}
				else if(j.points_conquetes > 50000) { //50 000 arbitraire
					j.niveau = 2;
					j.points_dactions = 20;
					j.points_conquetes -= 50000;
				}
				else if(j.points_conquetes > 100000){ //100 000 arbitraire
					j.niveau = 3;
					j.points_dactions = 30;
					j.points_conquetes -= 100000;
				}
			else {System.out.println("Ce n'est pas encore votre tour");}
		}
	}
}
