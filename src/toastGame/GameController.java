/**
 * GameController.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Date: Feb 28, 2016
 * 
 * GameController class to communicate between the ViewInitializer and eventually the model 
 * Doesn't yet communicate to the model as we have not yet implemented that aspect of the project
 */

package toastGame;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class GameController {
	// Topping instance variables
	private Topping[] toppingList;
	// maintains a reference to the view class
	private ViewInitializer view = new ViewInitializer();
	
	/**
	 * Constructor for GameController
	 * 
	 * @param toppings
	 */
	GameController() {
		// sets topping parameters to topping instance variables
	}

	void registerView(ViewInitializer view) {
		this.view = view;
	}

	/**
	 * Create a list of buttons and return it. Should be called by the view.
	 * 
	 * @param numberOfButtons
	 * @return
	 */
	Button[] createButtons(int numberOfButtons) {
		generateToppings(numberOfButtons);
		Button[] buttons = new Button[toppingList.length];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button();
			buttons[i].setText(toppingList[i].getName());
		}
		return buttons;
	}

	private void generateToppings(int numberOfToppings) {
		numberOfToppings = 6;// for testing purpose
		this.toppingList = new Topping[numberOfToppings];
		for (int i = 0; i < toppingList.length; i++) {
			// TODO: randomize the topping generation process
			toppingList[i] = new Topping("Honey", "honey.png");
		}
	}

	/**
	 * Called by the view to react to button click
	 * 
	 * @param buttonIndex
	 *            the index of the button clicked
	 */
	void handleButtonClickEvent(int buttonIndex) {
		// TODO change toast model state
		int toppingIndex = buttonIndex;
		Image addedToastImage = toppingList[toppingIndex].getImage();
		view.addImageOnToast(addedToastImage);
		System.out.println(toppingList[toppingIndex].getName());
	}
	
	void handleEvent(String buttonText) {
		// TODO handle events
		System.out.println("Event Being Handled: " + buttonText);
		Image addedToastImage = new Image(getClass().getResource("honey.png").toExternalForm());
		//view.addImageOnToast(addedToastImage);
	}

	void submitToast() {
		// TODO initiate judging
		System.out.println("Toast has been submitted.");
	}

}
