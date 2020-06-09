package projet_info;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;


//DEFINITION DES CHAMPS
public class Joueur extends Unite{
		String nom;
		int points_conquetes;
		double experience; //en pourcentage
		int niveau; // entier compris entre 1 et 3
		public ArrayList<Astre> territoires;// on mettra un tableau extensible par la suite
		int tour; //compte le nombre de tours de la partie
		//double[] coordonnees;
		int points_dactions;
		int main;
		int numero;
		

		private Image imgObj1;
		private ImageIcon icoObj1;
		private Image imgObj2;
		private ImageIcon icoObj2;
		
	//CONSTRUCTEUR
		public Joueur(String nom, int x, int y, int numero) {
			super(x,y,30,30);
			this.nom = nom;
			this.points_conquetes = 1000; //on initialise tout Ã  0 pour l'instant
			this.niveau = 1;
			this.experience = 0;
			this.tour=1;
			this.points_dactions = 10;
			//this.coordonnees[0] = x; //initialisation des coordonnées de chaque joueur
			//this.coordonnees[1] = y;
			//this.territoires = new String[100]; // on prend un "grand " tableau pour l'instant pour Ã©viter d'utiliser les tableaux exte
			super.icoObj = new ImageIcon(getClass().getResource("joueur3.png")); 
			super.imgObj = this.icoObj.getImage(); 
			this.territoires = new ArrayList<Astre>();
			this.numero = 0;
			
			icoObj1 = new ImageIcon(getClass().getResource("soleil4.png")); //
			imgObj1 = this.icoObj1.getImage(); //
			icoObj2 = new ImageIcon(getClass().getResource("soleil5.png")); //
			imgObj2 = this.icoObj1.getImage(); //
			
		}
	
	//GETTERS ET SETTERS
		
		
		public double getExp() {return experience; }		 	
		
		public int getPoints_conquetes() {return points_conquetes;}

		public double getExperience() {return experience;}

		public int getNiveau() {return niveau;}

		public int getTour() {return this.tour;}

		public void setTour(int tour) {this.tour = tour;}
		
		public void setNom(String nom) {this.nom = nom;}
		
		public int getMain() {return this.main;}
	

		public int getPoints_dactions() {
			return points_dactions;
		}

		public void setPoints_dactions(int points_dactions) {
			this.points_dactions = points_dactions;
		}

		
		public void setPoints_conquetes(int points_conquetes) {
			this.points_conquetes = points_conquetes;
		}

		public void setExperience(double experience) {
			this.experience = experience;
		}
	
		public ArrayList<Astre> getTerritoires() {
			return territoires;
		}

		public void setTerritoires(ArrayList<Astre> territoires) {
			this.territoires = territoires;
		}
		

		//METHODES
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
		
		/*public void deplacer(Joueur j, int x) { //on considÃ¨re le pavÃ© de dÃ©placement 5123
			if(x==1) {
				j.coordonnees[0] += -1;
			}
			if(x==2) {
				j.coordonnees[1] += -1;
			}
			if(x==3) {
				j.coordonnees[0] += 1;
			}
			if(x==5) {
				j.coordonnees[1] += 1;
			}
			points_dactions -= 1;
		}*/
		
			public int compter_territoires () {
			return this.territoires.size(); //remplace les lignes qui suivent
			/*int m = 0;
			for(int i =0; i<= j.territoires.size(); i++){
				if (j.territoires.get(i) != null ) {
					m = m+1;}
				}
			return m;*/
		}
		
		public void conquerir(Astre a, Joueur j) {
			if (this.main == 1) {
				if (this.points_dactions >= 0) {
					//if (j.points_conquetes >= a.points_conquetes)
						
						this.points_conquetes -= a.getPoints_conquetes();
						this.experience += a.getTaille();
						this.points_dactions -= 1;
						this.territoires.add(a); //ca marche pas avec les lignes d'après
						a.setConquis(true);
						if(j.numero == 1) 
							a.setIcoObj(icoObj1);
							a.setImgObj(imgObj1);
						if(j.numero == 2) 
							a.setIcoObj(icoObj2);
							a.setImgObj(imgObj2);
						/*int m = compter_territoires (j);
						a.tour_conquete = j.tour;
						j.territoires[m] = (a.nom);
						System.out.println("Bravo, vous Ãªtes moche mais vous avez conquis un nouveau territoire");
						a.conquis = true;
						j.points_conquetes -= a.points_conquetes;
						int taille_totale = Partie.getTaille();
						j.experience += a.taille / taille_totale;
						j.points_dactions -= 5;*/
				}
			}
		}
					//else {System.out.println("Vous n'avez pas assez de points concquêtes");
					//} }
				//else {System.out.println("Vous n'avez pas assez de points d'actions");
			//}}
			//else {System.out.println("Ce n'est pas encore votre tour");
				//}	
			
	
		
		public void attaquer(Joueur j, Astre a) {
			if (this.main == 1) {
				if (this.points_dactions >= 5) {
					System.out.println("Le joueur" + this.nom + " attaque l'astre " + a.nom + "de" + j.nom);
					if ((this.points_conquetes >= a.points_conquetes) && (a.getX() == this.getX()) && (a.getY() == this.getY())) {
						this.conquerir(a,j);
						j.territoires.remove(a); // remplace les deux lignes qui suivent
						//for(int i =0; i<= j2.territoires.size(); i++){ 
							//if (j2.territoires.get(i) == a) { 
								
					}
							System.out.println("Le joueur" + this.nom + " a conquit l'astre " + a.nom + "de" + j.nom);
			
						}
						this.points_dactions -= 7;
					}
				
			
					else {
						System.out.println("Le joueur" + this.nom + " n'a pas assez de points conquêtes pour conquérir l'astre " + a.nom + "de" + j.nom + " en plus il est moche ");
				
			}}
				//else {System.out.println("Vous n'avez pas assez de points d'actions"); }}
			//else {System.out.println("Ce n'est pas encore votre tour");
			
			
			
		
		
		public void evoluer(Joueur j) { //correspond au changement de niveau
			if (j.main == 1) {
			}
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
		
		//public String[] display(Joueur j) {
			//String tab[] = { "nom : " + j.nom, " niveau : " + String.valueOf(j.niveau), "experience : " + String.valueOf(j.experience), "coordonnees : " + String.valueOf(j.coordonnees), "tour : " +String.valueOf(j.tour), "point conquetes : " + String.valueOf(j.points_conquetes) };
			// return tab;
		}
		/*public String[] display(Joueur j){
		String tab[] = new String[6];
		tab[0] = "nom : " + j.nom;
		tab[1] = " niveau : " + String.valueOf(j.niveau);
		tab[2] = "experience : " + String.valueOf(j.experience);
		tab[3] = "coordonnees : " + String.valueOf(j.coordonnees);
		tab[4] = "point conquetes : " + String.valueOf(j.points_conquetes);
		tab[5] = "tour : " + String.valueOf(j.tour);
		return tab;
		//for(int i=0 ; i <= tab.length ; i++){
			//return(tab[i]);
		}  */

	}
