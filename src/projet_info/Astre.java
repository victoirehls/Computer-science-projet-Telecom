package projet_info;

import javax.swing.ImageIcon;

public class Astre extends Unite {

	//*** DEFINITION DES CHAMPS ***//
	String nom; 
	int taille;
	int x;
	int y;
	int points_conquetes;
	boolean conquis; //statut de l'astre déterminant si le territoire est conquis
	int proportion_conquete; //facteur proportionnel qui donne le nombre de points_conquÃªtes en fonction de sa taille
	int tour_conquete; //compteur qui marque le tour de conquÃªte d'un astre
	double taux_croissance; //taux de croissance de population
	double population;
	int population_max;
	int date;
	

	//*** CONSTRUCTEUR ***//
	public Astre(String nom, int taille, int x, int y, int proportion, double taux) {
		super(x,y,30,30); 
		this.nom = nom;
		this.taille = taille;
		this.proportion_conquete = proportion;
		this.points_conquetes = taille *proportion;
		this.conquis = false;
		this.taux_croissance = taux;
		this.population_max = 10*this.taille; //1000 arbitraire
		super.icoObj = new ImageIcon(getClass().getResource("soleil3.png")); 
		super.imgObj = this.icoObj.getImage(); 
		this.date = 0;
	}


	//*** METHODES ***//
	
	//méthode permettant d'augmenter la population d'un astre conquis
	public static void population(Astre a, Joueur j) { 
		a.population = 1;  //initialisation
		if(a.population <= a.population_max) {
			a.population = a.taille*a.taux_croissance;}
		else{
			a.population = a.population_max;}
	}
	
	//méthode incrémentant la date de conquête d'un astre
	public static void ajout_date_astre(Astre a) {
		a.date += 1;
	}
	
	public boolean isConquis() {return conquis;}
	public void setConquis(boolean conquis) {this.conquis = conquis;}
	
	//*** GETTERS ET SETTERS ***//
	public String getNom() {return nom;}
	public int getTaille() {return taille;}
	public void setNom(String nom) {this.nom = nom;}
	public int getPoints_conquetes() {return points_conquetes;}
	public void setPoints_conquetes(int points_conquetes) {this.points_conquetes = points_conquetes;}
		
}
