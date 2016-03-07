package toastGame;

import javafx.scene.image.Image;

/**
 * The model that keeps track of the current toast displayed on the view. Should
 * be observed by the view.
 * 
 * @author Yuping Huang, Tegan Wilson, and Carolyn Ryan
 *
 */
class ToastModel {
	private Toast toast;
	private GameController game;
	private ViewInitializer view;

	ToastModel(GameController game, ViewInitializer view) {
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
		// TODO implement view version of toastiness changes 
		toast.toast(toastiness);
		if ((0<=toastiness) || (toastiness <= 3)) {
			Image toast = new Image(getClass().getResource("toastlevel"+toastiness+".png").toExternalForm());
			view.changeToastiness(toast);

		}
	}
}
