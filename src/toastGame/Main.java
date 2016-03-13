/**
 * OpeningMain.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Code altered from  https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to
 * Date: Feb 28, 2016
 * 
 * Main communicates with the FXML file to set up the GUI
 */

package toastGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	/**
	 * Start method override to set the stage with the fxml file
	 * 
	 * @param primaryStage
	 *            The stage to set up at the beginning
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane page = (Pane) FXMLLoader.load(Main.class.getResource("ToastForToryOpening.fxml"));
		Scene scene = new Scene(page);

		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Toast For Tory!");
		primaryStage.show();
	}

	/**
	 * @param args
	 *            The command line arguments
	 */
	public static void main(String[] args) {
		Application.launch(Main.class, (java.lang.String[]) null);
	}

}