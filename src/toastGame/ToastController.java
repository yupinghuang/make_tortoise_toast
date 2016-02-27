package toastGame;

public class ToastController {
	private String toppingOne;
	private String toppingTwo;
	private String toppingThree;
	private String toppingFour;
	private String toppingFive;
	private String toppingSix;
	
	public ToastController(String toppingOne, String toppingTwo, String toppingThree, String toppingFour, String toppingFive, String toppingSix) {
		this.toppingOne = toppingOne;
		this.toppingTwo = toppingTwo;
		this.toppingThree = toppingThree;
		this.toppingFour = toppingFour;
		this.toppingFive = toppingFive;
		this.toppingSix = toppingSix;
	}
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
	public void add(String topping){
		//myToast.add(topping);
		System.out.println("Adding "+topping);
	}
	
	public void submitToast() {
		
	}
}
