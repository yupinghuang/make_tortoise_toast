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

	/**
	 * Instantiates the user's toast in view
	 * 
	 * @param view
	 *            PlayInitializer object
	 */
	GameModel(GameController game, PlayInitializer view) {
		this.toast = new Toast();
		this.view = view;
	}

	/**
	 * Adds topping to the user's toast in view
	 * 
	 * @param topping
	 *            Topping to add on user's toast
	 */
	void addTopping(Topping topping) {
		toast.addTopping(topping);
		Image addedToastImage = topping.getImage();
		view.addImageOnToast(addedToastImage);
	}

	// Returns the user's toast
	Toast getToast() {
		return toast;
	}

	/**
	 * Toasts user's toast and changes the toast image based on toastiness scale
	 * 
	 * @param toastiness
	 *            The toastiness desired by the user
	 */
	void toast(int toastiness) {
		toast.toast(toastiness);
		if ((0 <= toastiness) && (toastiness <= 5)) {
			Image toast = new Image(getClass().getResource("images/toastlevel" + toastiness + ".png").toExternalForm());
			view.changeToastiness(toast);
		}
	}
}
