package grafik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StartApplication extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.getIcons().add(new Image("grafik/logo.png"));
		stage.setTitle("Schachsoftware");

		Parent root = FXMLLoader.load(getClass().getResource("StartFXML.fxml"));

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
