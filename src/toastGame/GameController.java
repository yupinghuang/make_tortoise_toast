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
import javafx.scene.image.Image;

public class GameController {
	// Topping instance variables
	private Topping[] toppingList;
	private ArrayList<Topping> possibleToppings;
	
	// maintains references to the view and models
	private ViewInitializer view;
	private CurrentToast toastModel;
	private Tory toryModel;

	/**
	 * Constructor for GameController
	 */
	GameController(ViewInitializer view) {
		// register the view
		this.view = view;
		// Create the models
		this.toastModel = new CurrentToast();
		this.toryModel = new Tory();
		this.possibleToppings = createPossibleHeadings();
	}

	/**
	 * Helper method to generate possible topping list 
	 */
	private ArrayList<Topping> createPossibleHeadings() {
		possibleToppings = new ArrayList<Topping>();
		possibleToppings.add(0, new Topping("Honey", "honey.png"));
		possibleToppings.add(1, new Topping("Butter", "honey.png"));
		possibleToppings.add(2, new Topping("Peanut Butter", "honey.png"));
		possibleToppings.add(3, new Topping("Cinnamon", "honey.png"));
		possibleToppings.add(4, new Topping("Jam", "honey.png"));
		possibleToppings.add(5, new Topping("Avocado", "honey.png"));
		possibleToppings.add(6, new Topping("Jelly", "honey.png"));
		possibleToppings.add(7, new Topping("Sugar", "honey.png"));
		/*possibleToppings[0] = new Topping("Honey", "honey.png");
		possibleToppings[1] = new Topping("Butter", "honey.png");
		possibleToppings[2] = new Topping("Peanut Butter", "honey.png");
		possibleToppings[3] = new Topping("Cinnamon", "honey.png");
		possibleToppings[4] = new Topping("Jam", "honey.png");
		possibleToppings[5] = new Topping("Avocado", "honey.png");*/
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
	 * Generates random toppings for a given round of the game
	 * 
	 * @param numberOfToppings
	 * @return
	 */
	private Topping[] generateToppings(int numberOfToppings) {
		numberOfToppings = 6;// for testing purpose
		toppingList = new Topping[numberOfToppings];
		Collections.shuffle(possibleToppings);
		
		for (int i = 0; i < toppingList.length; i++) {
			// TODO: randomize the topping generation process
			toppingList[i] = possibleToppings.get(i);
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
