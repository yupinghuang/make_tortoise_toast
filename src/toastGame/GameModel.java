package toastGame;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

/**
 * The model that keeps track of the current toast displayed on the view. Should
 * be observed by the view.
 * 
 * @author Yuping Huang, Tegan Wilson, and Carolyn Ryan
 *
 */
class GameModel {
	private static final int NUMBER_OF_BUTTONS = 6;

	// instance variables for user's toast and view
	private Toast toast;
	private PlayInitializer view;
	private Tory toryModel;
	ArrayList<Topping> possibleToppings;
	private Topping[] toppingList; // toppings used for this round


	/**
	 * Instantiates the user's toast in view
	 * 
	 * @param view
	 *            PlayInitializer object
	 */
	GameModel(PlayInitializer view) {
		this.toast = new Toast();
		this.view = view;
		this.toryModel = new Tory(view);
	}

	/**
	 * Adds topping to the user's toast in view
	 * 
	 * @param topping
	 *            Topping to add on user's toast
	 */
	public void addTopping(Topping topping) {
		toast.addTopping(topping);
		Image addedToastImage = topping.getImage();
		view.addImageOnToast(addedToastImage);
	}

	/**
	 * Method to get user toast
	 * 
	 * @return user toast
	 */
	public Toast getToast() {
		return toast;
	}

	/**
	 * Toasts user's toast and changes the toast image based on toastiness scale
	 * 
	 * @param toastiness
	 *            The toastiness desired by the user
	 */
	public void toast(int toastiness) {
		toast.toast(toastiness);
		if ((0 <= toastiness) && (toastiness <= 5)) {
			Image toast = new Image(getClass().getResource("images/toastlevel" + toastiness + ".png").toExternalForm());
			view.changeToastiness(toast);
		}
	}

	/**
	 * Calls Tory judge toast method
	 */
	public void judgeToast() {
		this.toryModel.judgeToast(toast);
	}

	/**
	 * Creates criteria for Tory
	 * 
	 * @param toppingList
	 *            a list of toppings to use to create criteria
	 */
	public void createCriteria(Topping[] toppingList) {
		this.toryModel.createCriteria(toppingList);
	}

	/**
	 * Method that creates possible toppings array for game play
	 * @return
	 */
	public ArrayList<Topping> createPossibleHeadings() {
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
	 * Generates random toppings for a given round of the game. Also calls Tory
	 * to generate Tory's criteria.
	 *
	 * @return List of randomized toppings to be used in this round of the game
	 */
	public Topping[] generateToppingsAndCriteria() {
		toppingList = new Topping[NUMBER_OF_BUTTONS];
		Collections.shuffle(possibleToppings);

		for (int i = 0; i < toppingList.length; i++) {
			// randomizes the topping generation process
			toppingList[i] = possibleToppings.get(i);
		}
		// Creates Tory's criteria within this method
		createCriteria(toppingList);
		return toppingList;
	}

	/**
	 * Method to create topping buttons
	 * @return	buttons	List of 6 buttons to be used
	 */
	public Button[] createButtons() {
		Button[] buttons = new Button[toppingList.length];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button();
			buttons[i].setText(toppingList[i].getName());
		}
		return buttons;		
	}
}
