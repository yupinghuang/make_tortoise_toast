/**
 * Tory.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Date: Feb 28, 2016
 * 
 * Beginning of the model for judging the toast(incomplete)
 */

package toastGame;

public class Tory {
	private Toast criteriaToast;

	/**
	 * Constructor of the judge, initialize instance variables
	 * 
	 */
	Tory() {
		this.criteriaToast = new Toast();
	}

	/**
	 * Generate the criteria toast for the user to imitate and the judge to
	 * judge upon
	 * 
	 * @return
	 */
	public Toast createCriteria() {
		this.criteriaToast.clear();
		// TODO add random toppings
		return this.criteriaToast;
	}

	/**
	 * Getter for criteria toast
	 * 
	 * @return
	 */
	Toast getCriteriaToast() {
		return criteriaToast;
	}

	/**
	 * Takes in user's toast and judge it based on the criteriaToast
	 * 
	 * @param userToast
	 * @return the judging comments
	 */
	public String judgeToast(Toast userToast) {
		return "";
	}

}