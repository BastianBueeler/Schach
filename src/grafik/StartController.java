package grafik;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logik.Spiel;

public class StartController {

	Spiel game = new Spiel();
	MainController MC = new MainController();
	
	@FXML
	private Button GO;
	
	@FXML
	private TextField Player1;
	
	@FXML
	private TextField Player2;
	
	@FXML
	public void nextSite(ActionEvent event) {
		MC.setGame(game);
		Stage stage;
		Parent root = null;


		stage = (Stage) GO.getScene().getWindow();

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/grafik/Main.fxml"));
			loader.setController(MC);
			root = loader.load();


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
