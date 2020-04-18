package projet_info;


public class Astre extends Unité {
// DEFINITION DES CHAMPS
	String nom; 
	int taille;
	int coordX;
	int coordY;
	int points_conquetes;
	boolean conquis; //statut de l'astre déterminant si le territoire est conquis
	int proportion_conquete; //facteur proportionnel qui donne le nombre de points_conquêtes en fonction de sa taille
	int tour_conquete; //compteur qui marque le tour de conquête d'un astre
	int taux_croissance; //taux de croissance de population
	int population;
	int population_max;

//CONSTRUCTEUR
	public Astre(String nom, int taille, int x, int y, int proportion, int taux) {
		this.nom = nom;
		this.taille = taille;
		this.coordX = x;
		this.coordY = y;
		this.proportion_conquete = proportion;
		this.points_conquetes = taille*proportion;
		this.conquis = false;
		this.taux_croissance = taux;
		this.population_max = 1000*this.taille; //1000 arbitraire
	}
	
//METHODES
	public void conquerir_astre(Astre a) {
		a.conquis = true;
		a.tour_conquete = tour; //tour défini dans la classe joueur : à chaque action d'un joueur tour+=1
	}
	
	public void population(Astre a, Joueur j) { //appelée quand un joueur conquiert un astre
		a.population = 1;  //initialisation
		if(a.population <= a.population_max) {
			a.population = j.tour*a.taille*a.taux_croissance;
		}
		else{
			a.population = a.population_max;
		}
	}
	
}
