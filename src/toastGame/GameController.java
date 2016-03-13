/**
 * GameController.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Date: Feb 28, 2016
 * 
 * GameController class to communicate between the ViewInitializer and models classes
 */

package toastGame;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.control.Button;

public class GameController {
	private static final int NUMBER_OF_TOPPINGS = 6;
	// Topping instance variables
	private Topping[] toppingList; // toppings used for this round
	private ArrayList<Topping> possibleToppings; // all possible toppings in
													// general

	// maintains references to the view and models
	private GameModel toastModel;
	private Tory toryModel;

	/**
	 * Constructor for GameController
	 */
	GameController(PlayInitializer view) {
		// Creates the instance models
		this.toastModel = new GameModel(this, view);
		this.toryModel = new Tory(view);
		this.possibleToppings = createPossibleHeadings();
	}

	/**
	 * Helper method to generate list of all possible toppings
	 */
	private ArrayList<Topping> createPossibleHeadings() {
		possibleToppings = new ArrayList<Topping>();
		possibleToppings.add(0, new Topping("Honey", "images/honey.png"));
		possibleToppings.add(1, new Topping("Butter", "images/butter.png"));
		possibleToppings.add(2, new Topping("Peanut Butter", "images/peanutbutter.png"));
		possibleToppings.add(3, new Topping("Cinnamon", "images/cinnamon.png"));
		possibleToppings.add(4, new Topping("Jam", "images/jam.png"));
		possibleToppings.add(5, new Topping("Avocado", "images/avocado.png"));
		possibleToppings.add(6, new Topping("Cream Cheese", "images/creamcheese.png"));
		possibleToppings.add(7, new Topping("Sugar", "images/sugar.png"));
		possibleToppings.add(8, new Topping("Ice Cream", "images/icecream.png"));
		possibleToppings.add(9, new Topping("Chocolate", "images/chocolatechips.png"));

		return possibleToppings;
	}

	/**
	 * Create a list of buttons and return it. Should be called by the view.
	 * 
	 * @param numberOfButtons
	 *            Number of topping buttons desired in the given round
	 * @return List of all the buttons created.
	 */
	Button[] createButtons(int numberOfButtons) {
		this.toppingList = generateToppingsAndCriteria();
		Button[] buttons = new Button[toppingList.length];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button();
			buttons[i].setText(toppingList[i].getName());
		}
		return buttons;
	}

	/**
	 * Generates random toppings for a given round of the game. Also calls Tory
	 * to generate Tory's criteria.
	 * 
	 * @param numberOfToppings
	 *            Number of toppings desired (NOTE: for our game, we override
	 *            this value and change it to 6)
	 * @return List of randomized toppings to be used in this round of the game
	 */
	private Topping[] generateToppingsAndCriteria() {
		toppingList = new Topping[NUMBER_OF_TOPPINGS];
		Collections.shuffle(possibleToppings);

		for (int i = 0; i < toppingList.length; i++) {
			// randomizes the topping generation process
			toppingList[i] = possibleToppings.get(i);
		}
		// Creates Tory's criteria within this method
		this.toryModel.createCriteria(toppingList);
		return toppingList;
	}

	/**
	 * Adds the correct topping to user toast when topping button is clicked
	 * 
	 * @param buttonIndex
	 *            The index of the button clicked
	 */
	void handleButtonClickEvent(int buttonIndex) {
		int toppingIndex = buttonIndex;
		this.toastModel.addTopping(toppingList[toppingIndex]);
	}

	/**
	 * Toasts the toast
	 * 
	 * @param toastiness
	 */
	void toastToast(int toastiness) {
		this.toastModel.toast(toastiness);
	}

	/**
	 * Submits (judges) the user's toast
	 */
	void submitToast() {
		this.toryModel.judgeToast(this.toastModel.getToast());
	}
}
