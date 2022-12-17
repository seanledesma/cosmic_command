package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
/**
 * The MainSceneController is the controller class for MainScene.fxml.
 * The primary purpose for this class is to change scenes when the 
 * user clicks the 'NewGame' Button.
 * 
 * @author Sean Ledesma
 * @author Braden Tolman
 *
 */
public class MainSceneController {
	
    @FXML
    private Button NewGame;
    
    @FXML
    public void newGame(ActionEvent event) throws IOException {
    	Main m = new Main();
    	
    	m.changeScene("GameScene.fxml");
    }
    
}