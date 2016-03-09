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
	private static final String MAINSTRING = "javafx.event.ActionEvent[source=Button@55b9e92a[styleClass=button]'MAIN']";

	@FXML
	private Button play;
	@FXML
	private Button howTo;
	
	Stage myStage;
	Pane page;
	Scene scene;

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		myStage = new Stage();
		myStage.setResizable(false);
		page = new Pane();
		scene = new Scene(page);

		//playStage = new Stage();
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
		String eventString = event.getSource().toString();
				
		if (event.getSource().equals(play)) {
			openPlay();
		}
		if (event.getSource().equals(howTo)) {
			openHowTo();
		}
		if (eventString.substring(eventString.length()-6).equals("'MAIN'")) {
			System.out.println("Main pressed!");
			// TODO Figure out how to get the howToStage to close when user clicks button!
			System.out.println(myStage);
			myStage.close();
		}
	}
	
	private void openPlay() throws IOException {
		page = (Pane) FXMLLoader.load(Main.class.getResource("ToastForToryPlay.fxml"));
		scene = new Scene(page);
		
		myStage.setScene(scene);
		myStage.setTitle("Play Toast For Tory!");
		myStage.show();
	}
	
	private void openHowTo() throws IOException {
		page = (Pane) FXMLLoader.load(Main.class.getResource("HowToTory.fxml"));
		
		scene = new Scene(page);
		myStage.setScene(scene);
		myStage.setTitle("How To Play");
		myStage.show();
	}
}
