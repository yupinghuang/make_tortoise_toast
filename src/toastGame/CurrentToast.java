package toastGame;

import javafx.scene.image.Image;

/**
 * The model that keeps track of the current toast displayed on the view. Should
 * be observed by the view.
 * 
 * @author Yuping Huang
 *
 */
class CurrentToast {
	private Toast toast;
	private GameController game;
	private ViewInitializer view;

	CurrentToast(GameController game, ViewInitializer view) {
		this.toast = new Toast();
		this.game = game;
		this.view = view;
	}

	void addTopping(Topping topping) {
		System.out.println("Adding " + topping.getName() + " to toast!");
		toast.addTopping(topping);
		Image addedToastImage = topping.getImage();
		view.addImageOnToast(addedToastImage);
	}
	
	Toast getToast() {
		return toast;
	}
	
	void toast(int toastiness) {
		System.out.println("CurrentToast.toast() not implemented yet");
		toast.toast(toastiness);
	}
}
