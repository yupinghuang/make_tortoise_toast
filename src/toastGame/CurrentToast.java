package toastGame;

/**
 * The model that keeps track of the current toast displayed on the view. Should
 * be observed by the view.
 * 
 * @author Yuping Huang
 *
 */
class CurrentToast {
	private Toast toast;

	CurrentToast() {
		this.toast = new Toast();
	}

	void addTopping(Topping topping) {
		toast.addTopping(topping);
		System.out.println("Adding " + topping.getName() + " to toast!");
	}
	
	Toast getToast() {
		return toast;
	}
	
	void toast(int toastiness) {
		System.out.println("CurrentToast.toast() not implemented yet");
	}

}
