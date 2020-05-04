package projet_info;

//DEFINITION DES CHAMPS
public class Joueur extends Unite{
	String nom;
	int points_conquetes;
	double experience; //en pourcentage
	int niveau; // entier compris entre 1 et 3
	char[] territoires;// on mettra un tableau extensible par la suite
	int tour; //compte le nombre de tours de la partie
	double[] coordonnees;
	
//CONSTRUCTEUR
	public Joueur(String nom, double x, double y) {
		this.nom = nom;
		this.points_conquetes = 0; //on initialise tout à 0 pour l'instant
		this.niveau = 1;
		this.experience = 0;
		this.coordonnees[0] = x; //initialisation des coordonnées de chaque joueur
		this.coordonnees[1] = y;
	}
	
//METHODES
	public void compteur_tour() { // à appeler à chaque tour d'un seul joueur
		tour = tour + 1;
	}
	
	public void points(Joueur j, Astre a) {
		j.points_conquetes = j.points_conquetes - a.points_conquetes;
	}
	
	public void deplacer(Joueur j, int x) { //on considère le pavé de déplacement 5123
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
	}
	
	public void conquerir(Joueur j, Astre a) {
		blablabla	
	}
	
	public void attaquer(Joueur j1, Joueur j2, Astre a) {
		blablabla
	}
	
	public void evoluer(Joueur j) { //correspond au changement de niveau
		if(experience < 50000) { //50 000 arbitraire
			j.niveau = 2;
		}
		else if(experience < 100000){ //100 000 arbitraire
			j.niveau = 3;
		}
	}

}
