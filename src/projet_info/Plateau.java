package projet_info;


public class Plateau {
	int      lignes;   
	int      colonnes; 
	Case[][] grille;  
		  
	Plateau(int lignes, int colonnes) {    
	this.lignes = lignes;                
	this.colonnes = colonnes;           
	grille = new Case[lignes][colonnes]; 

		    
	for(int i=0; i<lignes; i++)
		for(int j=0; j<colonnes; j++)
		    grille[i][j] = new Case();      
	}
}


