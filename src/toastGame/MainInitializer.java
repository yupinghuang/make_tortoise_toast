/**
 * MainInitializer.java
 * 
 * @author Tegan Wilson, Yupung Huang, & Carolyn Ryan
 * Date: 3/13/16
 * 
 * Class structure taken from https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to 
 * Initializes the GUI elements for the opening page 
 * 
 */
package toastGame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainInitializer implements Initializable {
	// FXML Variable Injections
	@FXML
	private Button play;
	@FXML
	private Button howTo;

	// Instance Variables
	Stage mainStage;
	Stage howToStage;
	Pane mainPage;
	Scene mainScene;
	Scene howToScene;

	/**
	 * Initialize method to instantiate instance variables
	 * 
	 * @param location
	 *            URL location
	 * @param resouces
	 *            the resource bundle available
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainStage = new Stage();
		mainStage.setResizable(false);

		howToStage = new Stage();
		mainPage = new Pane();
		mainScene = new Scene(mainPage);
	}

	/**
	 * Handles button action for play and howTo buttons
	 * 
	 * @param event
	 *            The event that needs to be handled
	 * @throws IOException
	 *             fxml file not found for play or how to
	 */
	@FXML
	protected void handleButtonAction(ActionEvent event) throws IOException {
		if (event.getSource().equals(play)) {
			openPlay();
		}
		if (event.getSource().equals(howTo)) {
			openHowTo();
		}
	}

	/**
	 * Launches fxml file for play window
	 * 
	 * @throws IOException
	 *             fxml file not found
	 */
	void openPlay() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ToastForToryPlay.fxml"));
		Parent root = (Parent) fxmlLoader.load();

		mainScene = new Scene(root);
		mainStage.setScene(mainScene);
		mainStage.setTitle("Play Toast For Tory!");
		mainStage.show();
	}

	/**
	 * Launches the how to fxml window
	 * 
	 * @throws IOException
	 *             fxml file not found
	 */
	private void openHowTo() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HowToTory.fxml"));
		Parent root = (Parent) fxmlLoader.load();

		HowToInitializer howToInit = (HowToInitializer) fxmlLoader.getController();
		howToInit.setParentController(this);

		mainScene = new Scene(root);
		howToStage = new Stage();
		howToStage.setScene(mainScene);
		howToStage.show();
	}
}
