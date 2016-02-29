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
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ViewController implements Initializable {
	//Constants to use for event handling 
	private String TOPPINGONE = "javafx.event.ActionEvent[source=Button[id=toppingOne, styleClass=button]'Butter']";
	private String TOPPINGTWO = "javafx.event.ActionEvent[source=Button[id=toppingTwo, styleClass=button]'Jam']";
	private String TOPPINGTHREE = "javafx.event.ActionEvent[source=Button[id=toppingThree, styleClass=button]'PeanutButter']";
	private String TOPPINGFOUR = "javafx.event.ActionEvent[source=Button[id=toppingFour, styleClass=button]'Cinnamon&Sugar']";
	private String TOPPINGFIVE = "javafx.event.ActionEvent[source=Button[id=toppingFive, styleClass=button]'Cream Cheese']";
	private String TOPPINGSIX = "javafx.event.ActionEvent[source=Button[id=toppingSix, styleClass=button]'Honey']";
	private String SUBMIT = "javafx.event.ActionEvent[source=Button[id=submitButton, styleClass=button]'SUBMIT']";
	
	//Injects all the topping buttons for event handling
	@FXML private Button toppingOne;
	@FXML private Button toppingTwo;
	@FXML private Button toppingThree;
	@FXML private Button toppingFour;
	@FXML private Button toppingFive;
	@FXML private Button toppingSix;
	
	private String[] toppings = {"Butter", "Jam", "PeanutButter", "Cinnamon&Sugar", "Cream Cheese", "Honey"};
	
	ToastController myController = new ToastController("Butter", "Jam", "PeanutButter", "Cinnamon&Sugar", "Cream Cheese", "Honey");
	
	/**
	 * Is called in the instantiator.
	 * Sets the button text to be for the toppings available in this round.
	 */
	@FXML
	protected void setButtonText() {
		Button[] buttonList = {toppingOne, toppingTwo, toppingThree, toppingFour, toppingFive, toppingSix};
		toppings = myController.getToppings();
		//loops through the button and topping lists to set the button text
		for (int i=0; i<=5; i++) {
			Button button = buttonList[i];
			String top = toppings[i];
			button.setText(top);
		}
	}
	
	/**
	 * Handles button action for all pressable buttons
	 * (ie the topping and submit buttons).
	 * @param event
	 */
	@FXML
	protected void handleButtonAction(ActionEvent event) {
		System.out.println("Button Pressed!");
		//System.out.println(event);
		
		// A series of if statements to check which button has been pressed
		// and it calls the controller to add the topping
		if (event.toString().equals(TOPPINGONE)) {
			//System.out.println("Topping One");
			myController.addToppingOne();
		}
		if (event.toString().equals(TOPPINGTWO)) {
			//System.out.println("Topping Two");
			myController.addToppingTwo();
		}
		if (event.toString().equals(TOPPINGTHREE)) {
			//System.out.println("Topping Three");
			myController.addToppingThree();
		}
		if (event.toString().equals(TOPPINGFOUR)) {
			//System.out.println("Topping Four");
			myController.addToppingFour();
		}
		if (event.toString().equals(TOPPINGFIVE)) {
			//System.out.println("Topping Five");
			myController.addToppingFive();
		}
		if (event.toString().equals(TOPPINGSIX)) {
			//System.out.println("Topping Six");
			myController.addToppingSix();
		}
		
		// When submit is pressed, calls the submit toast method
		if (event.toString().equals(SUBMIT)){
			//System.out.println("Submit button pressed");
			myController.submitToast();
		}
	}
	
	/**
	 * This method is called by the FXMLLoader when initialization is complete.
	 */
	@Override 
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		
		assert toppingOne != null : "fx:id=\"toppingOne\" was not injected: check your FXML file 'simple.fxml'.";
		
		// initialize your logic here: all @FXML variables will have been injected
		this.setButtonText();

	}
}