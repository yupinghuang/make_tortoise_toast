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

	/**
	 * Instantiates Tory object, which has a (plain) Toast object as it's
	 * criteria
	 */
	Tory() {
		this.criteriaToast = new Toast();
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
		System.out.println("Tory wants:");
		Map<Topping, Integer> criteriaToppingsMap = criteriaToast.getToppings();
		for (Topping topping : toppingList) {
			int criteriaToppingNumber = 0;
			if (criteriaToppingsMap.get(topping) != null) {
				criteriaToppingNumber = criteriaToppingsMap.get(topping);
			}
			//System.out.printf("Criteria toast has %s %s. %n", criteriaToppingNumber, topping.getName());
			
			if (criteriaToppingNumber == 0) {
				//System.out.printf("No %s, %n", topping.getName());
			} else if (criteriaToppingNumber < 4) {
				System.out.printf("A few %s, %n", topping.getName());
			} else if (criteriaToppingNumber < 9) {
				System.out.printf("Lots of %s, %n", topping.getName());
			} else {
				System.out.printf("A ton of %s, %n", topping.getName());
			}
			
		}
		//System.out.println("Criteria toast has " + criteriaToast.getToastiness() + " toastiness level.");
		if (criteriaToast.getToastiness() < 2) {
			System.out.println("And not toasted.");
		} else if (criteriaToast.getToastiness() < 4) {
			System.out.println("And somewhat toasted.");
		} else {
			System.out.println("And almost burnt.");
		}
	}

	/**
	 * Generate and return the image of the toast? (Currently returns null)
	 * TODO: Finish dealing with this function
	 * 
	 * @return
	 */
	Image getToastImage() {
		return null;
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

			// System.out.printf("Criteria toast has %s %s. %n", criteriaToppingNumber, topping.getName());
			// System.out.printf("User toast has %s %s. %n", userToppingNumber, topping.getName());
			// System.out.println("JudgeValue currently at " + judgeValue);

		}

		// finds difference in toastiness between user and criteria toast
		// adds difference to the judgeValue

		// System.out.println("Criteria toast has " + criteriaToast.getToastiness() + "toastiness level.");
		// System.out.println("User toast has " + userToast.getToastiness() + "toastiness level.");
		judgeValue = judgeValue + Math.abs(userToast.getToastiness() - criteriaToast.getToastiness());
		System.out.println("Final JudgeValue at " + judgeValue);

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
