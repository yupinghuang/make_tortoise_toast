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
	private Toast toast;
	private GameController controller;
	private ViewInitializer view;
	private ScoreTracker scoreTracker;

	/**
	 * instantiates the user's toast in view
	 * @param game
	 * @param view
	 */
	GameModel(GameController game, ViewInitializer view) {
		this.toast = new Toast();
		this.controller = game;
		this.view = view;
	}

	/**
	 * Adds topping to the user's toast in view
	 * @param topping
	 */
	void addTopping(Topping topping) {
		toast.addTopping(topping);
		Image addedToastImage = topping.getImage();
		view.addImageOnToast(addedToastImage);
	}
	
	//Returns the toast
	Toast getToast() {
		return toast;
	}
	
	/**
	 * Toasts the toast and changes the toast image based on toastiness scale
	 * @param toastiness
	 */
	void toast(int toastiness) { 
		toast.toast(toastiness);
		if ((0<=toastiness) || (toastiness <= 3)) {
			Image toast = new Image(getClass().getResource("images/toastlevel"+toastiness+".png").toExternalForm());
			view.changeToastiness(toast);
		}
	}
}
