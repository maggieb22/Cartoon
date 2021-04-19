package Cartoon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Here is my App class where I made a paneorganizer and a scene and then got
 * the scene to show up and then I named the stage Cartoon.
 */

public class App extends Application {

	@Override
	public void start(Stage stage) {

		stage.setTitle("Cartoon");
		stage.show();
		PaneOrganizer organizer = new PaneOrganizer();
		Scene scene = new Scene(organizer.getRoot());
		stage.setScene(scene);
	}

	/*
	 * Here is the mainline! No need to change this.
	 */
	public static void main(String[] argv) {
		// launch is a method inherited from Application
		launch(argv);
	}
}
