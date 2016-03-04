package toastGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class testImage extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane page = new StackPane();
		Scene scene = new Scene(page);
		Image image = new Image(getClass().getResource("toast.png").toExternalForm());
		Circle circle = new Circle(40,Paint.valueOf("red"));
		ImageView imageview= new ImageView();
		imageview.setImage(image);
		page.getChildren().add(imageview);
		page.getChildren().add(circle);
		primaryStage.setScene(scene);
		primaryStage.setTitle("FXML is Simple");
		primaryStage.show();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Application.launch(testImage.class, (java.lang.String[]) null);
	}

}
