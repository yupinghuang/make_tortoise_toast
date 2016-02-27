package toastGame;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ViewController implements Initializable {
	@FXML
	private Button firstButton;
	@FXML
	protected void handleButtonAction(ActionEvent event) {
		System.out.println("firstButton pressed!");
	}
	
	@Override // This method is called by the FXMLLoader when initialization is
				// complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert firstButton != null : "fx:id=\"firstButton\" was not injected: check your FXML file 'simple.fxml'.";

		// initialize your logic here: all @FXML variables will have been
		// injected


	}
}
