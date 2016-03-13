/**
 * Topping.java
 * Authors: Carolyn Ryan, Yuping Huang, Tegan Wilson
 * Date: Feb 29, 2016
 * 
 * Topping class to help GUI element implementation
 */
package toastGame;

import javafx.scene.image.Image;

class Topping {
	// Name and image instance variables
	private String name;
	private Image image;

	/**
	 * Instantiates topping object
	 * @param name			Name of topping
	 * @param imageFile		Image of topping
	 */
	Topping(String name, String imageFile) {
		// loads the Image object from the imageFile file under the same path as
		// the package
		this.image = new Image(getClass().getResource(imageFile).toExternalForm());
		this.name = name;
	}
	
	// Returns the name of topping in string form
	public String getName() {
		return name;
	}

	// Returns the image of topping
	public Image getImage() {
		return image;
	}
	
}
