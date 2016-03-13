package toastGame;

import javafx.scene.image.Image;

/**
 * The model that keeps track of the current toast displayed on the view. Should
 * be observed by the view.
 * 
 * @author Yuping Huang, Tegan Wilson, and Carolyn Ryan
 *
 */
class GameModel {
	// instance variables for user's toast and view
	private Toast toast;
	private PlayInitializer view;
	private Tory toryModel;

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
}
