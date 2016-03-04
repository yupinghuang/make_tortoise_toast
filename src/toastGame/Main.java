/**
 * View.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Code altered from  https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to
 * Date: Feb 28, 2016
 * 
 * View communicates with the FXML file to set up the GUI
 */

package toastGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane page = (Pane) FXMLLoader.load(Main.class.getResource("ToastForToryMock.fxml"));
		Scene scene = new Scene(page);
		
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Toast For Tory!");
		primaryStage.show();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Application.launch(Main.class, (java.lang.String[]) null);
	}

}