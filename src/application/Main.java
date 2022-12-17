package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * This class sets up the Java FX GUI, setting the title and window size.
 * It links to 'MainScene.fxml', which then calls the MainSceneController class.
 * 
 * @author Sean Ledesma
 * @author Braden Tolman
 *
 */
public class Main extends Application{
	
	private static Stage stg;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stg = primaryStage;
			primaryStage.setResizable(false);
			Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
			
			primaryStage.setTitle("Cosmic Command");	
			
			primaryStage.setScene(new Scene(root, 1350, 900));
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String fxml) throws IOException{
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
