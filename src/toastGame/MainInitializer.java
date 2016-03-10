package toastGame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainInitializer implements Initializable {

	@FXML
	private Button play;
	@FXML
	private Button howTo;
	@FXML
	private Button newGameButton;

	Stage myStage;
	Stage howToStage;
	Pane page;
	Scene scene;

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
		if (event.getSource().equals(newGameButton)) {
			openPlay();
		}
		if (eventString.substring(eventString.length() - 6).equals("'MAIN'")) {
			System.out.println("Main pressed!");
			// TODO Figure out how to get the howToStage to close when user
			// clicks button!
			System.out.println(myStage.onCloseRequestProperty());
			System.out.println(myStage.getScene()); // HERE IS THE ISSUE.
			// The stage resets every button press
			// The scene is null so the scene is never open
			myStage.close();
		}
	}

	/**
	 * Launches fxml file for the main play page
	 * 
	 * @throws IOException
	 *             fxml file not found
	 */
	void openPlay() throws IOException {
		page = (Pane) FXMLLoader.load(Main.class.getResource("ToastForToryPlay.fxml"));
		scene = new Scene(page);

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
		Parent page;
		page = FXMLLoader.load(Main.class.getResource("HowToTory.fxml"));

		scene = new Scene(page);
		myStage.setScene(scene);
		myStage.setTitle("How To Play");
		myStage.show();

		/*
		 * Here is some code that another group used to close thier pop up
		 * windows Check it out and see if you can figure this out because i
		 * still can't
		 * 
		 * Parent root;
		 * 
		 * FXMLLoader fxmlLoader = new FXMLLoader();
		 * 
		 * root =
		 * fxmlLoader.load(getClass().getResource("HowToTory.fxml").openStream()
		 * ); // TODO determine if it is popupController or expense
		 * HowToInitializer howToInitializer = (HowToInitializer)
		 * fxmlLoader.getController();
		 * howToInitializer.setParentController(this);
		 * 
		 * howToStage.setScene(new Scene(root)); howToStage.setTitle(
		 * "How To Play"); howToStage.initModality(Modality.APPLICATION_MODAL);
		 * howToStage.initOwner(myStage);
		 * howToStage.initOwner(howTo.getScene().getWindow());
		 * howToStage.showAndWait();
		 */
	}
}
