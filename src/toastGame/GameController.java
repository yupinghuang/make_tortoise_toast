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
import java.util.Collections;

import javafx.scene.control.Button;

public class GameController {
	// Topping instance variables
	private Topping[] toppingList;
	private ArrayList<Topping> possibleToppings;
	
	// maintains references to the view and models
	private GameModel toastModel;
	private Tory toryModel;

	/**
	 * Constructor for GameController
	 */
	GameController(ViewInitializer view) {
		// Create the models
		this.toastModel = new GameModel(this, view);
		this.toryModel = new Tory(view);
		this.possibleToppings = createPossibleHeadings();
	}

	/**
	 * Helper method to generate possible topping list 
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
		
		return possibleToppings;
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
	 * Generates random toppings for a given round of the game.
	 * Currently also generates Tory's criteria.
	 * 
	 * @param numberOfToppings
	 * @return
	 */
	private Topping[] generateToppings(int numberOfToppings) {
		numberOfToppings = 6; // for testing purpose
		toppingList = new Topping[numberOfToppings];
		Collections.shuffle(possibleToppings);
		
		for (int i = 0; i < toppingList.length; i++) {
			// randomizes the topping generation process
			toppingList[i] = possibleToppings.get(i);
		}
		//currently creates Tory's criteria within this method
		this.toryModel.createCriteria(toppingList);
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
		this.toastModel.addTopping(toppingList[toppingIndex]);
	}

	/**
	 * Method called when submit is pressed to judge the toast made
	 */
	void submitToast() {		
		this.toryModel.judgeToast(this.toastModel.getToast());
	}
	
	/**
	 * Method called by the view to toast the toast
	 * @param toastiness
	 */
	void toastToast(int toastiness) {
		this.toastModel.toast(toastiness);
	}
}
