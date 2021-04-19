package Cartoon;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Cartoon {
	private Orca _orca;
	private Label _label;

	/**
	 * In my cartoon class I control the movement of my orca and setup the
	 * keyhandler for the keyboard clicks I first set up the timeline and made a new
	 * orca and added an event handler for the keyhandler and then created a label
	 * so that way later in the code I could use this label to show the x-value of
	 * the orca. I also set up the timeline in the same way that we learned in
	 * class, I dont think I need to expalin this.
	 * 
	 */

	public Cartoon(Pane pane, Label label) {
		this.setUpTimeline();
		_orca = new Orca(pane);
		pane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyHandler());
		pane.setFocusTraversable(true);
		_label = label;
	}

	public void setUpTimeline() {
		KeyFrame kf = new KeyFrame(Duration.millis(10), new ShapeHandler());
		Timeline timeline = new Timeline(kf);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	/**
	 * 
	 * This is my ShapeHandler and it takes the orca and moves it forward. The
	 * moveForward method is within the orca class. I also added that if the orca
	 * hits the x location 600, it will go back to where it started. the getXLoc and
	 * moveBackToStart methods are both within the Orca class. I also added that the
	 * label will set the text of the x location. this is a double and the setText
	 * wouldn't take a double so I had to write Double.toString so that it would
	 * work
	 *
	 */

	private class ShapeHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_orca.moveForward();
			if (_orca.getXLoc() >= 600) {
				_orca.moveBackToStart();
			}
			_label.setText(Double.toString(_orca.getXLoc()));
		}

	}

	/**
	 * 
	 * This is my KeyHandler and it handles when I press the up, down, and C key.
	 * When I press up, the orca will move up, this method is written in the orca
	 * class. This is the exact same thing for move down. I also added that if C is
	 * pressed the orca will change colors. The change color method is written in
	 * the orca class as well.
	 *
	 */

	private class KeyHandler implements EventHandler<KeyEvent> {
		@Override
		public void handle(KeyEvent e) {

			KeyCode keyPressed = e.getCode();
			if (keyPressed == KeyCode.UP) {
				_orca.moveUp();
			} else if (keyPressed == KeyCode.DOWN) {
				_orca.moveDown();
			} else if (keyPressed == KeyCode.C) {
				_orca.changeColor();
			}
			e.consume();
		}

	}

}