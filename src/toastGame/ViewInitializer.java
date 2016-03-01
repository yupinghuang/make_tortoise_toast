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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ViewInitializer implements Initializable {
	// Constant variables
	private static final int BUTTON_Y_MULTIPLIER = 56;
	private static final int BUTTON_X_LAYOUT = 25;
	private static final int BUTTONSIZE_Y = 45;
	private static final int BUTTONSIZE_X = 134;
	private static final String SUBMIT = "javafx.event.ActionEvent[source=Button[id=submitButton, styleClass=button]'SUBMIT']";
	
	//FXML Variable Injections
	@FXML private Pane buttonPane;
	@FXML private Button submitButton;
	@FXML private StackPane toastStackPane;
	@FXML private StackPane sideButtonPane;
	
	// Instance Variables
	private ArrayList<Topping> toppings;
	private GameController myController;
	private ArrayList<Button> buttonList;
	
	//Used later as an example of how to add to a stackpane
	private Rectangle exampleRectangle;
	/**
	 * Defines instance variables and creates topping buttons. 
	 */
	protected void setUp() {
		toppings = new ArrayList<Topping>();
		buttonList = new ArrayList<Button>();
		
		myController = new GameController();
		//myController.getToppings();
		
		/* As we have not yet implemented the full extent of our model,
		 * we will currently hard code the example for our GUI.
		 * Creating the buttons and adding them to the buttonList will eventually be 
		 * randomized by our GameController.  (TOBEDELETED)
		 * 
		 * Currently our interface is limited to six topping buttons, but this can change.
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
		
		// For the stack pane example.  (TOBEDELETED)
		exampleRectangle = new Rectangle();
        exampleRectangle.setX(50);
        exampleRectangle.setY(50);
        exampleRectangle.setWidth(200);
        exampleRectangle.setHeight(100);
	}
	
	/**
	 * Arranges Buttons in a stack pane.
	 * This stack pane is placed on the 
	 */
	@FXML
	protected void setButtons() {
		//Add buttons in list to the pane
		buttonPane = new Pane();
		for (int i=0; i< buttonList.size(); i++) {
			buttonPane.getChildren().add(buttonList.get(i));
		}
		//Add the button pane to the side pane
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
	                System.out.println("Button pressed!");
	                //toastStackPane.getChildren().add(exampleRectangle);
	                myController.handleEvent(buttonList.get(j).getText());
	            }
	        });
		}
	}
	
	//TODO Figure out how to add an image to a stack pane and do this step
	/* NOTE:::: GameController CANNOT have a ViewInitializer because it will not initialize the view
	 * As such, we need to work around this.  Otherwise, none of the stacks are set or buttons which 
	 * leads to a series of frustrating errors.  
	 * These classes so far work together and can handle events well enough but we need
	 * to think around gameController having a ViewInitializer.
	*/
	public void addImageOnToast(Image addToToast) {
		ImageView imv = new ImageView();
		System.out.println("Adding Image to Toast");
		imv.setImage(addToToast);
		System.out.println("set to imv");
       // toastStackPane.getChildren().add(imv);
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
			buttonList.get(i).setPrefSize(BUTTONSIZE_X, BUTTONSIZE_Y);
			buttonList.get(i).setLayoutX(BUTTON_X_LAYOUT);
			buttonList.get(i).setLayoutY(BUTTON_Y_MULTIPLIER*i + BUTTON_X_LAYOUT);
		}
		this.setButtons();
        this.handleButtons();
	}
}