package projet_info;

public class Astre extends Unite {
	String nom; //permet d'identifier l'astre
	int taille;
	int coordX;
	int coordY;
	int points_conquetes_necessaires;
	boolean statut;
	
	public Astre(String nom, int taille, int x, int y) {
		this.nom=nom;
		this.taille=taille;
		this.coordX=x;
		this.coordY=y;
		this.points_conquetes_necessaires=taille*2; // 2 = valeur arbitraire
	}

}

