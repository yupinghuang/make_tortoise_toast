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
	// instance variables: toppings and toastiness
	private Map<Topping, Integer> toppings;
	private int toastiness;

	/**
	 * Creates the toast object with 0 toastiness and no toppings
	 */
	Toast() {
		this.toppings = new HashMap<Topping, Integer>();
		this.toastiness = 0;
	}

	/**
	 * Adds topping to the toast, might want to check the topping is legitimate
	 * (Topping should be legitimate, since it was created, but we could create
	 * an assert/if statement...)
	 * 
	 * @param topping
	 *            Topping to add
	 */
	void addTopping(Topping topping) {
		if (this.toppings.containsKey(topping)) {
			// if topping is already in hashmap, updates the number
			int i = this.toppings.get(topping);
			i++;
			this.toppings.put(topping, i);
		} else {
			// else, adds the new topping to the hashmap
			this.toppings.put(topping, 1);
		}
	}

	/**
	 * Add an amount of a certain topping, gets called by Tory
	 * 
	 * @param topping
	 *            Topping to add
	 * @param amount
	 *            Amount of topping to add
	 */
	void addTopping(Topping topping, int amount) {
		if (this.toppings.containsKey(topping)) {
			int i = this.toppings.get(topping);
			this.toppings.put(topping, i + amount);
		} else {
			this.toppings.put(topping, amount);
		}
	}

	/**
	 * Get function for the toppings hashmap
	 * 
	 * @return List of toppings currently on toast
	 */
	Map<Topping, Integer> getToppings() {
		return this.toppings;
	}

	/**
	 * Sets toastiness of toast to the toastiness int value
	 * 
	 * @param toastiness	Toastiness to set to
	 */
	void toast(int toastiness) {
		// is toastiness is not between 0 and 5, sets it to 0 or 5.
		if (toastiness < 0) {
			this.toastiness = 0;
		} else if (toastiness > 5) {
			this.toastiness = 5;
		} else {
			this.toastiness = toastiness;
		}
	}

	/**
	 * Get function for toastiness
	 * 
	 * @return		Current toastiness of toast
	 */
	int getToastiness() {
		return toastiness;
	}

	/**
	 * Clears the toast object
	 */
	void clear() {
		this.toastiness = 0;
		this.toppings.clear();
	}

}
