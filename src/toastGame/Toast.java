/**
 * Toast.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Date: Feb 28, 2016
 * 
 * Beginning of the model for Toast (incomplete)
 */

package toastGame;

import java.util.*;

class Toast {
	//TODO maybe a hashmap {Topping,quantity} makes more sense
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
	 * add topping to the toast might want to check the topping is legitimate
	 * 
	 * @param topping
	 */
	void addTopping(Topping topping) {
		this.toppings.add(topping);
	}

	public LinkedList<Topping> getToppings() {
		return this.toppings;
	}

	/**
	 * Toast the toast: add certain toastiness to the current value
	 * @param toastiness toastiness to add to the current toastiness
	 */
	void toast(int toastiness) {
		this.toastiness = toastiness;
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