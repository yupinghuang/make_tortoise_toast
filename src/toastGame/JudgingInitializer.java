package toastGame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JudgingInitializer implements Initializable {

	@FXML
	private Button play;
	
	@FXML
	private Text speechBubble;
	
	private ViewInitializer parent;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
			//openPlay();
		}
	}
	public void setParentController(ViewInitializer viewInitializer) {
		this.parent = viewInitializer;
	}
	public void setText(String toryOpinion) {
		speechBubble.setText(toryOpinion);
	}
	
	
}