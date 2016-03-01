/**
 * ViewController.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Some code altered from  https://blogs.oracle.com/jmxetc/entry/connecting_scenebuilder_edited_fxml_to
 * Date: Feb 28, 2016
 * 
 * ViewController class helps set up the GUI (View)
 */

package toastGame;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ViewController implements Initializable {
	//Constants to use for event handling 
	private String SUBMIT = "javafx.event.ActionEvent[source=Button[id=submitButton, styleClass=button]'SUBMIT']";
	
	//Injects all the topping buttons for event handling
	@FXML private Pane myStackPane;
	@FXML private Button submitButton;

	
	private ArrayList<String> toppings;
	private ToastController myController;
	private Button two;
	
	protected void setUp() {
		toppings = new ArrayList<String>();
		myController = new ToastController();
		two = new Button("Jam");

	}
	
	/**
	 * Is called in the instantiator.
	 * Sets the button text to be for the toppings available in this round.
	
	@FXML
	protected void setButtonText() {
		Button[] buttonList = {toppingOne, toppingTwo, toppingThree, toppingFour, toppingFive, toppingSix};
		toppings = myController.getToppings();
		//loops through the button and topping lists to set the button text
		for (int i=0; i<toppings.size(); i++) {
			Button button = buttonList[i];
			String top = toppings.get(i);
			button.setText(top);
		}
	} */
	
	/**
	 * @param ArrayList<Button>
	 */
	@FXML
	protected void setButtons(Button[] buttonList) {
		Stage secondaryStage = new Stage();
		myStackPane = new Pane();
		myStackPane.setPrefSize(184, 63*buttonList.length);
		
		for (int i=0; i< buttonList.length; i++) {
			//System.out.println(buttonList[i]);
			buttonList[i].setId("handleButtonAction");
			myStackPane.getChildren().add(buttonList[i]);
		}

		Scene scene = new Scene(myStackPane);
		secondaryStage.setScene(scene);
		secondaryStage.setTitle("Toast For Tory!");
		secondaryStage.show();

	}
	
	/**
	 * Handles button action for all pressable buttons
	 * (ie the topping and submit buttons).
	 * @param event
	 */
	@FXML
	protected void handleButtonAction(ActionEvent event) {
		System.out.println("Button Pressed!");
		// When submit is pressed, calls the submit toast method
		if (event.toString().equals(SUBMIT)){
			//System.out.println("Submit button pressed");
			myController.submitToast();
		}
	}
	
	public void handleButtons() {
		two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button two pressed");;
            }
        
        });
	}
	
	/**
	 * This method is called by the FXMLLoader when initialization is complete.
	 */
	@Override 
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		this.setUp();		

		Button one = new Button("Butter");
		Button three = new Button("Cinnamon&Sugar");
		Button four = new Button("Peanut Butter");
		Button five = new Button("Honey");
		Button six = new Button("Avocado");

		
		Button[] buttonList = {one, two, three, four, five, six};
		for (int i=0; i< buttonList.length; i++) {
			buttonList[i].setPrefSize(134, 45);
			buttonList[i].setLayoutX(25);
			buttonList[i].setLayoutY(56*i + 25);
		}
		this.setButtons(buttonList);
		// Associate actions with each button
        one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button one pressed");;
            }
        });
        this.handleButtons();
        
		// initialize your logic here: all @FXML variables will have been injected
	}
}