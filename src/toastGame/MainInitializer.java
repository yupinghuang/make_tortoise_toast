package toastGame;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MainInitializer implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	private Button dif1;
	@FXML
	private Button dif2;
	@FXML
	private Button dif3;
	@FXML
	private Button instructions;
	
	/**
	 * Handles button action for submit button. The submit button is implemented
	 * in the .fxml file. As such, it can't be handled in the same method as the
	 * other buttons.
	 * 
	 * @param event
	 *            The event that needs to be handled
	 */
	@FXML
	protected void handleButtonAction(ActionEvent event) {
		System.out.println("Button Pressed!");
		// When submit is pressed, calls the submit toast method
		if (event.getSource().equals(dif1)) {

		}
	}

}
