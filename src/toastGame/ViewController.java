package toastGame;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ViewController implements Initializable {
	//Constants to use for event handling 
	private String TOPPINGONE = "javafx.event.ActionEvent[source=Button[id=toppingOne, styleClass=button]'toppingOne']";
	private String TOPPINGTWO = "javafx.event.ActionEvent[source=Button[id=toppingTwo, styleClass=button]'toppingTwo']";
	private String TOPPINGTHREE = "javafx.event.ActionEvent[source=Button[id=toppingThree, styleClass=button]'toppingThree']";
	private String TOPPINGFOUR = "javafx.event.ActionEvent[source=Button[id=toppingFour, styleClass=button]'toppingFour']";
	private String TOPPINGFIVE = "javafx.event.ActionEvent[source=Button[id=toppingFive, styleClass=button]'toppingFive']";
	private String TOPPINGSIX = "javafx.event.ActionEvent[source=Button[id=toppingSix, styleClass=button]'toppingSix']";
	private String SUBMIT = "javafx.event.ActionEvent[source=Button[id=submitButton, styleClass=button]'SUBMIT']";
	
	
	@FXML private Button toppingOne;
	@FXML private Button toppingTwo;
	@FXML private Button toppingThree;
	@FXML private Button toppingFour;
	@FXML private Button toppingFive;
	@FXML private Button toppingSix;
	
	ToastController myController = new ToastController("Butter", "Jam", "PeanutButter", "Jelly", "Cream Cheese", "Sugar");
	
	@FXML
	protected void handleButtonAction(ActionEvent event) {
		System.out.println("Button Pressed!");
		//System.out.println(event);
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
		if (event.toString().equals(SUBMIT)){
			//System.out.println("Submit button pressed");
			myController.submitToast();
		}
	}
	

	@Override // This method is called by the FXMLLoader when initialization is
				// complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert toppingOne != null : "fx:id=\"toppingOne\" was not injected: check your FXML file 'simple.fxml'.";

		// initialize your logic here: all @FXML variables will have been
		// injected


	}
}