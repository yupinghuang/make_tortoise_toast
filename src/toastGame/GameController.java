/**
 * GameController.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Date: Feb 28, 2016
 * 
 * GameController class to communicate between the ViewInitializer and eventually the model 
 * Doesn't yet communicate to the model as we have not yet implemented that aspect of the project
 */

package toastGame;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class GameController {
	// Topping instance variables
	private Topping[] toppingList;
	// maintains a reference to the view class
	private ViewInitializer view = new ViewInitializer();

	/**
	 * Constructor for GameController
	 */
	GameController() {
	}

	/**
	 * Registers the controller with the view initializer. Observer Pattern in
	 * use.
	 * 
	 * @param view
	 *            The ViewInitializer to register with
	 */
	void registerView(ViewInitializer view) {
		this.view = view;
	}

	/**
	 * Create a list of buttons and return it. Should be called by the view.
	 * 
	 * @param numberOfButtons
	 *            Topping buttons desired in the given round
	 * @return buttons List of all the buttons created.
	 */
	Button[] createButtons(int numberOfButtons) {
		this.toppingList = generateToppings(numberOfButtons);
		Button[] buttons = new Button[toppingList.length];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button();
			buttons[i].setText(toppingList[i].getName());
		}
		return buttons;
	}

	/**
	 * Generates random toppings for a given round of the game
	 * 
	 * @param numberOfToppings
	 * @return
	 */
	private Topping[] generateToppings(int numberOfToppings) {
		numberOfToppings = 6;// for testing purpose
		toppingList = new Topping[numberOfToppings];
		for (int i = 0; i < toppingList.length; i++) {
			// TODO: randomize the topping generation process
			toppingList[i] = new Topping("Honey", "honey.png");
		}
		return toppingList;
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
		System.out.println("Adding " + toppingList[toppingIndex].getName() + " to toast!");
	}

	/**
	 * Method called when submit is pressed. Will eventually judge the game.
	 */
	void submitToast() {
		// TODO initiate judging
		System.out.println("Toast has been submitted for judging.");
	}

}
