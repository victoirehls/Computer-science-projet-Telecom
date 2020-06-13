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
	
	

	//*** CONSTRUCTEUR ***//
	public Astre(String nom, int taille, int x, int y, int proportion, double taux) {
		super(x,y,30,30); 
		this.nom = nom;
		this.taille = taille;
		this.proportion_conquete = proportion;
		this.points_conquetes = taille *proportion;
		this.conquis = false;
		this.taux_croissance = taux;
		this.population_max = 1000*this.taille; //1000 arbitraire
		super.icoObj = new ImageIcon(getClass().getResource("soleil3.png")); 
		super.imgObj = this.icoObj.getImage(); 
	}


	//*** METHODES ***//
	
	public void population(Astre a, Joueur j) { //appelÃ©e quand un joueur conquiert un astre
		a.population = 1;  //initialisation
		if(a.population <= a.population_max) {
			a.population = j.tour*a.taille*a.taux_croissance;}
		else{
			a.population = a.population_max;}
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
