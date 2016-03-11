/** 
* ViewInitializer.java 
* Authors: Yuping Huang, Tegan Wilson, and Carolyn Ryan 
* Class structure taken from https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to 
* Date: Feb 28, 2016
* ViewInitializer class helps set up the GUI (View) */
package toastGame;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

public class ViewInitializer implements Initializable {
	private static final double SCALE_FACTOR = 4.6;
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
	private Button newGameButton;
	@FXML
	private Pane toastPane;
	@FXML
	private StackPane sideButtonPane;
	@FXML
	private Slider toastinessIndicator;
	@FXML
	private ImageView toastImage;
	@FXML
	private Pane criteriaToastPane;
	@FXML
	private VBox toastRequest;
	@FXML
	private TextArea criteriaToastText;

	// Instance Variables
	private GameController myController;
	private Button[] buttonList;
	private MainInitializer parent;

	/**
	 * Sets up observer relationship with GameController. Uses GameController to
	 * define button list.
	 */
	protected void setUp() {
		myController = new GameController(this);
		buttonList = myController.createButtons(6);
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
				if (!(oldValue.intValue() == newValue.intValue())) {
					myController.toastToast(newValue.intValue());
				}
			}
		});
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
					myController.handleButtonClickEvent(j);
				}
			});
		}
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
		// When submit is pressed, calls the submit toast method
		if (event.getSource().equals(submitButton)) {
			// Code which clears the side button pane and adds Tory picture and
			// text area there
			/**
			 * sideButtonPane.getChildren().clear();
			 * 
			 * TextArea judgments = new TextArea(); judgements.setLayoutY(100);
			 * sideButtonPane.getChildren().add(judgments);
			 * 
			 * Image toryImage = new
			 * Image(getClass().getResource("images/tory.png").toExternalForm())
			 * ; ImageView toryImageView = new ImageView(toryImage);
			 * toryImageView.setPreserveRatio(true);
			 * toryImageView.setFitHeight(90);
			 * sideButtonPane.getChildren().add(toryImageView);
			 */

			myController.submitToast();
		}
		if (event.getSource().equals(newGameButton)) {
			this.resetGame();
		}
	}

	/**
	 * Takes the image to put on the toastPane, resize it to appropriate size,
	 * rotate and position it randomly on the toast
	 * 
	 * @param image
	 *            The image to be shown on top the toast image
	 */
	void addImageOnToast(Image image) {
		addImageOnPane(image, toastPane);
	}

	/**
	 * Generate an image according to the base image and the decorative images
	 * and the number of each. The decorations are on top of the base.
	 * 
	 * @param base
	 *            the image at the bottom
	 * @param decorations
	 *            a list of <Image, number> pair where number is the the number
	 *            of the certain image to add
	 */
	void createCriteriaImage(Image base, ArrayList<Pair<Image, Integer>> decorations) {
		ImageView baseview = new ImageView(base);
		baseview.setPreserveRatio(true);
		baseview.setFitHeight((criteriaToastPane.getHeight()));
		criteriaToastPane.getChildren().add(baseview);
		for (Pair<Image, Integer> imageWithNumber : decorations) {
			int amount = imageWithNumber.getValue();
			Image image = imageWithNumber.getKey();
			while (amount > 0) {
				addImageOnPane(image, criteriaToastPane);
				amount--;
			}
		}
	}

	void addCriteriaToppings(Toast toast) {
		Map<Topping, Integer> map = toast.getToppings();
		for (Map.Entry<Topping, Integer> entry : map.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				putToppingCriteria(entry);
			}
		}
	}

	private void putToppingCriteria(Map.Entry<Topping, Integer> entry) {
		ImageView imageview = new ImageView(entry.getKey().getImage());

		Random r = new Random();
		int imageViewX = (r.nextInt(80)) + 20;
		int imageViewY = (r.nextInt(80)) + 20;

		imageview.setPreserveRatio(true);
		imageview.setFitHeight(25);
		imageview.setLayoutX(imageViewX);
		imageview.setLayoutY(imageViewY);

		criteriaToastPane.getChildren().add(imageview);
	}

	void addCriteriaToast(Image image) {
		ImageView imageview = new ImageView(image);
		imageview.setFitHeight(160);
		imageview.setPreserveRatio(true);
		criteriaToastPane.getChildren().add(imageview);
	}

	/**
	 * Helper function to add an image onto a pane. Usually used to add topping
	 * onto an existing toast
	 * 
	 * @param image
	 * @param pane
	 */
	private void addImageOnPane(Image image, Pane pane) {
		ImageView imageview = new ImageView(image);
		double paneHeight = pane.getHeight();
		double paneWidth = pane.getWidth();

		Random r = new Random();
		int imageViewX = (r.nextInt((int) paneHeight));
		int imageViewY = (r.nextInt((int) paneWidth));

		imageview.setPreserveRatio(true);
		imageview.setFitHeight(paneHeight / SCALE_FACTOR);

		imageview.setLayoutX(imageViewX);
		imageview.setLayoutY(imageViewY);
		pane.getChildren().add(imageview);
	}

	/**
	 * Post request text to the request vbox on the view In the toastGame case
	 * it is the order
	 * 
	 * @param requests
	 *            as a two-column array, the first the name and the second the
	 *            description(e.g. amount)
	 */
	void createTextRequest(String[][] requests) {

	}

	void addCriteria(String criteria) {
		criteriaToastText.setText(criteria);
	}

	void changeToastiness(Image toast) {
		toastImage.setImage(toast);
		toastImage.getImage();
	}

	void resetGame() {
		criteriaToastPane.getChildren().clear();
		toastPane.getChildren().clear();
		toastinessIndicator.setValue(0);
		this.initialize(null, null);
	}

	void setParentController(MainInitializer mainInit) {
		this.parent = mainInit;
	}
}