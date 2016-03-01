/** * ViewInitializer.java * Authors: Yuping Huang, Tegan Wilson, and Carolyn Ryan * Class structure taken from https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to * Date: Feb 28, 2016 * * ViewInitializer class helps set up the GUI (View) */
package toastGame;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ViewInitializer implements Initializable {
	// Constant variables
	private static final int BUTTON_Y_MULTIPLIER = 56;
	private static final int BUTTON_X_LAYOUT = 25;
	private static final int BUTTONSIZE_Y = 45;
	private static final int BUTTONSIZE_X = 134;
	private static final String SUBMIT = "javafx.event.ActionEvent[source=Button[id=submitButton, styleClass=button]'SUBMIT']";

	// FXML Variable Injections
	@FXML
	private Pane buttonPane;
	@FXML
	private Button submitButton;
	@FXML
	private StackPane toastStackPane;
	@FXML
	private StackPane sideButtonPane;

	// Instance Variables
	private GameController myController;
	private Button[] buttonList;

	// Used later as an example of how to add to a stackpane
	private Rectangle exampleRectangle;

	/**
	 * Defines instance variables and creates topping buttons.
	 */
	protected void setUp() {

		myController = new GameController();
		myController.registerView(this);
		buttonList = myController.createButtons(6);

		exampleRectangle = new Rectangle();
		exampleRectangle.setX(50);
		exampleRectangle.setY(50);
		exampleRectangle.setWidth(200);
		exampleRectangle.setHeight(100);
	}

	/**
	 * Arranges Buttons in a stack pane. This stack pane is placed on the
	 */
	@FXML
	protected void setButtons() {
		// Add buttons in list to the pane
		buttonPane = new Pane();
		for (int i = 0; i < buttonList.length; i++) {
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
		if (event.toString().equals(SUBMIT)) {
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
					System.out.println("Button pressed");
					// toastStackPane.getChildren().add(exampleRectangle);
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
	}

	/**
	 * Takes the image to put on the toastStackPane, resize it to appropriate
	 * size, rotate and position it randomly on the toast
	 * 
	 * @param image
	 */
	void addImageOnToast(Image image) {
		ImageView imageview = new ImageView(image);
		double stackPaneHeight = toastStackPane.getHeight();
		double stackPaneWidth = toastStackPane.getWidth();
		Random r = new Random();
		double imageviewX = (r.nextDouble() - 0.5) * stackPaneWidth;
		double imageviewY = (r.nextDouble() - 0.5) * stackPaneHeight;
		imageview.setPreserveRatio(true);
		imageview.setFitHeight(stackPaneHeight / 10.0);
		System.out.println(imageviewX);
		imageview.setLayoutX(300);
		imageview.setLayoutY(300);
		toastStackPane.getChildren().add(imageview);
	}
}
