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
		static int valNum;

		//*** CONSTRUCTEUR ***//
		public Joueur(String nom, int x, int y) {
			super(x,y,30,30);
			this.nom = nom;
			this.points_conquetes = 1000; //on initialise tout Ã  0 pour l'instant
			this.niveau = 1;
			this.experience = 0;
			this.tour=1;
			this.points_dactions = 6;
			super.icoObj = new ImageIcon(getClass().getResource("joueur3.png")); 
			super.imgObj = this.icoObj.getImage(); 
			this.territoires = new ArrayList<Astre>();
			this.territoires_conquis = 0;	
			this.valNum = 0;
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
		public static void passer_tour(Joueur joueurquijoue, Joueur autre) { 
			joueurquijoue.tour += 1;
			joueurquijoue.main = 0;
			autre.main = 1;
			if (joueurquijoue.niveau == 1) { joueurquijoue.points_dactions = 6;}
			else if (joueurquijoue.niveau == 2) { joueurquijoue.points_dactions = 10;}
			else if (joueurquijoue.niveau == 3) { joueurquijoue.points_dactions = 15;}
			incremente_dates(autre);
			incremente_exp(autre);
			autre.points_conquetes += points_conqu_en_plus(autre);	
			autre.experience += exp_en_plus(autre);
			if (peut_evoluer(joueurquijoue) == true)
				evolution(joueurquijoue);
		}
	
		public static int points_conqu_en_plus(Joueur j) {
			int ptsCplus = 0;
			for(int i =0; i< j.territoires.size(); i++) {
				Astre a = j.territoires.get(i);
				ptsCplus += a.date*0.3*a.points_conquetes;
			}
			return ptsCplus;
		}
		
		public static int exp_en_plus(Joueur j) {
			int expplus = 0;
			for(int i =0; i< j.territoires.size(); i++) {
				Astre a = j.territoires.get(i);
				expplus += a.population;
			}
			return expplus;
		}
		
		public static void incremente_dates(Joueur j) {
			for(int i=0; i<j.territoires.size(); i++) {
				Astre a = j.territoires.get(i);
				Astre.ajout_date_astre(a);
			}
		}
		
		public static void incremente_exp(Joueur j) {
			for(int i=0; i<j.territoires.size(); i++) {
				Astre a = j.territoires.get(i);
				Astre.population(a,j);
			}
		}
		
		
		public void points(Joueur j, Astre a) {
			j.points_conquetes = j.points_conquetes - a.points_conquetes;
		}
		
		public int compter_territoires () {
			return this.territoires.size();}
		
		public void conquerir(Astre a, Joueur j) {
			if (this.main == 1) {
				if (this.points_dactions >= 0) {
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
		
		public void attaquer(Joueur j1, Joueur j2, Astre a) {
				if (j1.main == 1 && j1.points_dactions >= 2) {
					System.out.println("Le joueur" + j1.nom + " attaque l'astre " + a.nom + "de" + j2.nom);
					if ((j1.points_conquetes >= a.points_conquetes) && (Math.abs(a.getX() - j1.getX())< 30) && (Math.abs(a.getY() - j1.getY())< 30)) 
						j1.conquerir(a,j2);
						j2.territoires.remove(a); 
						j1.points_dactions -= 1;
						j1.experience += a.getTaille();
						j2.territoires_conquis -= 1;
					System.out.println("Le joueur" + j1.nom + " a conquit l'astre " + a.nom + "de" + j2.nom);}	
					else
						System.out.println("Le joueur" + j1.nom + " n'a pas assez de points conquêtes pour conquérir l'astre " + a.nom + "de" + j2.nom);
		}	
		
		public static boolean peut_evoluer(Joueur j) {
			if(j.experience > 5000 && valNum == 0 && j.experience <10000) {
				valNum = 1;
				return true;}
			else if(valNum == 5 && j.experience >10000) {
				valNum = 2;
				return true;}
			else {return false;}
		}
		
		public static void evolution(Joueur j) { //correspond au changement de niveau 1
			if(valNum == 1 && j.experience>5000)
					j.niveau = 2;
					j.points_conquetes -= 1000;
					valNum = 5;
			if(valNum == 2 && j.experience>10000)
					j.niveau = 3;
					j.points_conquetes -= 2000;	
					valNum = 6;		
		}
}
