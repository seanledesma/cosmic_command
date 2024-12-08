package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
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
        Parent gameRoot = FXMLLoader.load(getClass().getResource("/application/GameScene.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene gameScene = new Scene(gameRoot);
        stage.setScene(gameScene);
        stage.show();
    }
}