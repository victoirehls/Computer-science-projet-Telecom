package projet_info;

public class Personnage extends Unite {
	String nom;
	int points_conquetes;
	double experience; //en pourcentage
	int niveau; // entier compris entre 1 et 3
	char[] territoires;// on mettra un tableau extensible par la suite
	
	public Personnage(String nom) {
		this.nom=nom;
		this.points_conquetes=0; //on initialise tout à 0 pour l'instant
		this.niveau=0;
		this.experience=0;
	 
	}

}
