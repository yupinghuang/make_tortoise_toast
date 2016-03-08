package toastGame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainInitializer implements Initializable {
	@FXML
	private Button play;
	@FXML
	private Button howTo;
	
	Stage howToStage;
	Stage playStage;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		howToStage = new Stage();
		playStage = new Stage();
	}
	
	/**
	 * Handles button action for submit button. The submit button is implemented
	 * in the .fxml file. As such, it can't be handled in the same method as the
	 * other buttons.
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

	private void openPlay() throws IOException {
		Pane page;
		page = (Pane) FXMLLoader.load(Main.class.getResource("ToastForToryPlay.fxml"));

		Scene scene = new Scene(page);

		playStage.setResizable(false);
		playStage.setScene(scene);
		playStage.setTitle("Toast For Tory!");
		playStage.show();
	}
	
	private void openHowTo() throws IOException {
		Pane page;
		page = (Pane) FXMLLoader.load(Main.class.getResource("HowToTory.fxml"));

		Scene scene = new Scene(page);

		howToStage.setResizable(false);
		howToStage.setScene(scene);
		howToStage.setTitle("Toast For Tory!");
		howToStage.show();
	}
}
