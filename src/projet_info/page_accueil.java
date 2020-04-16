package projet_info;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;

public class page_accueil extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage stage) {
		 stage.setTitle("Page_acceuil");

		 GridPane grid = new GridPane();
		 grid.setAlignment(Pos.CENTER);
		 grid.setHgap(10);
		 grid.setVgap(10);
		 grid.setPadding(new Insets(25, 25, 25, 25));
		 grid.setStyle("-fx-background-image: url(uss-enterprise-400x300.jpg)");
		
		 Scene scene = new Scene(grid, 300, 275);
		 Text scenetitle = new Text("Space Odyssey LogIn Page");
		 scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		 scenetitle.setFill(Color.AZURE);
		 grid.add(scenetitle, 0, 0, 2, 1);
		 
		 Label user1 = new Label("User 1 Name:");
		 user1.setTextFill(Color.AZURE);
		 grid.add(user1, 0, 1);
		 TextField userTextField1 = new TextField();
		 grid.add(userTextField1, 1, 1);
		 
		 Label user2 = new Label("User 2 Name:");
		 user2.setTextFill(Color.AZURE);
		 grid.add(user2, 0, 2);
		 TextField userTextField2 = new TextField();
		 grid.add(userTextField2, 1, 2);
		 
		 Button btn = new Button("Sign in");
		 HBox hbBtn = new HBox(10);
		 hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		 hbBtn.getChildren().add(btn);
		 grid.add(hbBtn, 1, 4);
		 
		 final Text actiontarget = new Text();
		 grid.add(actiontarget, 1, 6);
		 btn.setOnAction(new EventHandler<ActionEvent>() {
			 public void handle(ActionEvent e) {
			 actiontarget.setFill(Color.FIREBRICK);
			 actiontarget.setText("Sign in button pressed");
			 }
			});
		 stage.setScene(scene);
		 stage.show();
		 }
}
