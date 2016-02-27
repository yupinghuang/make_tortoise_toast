package toastGame;
//https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class View extends Application {

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//ViewController controller = new ViewController();
		Pane page = (Pane) FXMLLoader.load(View.class.getResource("ToastForToryMock.fxml"));
		Scene scene = new Scene(page);

		primaryStage.setScene(scene);
		primaryStage.setTitle("FXML is Simple");
		primaryStage.show();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Application.launch(View.class, (java.lang.String[]) null);
	}

}