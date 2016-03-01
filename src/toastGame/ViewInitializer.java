/**
 * ViewInitializer.java
 * Authors: Yuping Huang, Tegan Wilson, and Carolyn Ryan
 * Class structure taken from https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to
 * Date: Feb 28, 2016
 * 
 * ViewInitializer class helps set up the GUI (View)
 */

package toastGame;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ViewInitializer implements Initializable {
	//Constant to use for Event Handling
	private String SUBMIT = "javafx.event.ActionEvent[source=Button[id=submitButton, styleClass=button]'SUBMIT']";
	
	//FXML Variable Injections
	@FXML private Pane buttonPane;
	@FXML private Button submitButton;
	@FXML private StackPane toastStackPane;
	@FXML private StackPane sideButtonPane;
	
	// Instance Variables
	private ArrayList<Topping> toppings;
	private GameController myController;
	private ArrayList<Button> buttonList;
	
	private Rectangle exampleRectangle;
	/**
	 * Defines instance variables and creates topping buttons. 
	 */
	protected void setUp() {
		toppings = new ArrayList<Topping>();
		buttonList = new ArrayList<Button>();
		
		myController = new GameController();
		myController.getToppings();
		
		/* As we have not yet implemented the full extent of our model,
		 * we will currently hard code the example for our GUI.
		 * Creating the buttons and adding them to the buttonList will eventually be 
		 * randomized by our GameController.
		 */
		Button one = new Button("Butter");
		Button two = new Button("Jam");
		Button three = new Button("Cinnamon&Sugar");
		Button four = new Button("Peanut Butter");
		Button five = new Button("Honey");
		Button six = new Button("Avocado");
		buttonList.add(one);
		buttonList.add(two);
		buttonList.add(three);
		buttonList.add(four);
		buttonList.add(five);
		buttonList.add(six);
		
		exampleRectangle = new Rectangle();
        exampleRectangle.setX(50);
        exampleRectangle.setY(50);
        exampleRectangle.setWidth(200);
        exampleRectangle.setHeight(100);
	}
	
	/**
	 * Arranges Buttons in a stack pane.
	 * This stack pane acts as a tool bar that the user can drag around to where they feel it works best for them.
	 */
	@FXML
	protected void setButtons() {
		Stage secondaryStage = new Stage();
		buttonPane = new Pane();
		buttonPane.setPrefSize(184, 63*buttonList.size());
		
		for (int i=0; i< buttonList.size(); i++) {
			buttonPane.getChildren().add(buttonList.get(i));
		}
		sideButtonPane.getChildren().add(buttonPane);

	}
	
	/**
	 * Handles button action for submit button.
	 * The submit button is implemented in the .fxml file.
	 * As such, it can't be handled in the same method as 
	 * the other buttons.
	 * @param event		The event that needs to be handled
	 */
	@FXML
	protected void handleButtonAction(ActionEvent event) {
		System.out.println("Button Pressed!");
		// When submit is pressed, calls the submit toast method
		if (event.toString().equals(SUBMIT)){
			myController.submitToast();
		}
	}
	
	/**
	 * Handles button action.
	 * Calls to the GameController to handle the button press.
	 */
	public void handleButtons() {
		// Associate actions with each button
		for (int i=0; i<buttonList.size(); i++) {
			// Associate actions with each button
			int j = i;
	        buttonList.get(i).setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Button pressed");
	                toastStackPane.getChildren().add(exampleRectangle);
	                myController.handleEvent(buttonList.get(j).getText());
	            }
	        });
		}
	}
	
	/**
	 * Called as a constructor, initializes all GUI elements of the java GUI.
	 * @param	fxmlFileLocation	The location of the fxml file to be used as a base GUI.
	 * @param	resources			The bundle of resources to be used in additional GUI development.
	 */
	@Override 
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		this.setUp();	
		for (int i=0; i< buttonList.size(); i++) {
			buttonList.get(i).setPrefSize(134, 45);
			buttonList.get(i).setLayoutX(25);
			buttonList.get(i).setLayoutY(56*i + 25);
		}
		this.setButtons();
        this.handleButtons();
	}
}