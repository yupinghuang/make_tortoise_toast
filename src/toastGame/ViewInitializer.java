/** 
* ViewInitializer.java 
* Authors: Yuping Huang, Tegan Wilson, and Carolyn Ryan 
* Class structure taken from https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to 
* Date: Feb 28, 2016
* ViewInitializer class helps set up the GUI (View) */
package toastGame;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class ViewInitializer implements Initializable {
	// Constant variables
	private static final int BUTTON_Y_MULTIPLIER = 56;
	private static final int BUTTON_X_LAYOUT = 25;
	private static final int BUTTONSIZE_Y = 45;
	private static final int BUTTONSIZE_X = 134;

	// FXML Variable Injections
	@FXML
	private Pane buttonPane;
	@FXML
	private Button submitButton;
	@FXML
	private Pane toastPane;
	@FXML
	private StackPane sideButtonPane;
	@FXML
	private Slider toastinessIndicator;

	// Instance Variables
	private GameController myController;
	private Button[] buttonList;

	/**
	 * Sets up observer relationship with GameController. Uses GameController to
	 * define button list.
	 */
	protected void setUp() {
		myController = new GameController(this);
		buttonList = myController.createButtons(6);
	}

	/**
	 * Arranges Buttons in a pane. This stack pane is placed on the right side
	 * of the window.
	 */
	@FXML
	protected void setButtons() {
		// Add buttons in list to the pane
		buttonPane = new Pane();
		for (int i = 0; i < buttonList.length; i++) {
			// styles the buttons just before they are added to buttonPane
			buttonList[i].setStyle("-fx-font: 13 chalkduster; -fx-background-color: #5B4118; -fx-text-fill: WHITE;");
			buttonPane.getChildren().add(buttonList[i]);
		}
		// Add the button pane to the side pane
		sideButtonPane.getChildren().add(buttonPane);
	}

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
		if (event.getSource().equals(submitButton)) {
			myController.submitToast();
		}
	}

	/**
	 * Handles button action. Calls to the GameController to handle the button
	 * press.
	 */
	public void handleButtons() {
		// Associate actions with each button
		for (int i = 0; i < buttonList.length; i++) {
			// Associate actions with each button
			int j = i;
			buttonList[i].setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.out.println("Button pressed!");
					myController.handleButtonClickEvent(j);
				}
			});
		}
	}

	/**
	 * Called as a constructor, initializes all GUI elements of the java GUI.
	 * 
	 * @param fxmlFileLocation
	 *            The location of the fxml file to be used as a base GUI.
	 * @param resources
	 *            The bundle of resources to be used in additional GUI
	 *            development.
	 */
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		this.setUp();
		for (int i = 0; i < buttonList.length; i++) {
			buttonList[i].setPrefSize(BUTTONSIZE_X, BUTTONSIZE_Y);
			buttonList[i].setLayoutX(BUTTON_X_LAYOUT);
			buttonList[i].setLayoutY(BUTTON_Y_MULTIPLIER * i + BUTTON_X_LAYOUT);
		}
		this.setButtons();
		this.handleButtons();

		// Listen for Slider value changes
		toastinessIndicator.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(("Slider Value Changed newValue: " + newValue.intValue()));
				/*
				myController.handleSliderEvent(newValue.intValue());
				public void handleSliderEvent(int SliderValue) {
					view.changeToastinessLevel(SliderValue);
				} */
			}
		});

	}
	
	/**
	 * Takes the image to put on the toastStackPane, resize it to appropriate
	 * size, rotate and position it randomly on the toast
	 * 
	 * @param image
	 *            The image to be shown on top the toast image
	 */
	void addImageOnToast(Image image) {
		ImageView imageview = new ImageView(image);
		double paneHeight = toastPane.getHeight();
		double paneWidth = toastPane.getWidth();

		Random r = new Random();
		int imageViewX = (r.nextInt((int) paneHeight));
		int imageViewY = (r.nextInt((int) paneWidth));

		imageview.setPreserveRatio(true);
		imageview.setFitHeight(paneHeight / 5.0);

		imageview.setLayoutX(imageViewX);
		imageview.setLayoutY(imageViewY - 35);
		toastPane.getChildren().add(imageview);
	}
}