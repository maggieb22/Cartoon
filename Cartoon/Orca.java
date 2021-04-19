package Cartoon;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;

public class Orca {
	private Ellipse _body;
	private Arc _tail;
	private Arc _dorsal;
	private Arc _fin;
	private Ellipse _spot;

	/**
	 * 
	 * This is where I create the shapes for my orca, set their sizes and set their
	 * position and then add them to the pane. Thats it lol
	 */
	public Orca(Pane pane) {
		_body = new Ellipse(Constants.BODY_X, Constants.BODY_Y, Constants.BODY_RADIUSX, Constants.BODY_RADIUSY);

		_tail = new Arc(Constants.TAIL_X, Constants.TAIL_Y, Constants.TAIL_RADIUSX, Constants.TAIL_RADIUSY,
				Constants.TAIL_ANGLE, Constants.TAIL_LENGTH);
		_dorsal = new Arc(Constants.DORSAL_X, Constants.DORSAL_Y, Constants.DORSAL_RADIUSX, Constants.DORSAL_RADIUSY,
				Constants.DORSAL_ANGLE, Constants.DORSAL_LENGTH);
		_fin = new Arc(Constants.FIN_X, Constants.FIN_Y, Constants.FIN_RADIUSX, Constants.FIN_RADIUSY,
				Constants.FIN_ANGLE, Constants.FIN_LENGTH);
		_spot = new Ellipse(Constants.SPOT_X, Constants.SPOT_Y, Constants.SPOT_RADIUSX, Constants.SPOT_RADIUSY);
		_spot.setFill(Color.WHITE);
		pane.getChildren().addAll(_body, _tail, _dorsal, _fin, _spot);
	}

	/**
	 * This is the method that translates the different parts of the orca up. To
	 * move it up, I get the position where the orca was before and then I subtract
	 * a number to it to move it up.
	 */
	public void moveUp() {
		_body.setTranslateY(_body.getTranslateY() - Constants.MOVE);
		_tail.setTranslateY(_tail.getTranslateY() - Constants.MOVE);
		_dorsal.setTranslateY(_dorsal.getTranslateY() - Constants.MOVE);
		_fin.setTranslateY(_fin.getTranslateY() - Constants.MOVE);
		_spot.setTranslateY(_spot.getTranslateY() - Constants.MOVE);

	}

	/**
	 * This is the method that translates the different parts of the orca down. To
	 * move it down I take the orca's position and then add a constant to move it
	 * down
	 */
	public void moveDown() {
		_body.setTranslateY(_body.getTranslateY() + Constants.MOVE);
		_tail.setTranslateY(_tail.getTranslateY() + Constants.MOVE);
		_dorsal.setTranslateY(_dorsal.getTranslateY() + Constants.MOVE);
		_fin.setTranslateY(_fin.getTranslateY() + Constants.MOVE);
		_spot.setTranslateY(_spot.getTranslateY() + Constants.MOVE);

	}

	/**
	 * To move the orca, I do the same thing as before. I take where it is and then
	 * I add a constant.
	 */
	public void moveForward() {
		_body.setTranslateX(_body.getTranslateX() + Constants.FORWARD);
		_tail.setTranslateX(_tail.getTranslateX() + Constants.FORWARD);
		_dorsal.setTranslateX(_dorsal.getTranslateX() + Constants.FORWARD);
		_fin.setTranslateX(_fin.getTranslateX() + Constants.FORWARD);
		_spot.setTranslateX(_spot.getTranslateX() + Constants.FORWARD);
	}

	/**
	 * This method is what I use to tell when the orca has hit the end of the
	 * screen. It just returns the value that the orca is at. I use this method in
	 * the cartoon class
	 */
	public double getXLoc() {
		return _body.getTranslateX();
	}

	/**
	 * This method is how I move the orca back to the other side of the screen when
	 * it hits the end. When it hits 600, I move the orca back to x=0 which is a
	 * constant
	 */
	public void moveBackToStart() {
		_body.setTranslateX(Constants.START);
		_tail.setTranslateX(Constants.START);
		_dorsal.setTranslateX(Constants.START);
		_fin.setTranslateX(Constants.START);
		_spot.setTranslateX(Constants.START);
	}

	/**
	 * This is the method that I use to change the color of the orca when I press
	 * the C button. I decided that I wanted every part of the orca to change colors
	 * except for the spot cause I wanted that to stay white. Other than that, there
	 * isn't anything to explain here.
	 */
	public void changeColor() {
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		Color myColor = Color.rgb(red, green, blue);
		_body.setFill(myColor);
		_tail.setFill(myColor);
		_dorsal.setFill(myColor);
		_fin.setFill(myColor);
	}

}
