package grafik;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logik.Spiel;
import logik.internal.chessmen.ISpielfigur;

public class StartController {

	Spiel game = new Spiel();
	MainController MC = new MainController(game);
	
	@FXML
	private Button GO;
	
	@FXML
	private TextField Player1;
	
	@FXML
	private TextField Player2;
	
	@FXML
	public void nextSite(ActionEvent event) {

		Stage stage;
		Parent root = null;

		stage = (Stage) GO.getScene().getWindow();
		try {
			root = FXMLLoader.load(getClass().getResource("/grafik/MainFXML.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		createGame();
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void createGame(){
		game.createSpieler(Player1.getText());
		game.createSpieler(Player2.getText());
		game.createSpielfiguren();

		MC.createFXMLField();
		MC.createField();
		}

	
}
