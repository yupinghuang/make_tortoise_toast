package toastGame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class HowToInitializer implements Initializable {

	@FXML
	private Button main;

	@FXML
	private Button play;
	
	private MainInitializer parent;
	
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
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
	
	void closeWindow() {
		parent.howToStage.close();
	}
	
	void setParentController(MainInitializer mainInit){
		this.parent = mainInit;
	}

}
