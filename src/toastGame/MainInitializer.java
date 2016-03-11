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

	@FXML
	private Button play;
	@FXML
	private Button howTo;

	Stage myStage;
	Stage howToStage;
	Pane page;
	Scene scene;
	Scene howToScene;

	/**
	 * override initialize method that acts as faux constructor
	 * 
	 * @param location
	 *            URL location
	 * @param resouces
	 *            the resource bundle available
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		myStage = new Stage();
		howToStage = new Stage();

		myStage.setResizable(false);
		page = new Pane();
		scene = new Scene(page);
	}

	/**
	 * Handles button action
	 * 
	 * @param event
	 *            The event that needs to be handled
	 * @throws IOException
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
	 * Launches fxml file for the main play page
	 * 
	 * @throws IOException
	 *             fxml file not found
	 */
	void openPlay() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ToastForToryPlay.fxml"));
		Parent root = (Parent) fxmlLoader.load();

		ViewInitializer viewInit = (ViewInitializer) fxmlLoader.getController();
		viewInit.setParentController(this);

		scene = new Scene(root);
		myStage.setScene(scene);
		myStage.setTitle("Play Toast For Tory!");
		myStage.show();

	}

	/**
	 * Launches the how to fxml page
	 * 
	 * @throws IOException
	 *             fxml file not found
	 */
	private void openHowTo() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HowToTory.fxml"));
		Parent root = (Parent) fxmlLoader.load();

		howToInit howToInit = (howToInit) fxmlLoader.getController();
		howToInit.setParentController(this);

		scene = new Scene(root);
		howToStage = new Stage();
		howToStage.setScene(scene);
		howToStage.show();
	}
}
