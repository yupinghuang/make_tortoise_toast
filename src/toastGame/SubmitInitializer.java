/**
 * SubmitInitializer.java
 * 
 * @author Tegan Wilson, Yupung Huang, & Carolyn Ryan
 * Date: 3/13/16
 * 
 * Class structure taken from https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to 
 * Initializes the GUI elements for the Judging Panel where Tory gives feedback to the user
 * New window opens when user clicks submit
 * 
 */
package toastGame;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SubmitInitializer implements Initializable {

	// FXML Variable Injections
	@FXML
	private Button newGame;
	@FXML
	private Text speechBubble;

	// Instance Variables
	private PlayInitializer parent;
	private Stage stage;

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
	 * Handles button action for newGame.
	 * 
	 * @param event
	 *            The event that needs to be handled
	 */
	@FXML
	protected void handleButtonAction(ActionEvent event) {
		// New Game button calls to new game functions and closes the stage it
		// works on
		if (event.getSource().equals(newGame)) {
			parent.resetGame();
			stage.close();
		}
	}

	/**
	 * Sets parent initializer to interact with parent for new game
	 * 
	 * @param viewInitializer
	 */
	public void setParentInitializer(PlayInitializer viewInitializer) {
		this.parent = viewInitializer;
	}

	/**
	 * Obtain stage to be able to close its own stage
	 * 
	 * @param stage
	 */
	public void setThisStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Set Tory's feedback text to toryOpinion
	 * 
	 * @param toryOpinion
	 */
	public void setText(String toryOpinion) {
		speechBubble.setText(toryOpinion);
	}
}
