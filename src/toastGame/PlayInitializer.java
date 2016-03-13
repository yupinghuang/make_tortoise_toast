/**
 * ViewInitializer.java
 * 
 * @author Tegan Wilson, Yupung Huang, & Carolyn Ryan
 * Date: 2/28/16
 * 
 * Class structure taken from https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to 
 * ViewInitializer sets up GUI elements for play page
 * 
 */

package toastGame;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayInitializer implements Initializable {
	// Constant Variables
	private static final int CRITERIA_TOPPING_HEIGHT = 25;
	private static final int CRITERIA_TOPPING_PLACEMENT = 20;
	private static final int RANDOM_CRITERIA_TOPPING_PLACEMENT = 80;
	private static final double SCALE_FACTOR = 4.6;
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
		myController = new GameController(this);

		// Create and handle buttons
		this.createToppingButtons();
		this.handleToppingButtons();

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
	 * Creates the buttonList from myController Sets button sizes and calls
	 * setButtonsInPane
	 */
	private void createToppingButtons() {
		buttonList = myController.createButtons(6);
		for (int i = 0; i < buttonList.length; i++) {
			buttonList[i].setPrefSize(BUTTONSIZE_X, BUTTONSIZE_Y);
			buttonList[i].setLayoutX(BUTTON_X_LAYOUT);
			buttonList[i].setLayoutY(BUTTON_Y_MULTIPLIER * i + BUTTON_X_LAYOUT);
		}
		this.setButtonsInPane();
	}

	/**
	 * Arranges Buttons in a pane. This stack pane is placed on the right side
	 * of the window.
	 */
	@FXML
	private void setButtonsInPane() {
		buttonPane = new Pane();
		for (int i = 0; i < buttonList.length; i++) {
			// styles the buttons just before they are added to buttonPane
			buttonList[i].getStylesheets().add((getClass().getResource("style.css").toExternalForm()));
			buttonPane.getChildren().add(buttonList[i]);
		}
		sideButtonPane.getChildren().add(buttonPane);
	}

	/**
	 * Handles button action. Calls to the GameController to handle the button
	 * clicks.
	 */
	void handleToppingButtons() {
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
	 * Handles button action for submit and new game button. These buttons are
	 * implemented in the .fxml file. As such, it can't be handled in the same
	 * method as the topping buttons.
	 * 
	 * @param event
	 *            The event that needs to be handled
	 */
	@FXML
	protected void handleButtonAction(ActionEvent event) {
		// When submit is pressed, calls the submit toast method
		if (event.getSource().equals(submitButton)) {
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
		ImageView imageview = new ImageView(image);
		double paneHeight = toastPane.getHeight();
		double paneWidth = toastPane.getWidth();

		Random r = new Random();
		int imageViewX = (r.nextInt((int) paneHeight));
		int imageViewY = (r.nextInt((int) paneWidth));

		imageview.setPreserveRatio(true);
		imageview.setFitHeight(paneHeight / SCALE_FACTOR);

		imageview.setLayoutX(imageViewX);
		imageview.setLayoutY(imageViewY);
		toastPane.getChildren().add(imageview);
	}

	/**
	 * Adds criteria toast image to criteriaToastPane
	 * 
	 * @param image
	 *            Toast image of criteria toast's toastiness
	 */
	void addCriteriaToast(Image image) {
		ImageView imageview = new ImageView(image);
		imageview.setFitHeight(160);
		imageview.setPreserveRatio(true);
		criteriaToastPane.getChildren().add(imageview);
	}

	/**
	 * Loops through getToppings map to add toppings to the criteria toast pane
	 * 
	 * @param toast
	 *            Criteria toast
	 */
	void addCriteriaToppings(Toast toast) {
		Map<Topping, Integer> map = toast.getToppings();
		for (Map.Entry<Topping, Integer> entry : map.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				putToppingCriteria(entry.getKey().getImage());
			}
		}
	}

	/**
	 * Takes an image and adds it to the criteria toast
	 * 
	 * @param toppingImage
	 *            Image corresponding to topping to be added
	 */
	private void putToppingCriteria(Image toppingImage) {
		ImageView imageview = new ImageView(toppingImage);

		Random r = new Random();
		int imageViewX = (r.nextInt(RANDOM_CRITERIA_TOPPING_PLACEMENT)) + CRITERIA_TOPPING_PLACEMENT;
		int imageViewY = (r.nextInt(RANDOM_CRITERIA_TOPPING_PLACEMENT)) + CRITERIA_TOPPING_PLACEMENT;

		imageview.setPreserveRatio(true);
		imageview.setFitHeight(CRITERIA_TOPPING_HEIGHT);
		imageview.setLayoutX(imageViewX);
		imageview.setLayoutY(imageViewY);

		criteriaToastPane.getChildren().add(imageview);
	}

	/**
	 * 
	 * @param criteria
	 */
	public void addCriteria(String criteria) {
		criteriaToastText.setText(criteria);
	}

	public void changeToastiness(Image toast) {
		toastImage.setImage(toast);
		toastImage.getImage();
	}

	public void resetGame() {
		criteriaToastPane.getChildren().clear();
		toastPane.getChildren().clear();
		toastinessIndicator.setValue(0);
		this.initialize(null, null);
	}

	/**
	 * Called by the Tory class (the judge) to display the judge result
	 * 
	 * @param toryOpinion
	 */
	void openJudgeEvent(String toryOpinion) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ToastForTorySubmit.fxml"));
		Parent root;
		try {
			root = (Parent) fxmlLoader.load();

			Scene scene = new Scene(root);
			Stage judgeStage = new Stage();
			judgeStage.setScene(scene);
			judgeStage.show();

			SubmitInitializer judgingInitializer = (SubmitInitializer) fxmlLoader.getController();
			judgingInitializer.setParentInitializer(this);
			judgingInitializer.setText(toryOpinion);
			judgingInitializer.setThisStage(judgeStage);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error in finding fxml file.  \n Tory thinks" + toryOpinion);
		}
	}
}