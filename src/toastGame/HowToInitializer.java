package toastGame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class HowToInitializer implements Initializable {
	// FXML Variable Injections
	@FXML
	private Button main;
	@FXML
	private Button play;

	// Instance Variables
	private MainInitializer parent;

	/**
	 * Initialize method as implements initializable
	 * 
	 * @param location
	 *            URL location of file
	 * @param resources
	 *            ResourceBundle to be used
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
		if (event.getSource().equals(main)) {
			closeWindow();
		}
	}

	/**
	 * Launches fxml file for the main play page
	 * 
	 * @throws IOException
	 *             fxml file not found
	 */
	void openPlay() throws IOException {
		parent.openPlay();
		closeWindow();
	}

	/**
	 * Close howTo window using parent
	 */
	void closeWindow() {
		parent.howToStage.close();
	}

	/**
	 * Sets parent
	 * 
	 * @param mainInit
	 *            Parent initializer
	 */
	void setParentInitializer(MainInitializer mainInit) {
		this.parent = mainInit;
	}

}
