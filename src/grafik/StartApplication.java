package grafik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @author Bastian Bueeler
 * @version 1.0
 */

public class StartApplication extends Application {

	/**
	 *
	 * @param stage Neue Stage wird gemacht
	 * @throws Exception
	 */
	@Override
	public void start(Stage stage) throws Exception {
		stage.getIcons().add(new Image("Pictures/logo.png"));
		stage.setTitle("Schachsoftware");

		Parent root = FXMLLoader.load(getClass().getResource("StartView.fxml"));

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
