/**
 * GameController.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Date: Feb 28, 2016
 * 
 * GameController class to communicate between the ViewInitializer and models classes
 */

package toastGame;

import javafx.scene.control.Button;

public class GameController {
	// toppings Corresponding to the buttons
	private Topping[] toppingList; 

	// maintains references to the view and models
	private GameModel gameModel;

	/**
	 * Constructor for GameController
	 */
	GameController(PlayInitializer view) {
		// Creates the instance models
		this.gameModel = new GameModel(view);
		gameModel.createPossibleToppings();
	}

	/**
	 * Create a list of buttons and return it. Should be called by the view.
	 * 
	 * @param numberOfButtons
	 *            Number of topping buttons desired in the given round
	 * @return List of all the buttons created.
	 */
	Button[] createButtons() {
		this.toppingList = gameModel.generateToppingsAndCriteria();
		return gameModel.createButtons();
	}

	/**
	 * Adds the correct topping to user toast when topping button is clicked
	 * 
	 * @param buttonIndex
	 *            The index of the button clicked
	 */
	void handleButtonClickEvent(int buttonIndex) {
		int toppingIndex = buttonIndex;
		this.gameModel.addTopping(toppingList[toppingIndex]);
	}

	/**
	 * Toasts the toast
	 * 
	 * @param toastiness
	 */
	void toastToast(int toastiness) {
		this.gameModel.toast(toastiness);
	}

	/**
	 * Submits (judges) the user's toast
	 */
	void submitToast() {
		gameModel.judgeToast();
	}
}
