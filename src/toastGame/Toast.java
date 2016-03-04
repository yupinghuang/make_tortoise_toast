/**
 * Toast.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Date: Feb 28, 2016
 * 
 * Beginning of the model for Toast (INCOMPLETE)
 */

package toastGame;

import java.util.*;

class Toast {
	// TODO maybe a hashmap {Topping, quantity} would make more sense
	private LinkedList<Topping> toppings;
	private int toastiness;

	/**
	 * create the toast object with 0 toastiness and no topping
	 */
	Toast() {
		this.toppings = new LinkedList<Topping>();
		this.toastiness = 0;
	}

	/**
	 * Adds topping to the toast, might want to check the topping is legitimate
	 * 
	 * @param topping
	 */
	void addTopping(Topping topping) {
		this.toppings.add(topping);
	}

	LinkedList<Topping> getToppings() {
		return this.toppings;
	}

	/**
	 * Toast the toast: add certain toastiness to the current value
	 * 
	 * @param toastiness
	 *            toastiness to add to the current toastiness
	 */
	void toast(int toastiness) {
		//is toastiness is not between 0 and 3, sets it to 0 or 3.
		if (toastiness < 0) {
			this.toastiness = 0;
		} else if (toastiness > 3) {
			this.toastiness = 3;
		} else {
			this.toastiness = toastiness;
		}
	}

	int getToastiness() {
		// returns toastiness
		return toastiness;
	}

	void clear() {
		// resets toastiness to 0 and toppings list to empty
		// The user should not be able to clear their toast when making it
		this.toastiness = 0;
		this.toppings.clear();
	}

}
