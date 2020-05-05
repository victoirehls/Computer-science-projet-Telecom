package projet_info;


public class Astre extends Unite {
// DEFINITION DES CHAMPS
	String nom; 
	int taille;
	int coordX;
	int coordY;
	int points_conquetes;
	boolean conquis; //statut de l'astre dÃ©terminant si le territoire est conquis
	int proportion_conquete; //facteur proportionnel qui donne le nombre de points_conquÃªtes en fonction de sa taille
	int tour_conquete; //compteur qui marque le tour de conquÃªte d'un astre
	double taux_croissance; //taux de croissance de population
	double population;
	int population_max;

//CONSTRUCTEUR
	public Astre(String nom, int taille, int x, int y, int proportion, double taux) {
		this.nom = nom;
		this.taille = taille;
		this.coordX = x;
		this.coordY = y;
		this.proportion_conquete = proportion;
		this.points_conquetes = taille *proportion;
		this.conquis = false;
		this.taux_croissance = taux;
		this.population_max = 1000*this.taille; //1000 arbitraire
	}
	
//METHODES
	
	
	public void population(Astre a, Joueur j) { //appelÃ©e quand un joueur conquiert un astre
		a.population = 1;  //initialisation
		if(a.population <= a.population_max) {
			a.population = j.tour*a.taille*a.taux_croissance;
		}
		else{
			a.population = a.population_max;}
		}
	
	public String[] displayastre(Astre a ){
		String tab[] = new String[7];
		tab[0] = "nom : " + a.nom;
		tab[1] = " taille : " + String.valueOf(a.taille);
		tab[2] = "population : " + String.valueOf(a.population);
		tab[3] = "population max : " + String.valueOf(a.population_max);
		tab[4] = "coordX : " + String.valueOf(a.coordX);
		tab[5] = "coordY : " + String.valueOf(a.coordY);
		tab[6] = "point conquetes : " + String.valueOf(a.points_conquetes);
		return tab;
}
}
