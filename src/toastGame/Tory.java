/**
 * Tory.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Date: Feb 28, 2016
 * 
 * Beginning of the model for judging the toast(incomplete)
 */

package toastGame;

import java.util.Map;
import java.util.Random;

import javafx.scene.image.Image;

public class Tory {
	private Toast criteriaToast;
	private Topping[] toppingList;
	private ViewInitializer view;

	/**
	 * Instantiates Tory object, which has a (plain) Toast object as it's
	 * criteria
	 */
	Tory(ViewInitializer view) {
		this.criteriaToast = new Toast();
		this.view = view;
	}

	/**
	 * Changes the criteria Toast to have a randomized set of toppings
	 * 
	 * @param toppingList
	 *            the list of possible toppings the user can select
	 * @return the criteria Toast object
	 */
	public void createCriteria(Topping[] toppingList) {
		// should create toast objects based on difficulty of the game
		// (implement this later)
		this.criteriaToast.clear();
		this.toppingList = toppingList;

		// randomly sets the number of toppings for our criteria toast
		Random rand = new Random();
		int numToppings = 5 + rand.nextInt(5);

		// adds random toppings from toppingList
		// adds toppings in randomized amounts
		for (int i = 0; i < numToppings; i++) {
			int topping = rand.nextInt(6);
			int amount = rand.nextInt(6);
			criteriaToast.addTopping(toppingList[topping], amount);
		}

		// toasts the toast a random amount
		int toastiness = rand.nextInt(6);
		criteriaToast.toast(toastiness);
		
		view.addCriteria(getCriteriaString());
		view.addCriteriaToast(this.getToastImage());
		view.addCriteriaToppings(criteriaToast);
	}

	/**
	 * Returns Tory's current toast criteria
	 * 
	 * @return
	 */
	Toast getCriteria() {
		// returns a toast object of Tory's current criteria
		return this.criteriaToast;
	}

	/**
	 * Prints Tory's criteria to the terminal window
	 * Criteria is given somewhat vaguely, but specific enough to (kind of) understand
	 */
	void printCriteria() {
		System.out.println(getCriteriaString());
	}
	
	/**
	 * Prints Tory's criteria to the terminal window
	 * Criteria is given somewhat vaguely, but specific enough to (kind of) understand
	 */
	String getCriteriaString() {
		String criteriaString = "Tory wants: \n";
		Map<Topping, Integer> criteriaToppingsMap = criteriaToast.getToppings();
		for (Topping topping : toppingList) {
			int criteriaToppingNumber = 0;
			if (criteriaToppingsMap.get(topping) != null) {
				criteriaToppingNumber = criteriaToppingsMap.get(topping);
			}			
			if (criteriaToppingNumber == 0) {
				//criteriaString = criteriaString + "None of " + topping.getName() + "\n";
			} else if (criteriaToppingNumber < 4) {
				criteriaString = criteriaString + "A little " + topping.getName() + ".\n";
			} else if (criteriaToppingNumber < 9) {
				criteriaString = criteriaString + "Lots of " + topping.getName() + ".\n";
			} else {
				criteriaString = criteriaString + "A ton of " + topping.getName() + ".\n";
			}
			
		}
		if (criteriaToast.getToastiness() < 2) {
			criteriaString  = criteriaString + "And not toasted.";
		} else if (criteriaToast.getToastiness() < 4) {
			criteriaString  = criteriaString + "And somewhat toasted.";
		} else {
			criteriaString  = criteriaString + "And almost burnt.";
		}
		return criteriaString;
	}

	/**
	 * Generate and return the image of the toast? (Currently returns null)
	 * TODO: Finish dealing with this function
	 * 
	 * @return
	 */
	Image getToastImage() {
		int toastiness = criteriaToast.getToastiness();
		Image toast = new Image(getClass().getResource("images/toastlevel"+ toastiness +".png").toExternalForm());
		return toast;
	}

	/**
	 * Takes user's Toast object and judges it in accordance with Tory's
	 * criteria Toast object
	 * 
	 * @param userToast
	 * @return
	 */
	String judgeToast(Toast userToast) {
		// takes in the user's toast and judges it based on Tory's current
		// criteria (implement later)
		// Could judge differently based on difficulty of level
		System.out.println("Toast has been submitted for judging.");

		int judgeValue = 0;
		Map<Topping, Integer> userToppingsMap = userToast.getToppings();
		Map<Topping, Integer> criteriaToppingsMap = criteriaToast.getToppings();
		// loops through the possible toppings for this round
		for (Topping topping : toppingList) {

			int userToppingNumber = 0;
			// finds the number of this topping the user put into their toast,
			// sets to 0 if not in the map
			if (userToppingsMap.get(topping) != null) {
				userToppingNumber = userToppingsMap.get(topping);
			}
			// finds the number of this topping in the criteria toast
			// sets to 0 if not in the map
			int criteriaToppingNumber = 0;
			if (criteriaToppingsMap.get(topping) != null) {
				criteriaToppingNumber = criteriaToppingsMap.get(topping);
			}
			// finds the difference between user and criteria toppings
			// adds difference to the judgeValue
			judgeValue = judgeValue + Math.abs(userToppingNumber - criteriaToppingNumber);
		}

		// finds difference in toastiness between user and criteria toast
		// adds difference to the judgeValue

		judgeValue = judgeValue + Math.abs(userToast.getToastiness() - criteriaToast.getToastiness());
		System.out.println("You made " + judgeValue + " mistakes.");

		// Returns Tory's opinion of the toast based on the judgeValue
		String toryOpinion = "";
		if (judgeValue < 4) {
			toryOpinion = "Awesome!";
		} else if (judgeValue < 8) {
			toryOpinion = "Good.";
		} else if (judgeValue < 12) {
			toryOpinion = "Bad.";
		} else {
			toryOpinion = "Horrible!";
		}
		System.out.println(toryOpinion);
		return toryOpinion;
	}
}
