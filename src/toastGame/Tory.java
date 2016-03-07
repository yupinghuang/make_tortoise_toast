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

	/**
	 * Instantiates Tory object, which has a (plain) Toast object as it's
	 * criteria
	 */
	Tory() {
		// sets Tory's toast criteria to be plain toast
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

		// randomly sets the number of toppings for our criteria toast
		Random rand = new Random();
		int numToppings = 5 + rand.nextInt(5);

		// adds random toppings from toppingList until we have the correct
		// number of toppings
		for (int i = 0; i < numToppings; i++) {
			int topping = rand.nextInt(6);
			int amount = rand.nextInt(6);
			criteriaToast.addTopping(toppingList[topping], amount);
		}

		// toasts the toast a random amount
		int toastiness = rand.nextInt(4);
		criteriaToast.toast(toastiness);
		// This is where we would randomly get rid of toppings and set the
		// toastiness of the criteria

	}

	Toast getCriteria() {
		// returns a toast object of Tory's current criteria
		return this.criteriaToast;
	}

	/**
	 * Generate and return the image of the
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
		// loops through criteria toppings
		for (Map.Entry<Topping, Integer> criteriaEntry : criteriaToast.getToppings().entrySet()) {

			int userToppingNumber = 0;
			// finds the number of this topping the user put into their toast,
			// returns 0 if not in the map
			if (!(userToppingsMap.get(criteriaEntry.getKey()) == null)) {
				userToppingNumber = userToppingsMap.get(criteriaEntry.getKey());
			}
			// finds the difference between user and criteria toppings
			// values
			// adds difference to the judgeValue
			judgeValue = judgeValue + Math.abs(userToppingNumber - criteriaEntry.getValue());
			System.out.printf("Criteria toast has %s %s. %n", criteriaEntry.getValue(), criteriaEntry.getKey().getName());
			System.out.printf("User toast has %s %s. %n", userToppingNumber, criteriaEntry.getKey().getName());
			System.out.println("JudgeValue currently at " + judgeValue);

		}

		System.out.println("Criteria toast has " + criteriaToast.getToastiness() + " toastiness level.");
		System.out.println("User toast has " + userToast.getToastiness() + " toastiness level.");
		// adds difference in toastiness to the judgeValue
		judgeValue = judgeValue + Math.abs(userToast.getToastiness() - criteriaToast.getToastiness());
		System.out.println("JudgeValue currently at " + judgeValue);
		
		String toryOpinion = "";
		if (judgeValue < 4) {
			toryOpinion = "Awesome!";
		} else if (judgeValue < 7) {
			toryOpinion = "Good.";
		} else if (judgeValue < 10){
			toryOpinion = "Bad.";
		} else {
			toryOpinion = "Horrible!";
		}
		System.out.println(toryOpinion);
		return toryOpinion;
	}
}
