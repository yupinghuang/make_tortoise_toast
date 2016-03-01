package toastGame;

import javafx.scene.image.Image;

class Topping {
	private String name;
	private Image image;
	//TODO implement default size for a given topping

	Topping(String name, String imageFile) {
		// load the Image object from the imageFile file under the same path as
		// the package
		this.image = new Image(getClass().getResource(imageFile).toExternalForm());
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Image getImage() {
		return image;
	}
}
