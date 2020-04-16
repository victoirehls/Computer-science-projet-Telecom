package Space_game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class interf_graphique extends Application {  
	public static void main(String[] args) {
		launch(args); //permet de démarrer une appli avec une unique fenêtre 
	}
	public void start(Stage stage) {
		
		int width = 1280 ; 
		int height = 830;

		stage.setTitle("The Space Game");
		stage.setResizable(false); //empêcher à l'util de redimensionner la fenêtre

		Group root = new Group();
		Scene scene = new Scene(root);
		Canvas canvas = new Canvas(width, height);
		root.getChildren().add(canvas);
					
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setFont(Font.font("Helvetica", FontWeight.BOLD, 18)); //réglages police et couleur
	    gc.setFill(Color.BISQUE);
	    gc.setStroke(Color.RED);
	    gc.setLineWidth(1);
	    
	    //AFFICHAGE DU FOND
	    Image backspace = new Image("Fond_espace2.jpg", 1280, 960, false,false); 
	    gc.drawImage(backspace,0,0);
	    
	    //LES SCORES
	    gc.setFont(Font.font("Helvetica", FontWeight.BOLD, 18)); //réglages police et couleur
	    gc.setFill(Color.BISQUE);
	    gc.setStroke(Color.RED);
	    gc.setLineWidth(1);
	    String txt1 = "Territoire conquis = " + 1 + "%";
	    String txt2 = "Territoire conquis = " + 1 + "%";
	    String joueur1 = "Joueur 1";
	    String joueur2 = "Joueur 2";
	    String pt1 = "Points conquêtes = " + 10;
	    String pt2 = "Points conquêtes = " + 10;
	    gc.fillText(txt1, 10, 60);
	    gc.fillText(txt2, 1075, 60);
	    gc.fillText(joueur1, 10, 36);
	    gc.fillText(joueur2, 1075, 36);
	    gc.fillText(pt1, 10, 85);
	    gc.fillText(pt2, 1075, 85);
	    gc.strokeText(txt1, 10, 60 ); //entourage du texte
	    gc.strokeText(txt2, 1075, 60);
	    
	    gc.setFont(Font.font("Helvetica", FontWeight.BOLD, 34)); //réglages police et couleur
	    gc.setFill(Color.BISQUE);
	    gc.setStroke(Color.RED);
	    gc.setLineWidth(1);
	    String tour = "Tour " + 1;
	    gc.fillText(tour, width/2, 29);
	    
	    
	    // A FAIRE ENCORE: les deux interfaces joueurs, le tour joué, les onglets
	    
	    
	    stage.setScene(scene); //associer la scène à la fenêtre créée
		stage.show();  //associer une scène à la fenêtre 
		               //et des éléments à la scène avant d'afficher la fenêtre
		               //stage.show doit toujours rester la dernière action
	}
	
}

