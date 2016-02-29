/**
 * ToastController.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Date: Feb 28, 2016
 * 
 * ToastController class to communicate between the ViewController and eventually the model 
 * Doesn't yet communicate to the model as we have not yet implemented that aspect of the project
 */

package toastGame;

public class ToastController {
	// Topping instance variables
	private String toppingOne;
	private String toppingTwo;
	private String toppingThree;
	private String toppingFour;
	private String toppingFive;
	private String toppingSix;
	private String[] toppings = {toppingOne, toppingTwo, toppingThree, toppingFour, toppingFive, toppingSix};
		
	/**
	 * Constructor for ToastController
	 * @param toppingOne
	 * @param toppingTwo
	 * @param toppingThree
	 * @param toppingFour
	 * @param toppingFive
	 * @param toppingSix
	 */
	public ToastController(String toppingOne, String toppingTwo, String toppingThree, String toppingFour, String toppingFive, String toppingSix) {
		//sets topping parameters to topping instance variables
		this.toppingOne = toppingOne;
		this.toppingTwo = toppingTwo;
		this.toppingThree = toppingThree;
		this.toppingFour = toppingFour;
		this.toppingFive = toppingFive;
		this.toppingSix = toppingSix;
		
		toppings[0] = toppingOne;
		toppings[1] = toppingTwo;
		toppings[2] = toppingThree;
		toppings[3] = toppingFour;
		toppings[4] = toppingFive;
		toppings[5] = toppingSix;
	}
	
	/**
	 * Methods to add toppings to the user's toast
	 * They all take no parameters and return nothing
	 */
	public void addToppingOne() {
		this.add(toppingOne);
	}
	
	public void addToppingTwo() {
		this.add(toppingTwo);
	}
	
	public void addToppingThree() {
		this.add(toppingThree);
	}
	
	public void addToppingFour() {
		this.add(toppingFour);
	}
	
	public void addToppingFive() {
		this.add(toppingFive);
	}
	
	public void addToppingSix() {
		this.add(toppingSix);
	}
	
	/**
	 * General add method that adds a given topping and prints out 
	 * which topping is being added.
	 * Right now, we don't know which of the adds methods we will need 
	 * to use, and so we have multiple methods that we may or may not keep.
	 * @param topping 
	 */
	public void add(String topping){
		//myToast.add(topping);
		System.out.println("Adding "+ topping);
	}
	
	/**
	 * Will eventually call a judging method when user submits toast for critiquing
	 */
	public void submitToast() {
		System.out.println("Toast has been submitted.");
	}
	
	/**
	 * Get method to return topping list
	 * @return list of toppings
	 */
	public String[] getToppings() {
		return toppings;
	}
	
	
}
