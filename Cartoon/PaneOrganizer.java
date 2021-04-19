package Cartoon;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PaneOrganizer {
	private BorderPane _root;
	private VBox _labelPane;
	private VBox _quit;
	private VBox _night;
	private HBox _day;
	private HBox _weird;
	private Label _myLabel;

	/**
	 * In my paneorganizer class i made a new borderpane, gave it a color and then
	 * gave it a size I also created all of my buttons and labels within
	 * paneorganizer and set it to the center
	 */
	public PaneOrganizer() {
		_root = new BorderPane();
		_root.setStyle("-fx-background-color: aqua;");
		Pane myPane = new Pane();
		myPane.setPrefSize(Constants.RECT_WIDTH, Constants.RECT_HEIGHT);
		this.createLabelPane();
		this.createButton();
		this.createNight();
		this.createDay();
		this.createWeird();
		new Cartoon(myPane, _myLabel);
		_root.setCenter(myPane);
	}

	public BorderPane getRoot() {
		return _root;
	}

	/**
	 * This made my label pane on the bottom so that way it could show up with the
	 * changing x value
	 */
	private void createLabelPane() {
		_labelPane = new VBox();
		_myLabel = new Label();
		_labelPane.getChildren().addAll(_myLabel);
		_root.setBottom(_labelPane);
		_labelPane.setAlignment(Pos.CENTER);
		_labelPane.setStyle("-fx-background-color: AQUAMARINE");
	}

	/**
	 * Here is where I created my quit button and positioned it and made it so when
	 * I clicked it, it would use a Handler which I define later. For all of my
	 * buttons I basically did the same thing (Quit, Night, Day, Weird), so I'm not
	 * going to waste your time by rewriting this exact same thing again.
	 */
	private void createButton() {
		_quit = new VBox();
		Button b1 = new Button("Quit");
		_quit.getChildren().addAll(b1);
		_root.setRight(_quit);
		_quit.setAlignment(Pos.BOTTOM_RIGHT);
		_quit.setStyle("-fx-background-color: AQUA");
		b1.setOnAction(new ClickHandler());
	}

	private void createNight() {
		_night = new VBox();
		Button b2 = new Button("Night Mode!!");
		_night.getChildren().addAll(b2);
		_root.setTop(_night);
		_night.setAlignment(Pos.TOP_LEFT);
		b2.setOnAction(new NightHandler());

	}

	private void createDay() {
		_day = new HBox();
		Button b3 = new Button("Day Mode!!");
		_night.getChildren().addAll(b3);
		_root.setLeft(_day);
		b3.setOnAction(new DayHandler());
	}

	private void createWeird() {
		_weird = new HBox();
		Button b4 = new Button("Weirddddd Mode!!");
		_night.getChildren().addAll(b4);
		_root.setLeft(_weird);
		b4.setOnAction(new WeirdHandler());
	}

	/**
	 * For my Handlers I did similar things, for the clickhandler, when exit is
	 * clicked the platform will exit. For night, day, and weird handler, when the
	 * buttons are clicked, I change the color of all parts of the background. This
	 * is repeated for all of the different handlers.
	 */

	private class ClickHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Platform.exit();
		}
	}

	private class NightHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_root.setStyle("-fx-background-color: NAVY");
			_labelPane.setStyle("-fx-background-color: NAVY");
			_quit.setStyle("-fx-background-color: NAVY");
			_night.setStyle("-fx-background-color: NAVY");
			_day.setStyle("-fx-background-color: NAVY");
			_myLabel.setStyle("-fx-background-color: WHITE");
		}
	}

	private class DayHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_root.setStyle("-fx-background-color: AQUA");
			_labelPane.setStyle("-fx-background-color: AQUA");
			_quit.setStyle("-fx-background-color: AQUA");
			_night.setStyle("-fx-background-color: AQUA");
			_day.setStyle("-fx-background-color: AQUA");
			_myLabel.setStyle("-fx-background-color: AQUA");
		}
	}

	private class WeirdHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			_root.setStyle("-fx-background-color: SEAGREEN");
			_labelPane.setStyle("-fx-background-color: SIENNA");
			_quit.setStyle("-fx-background-color: SKYBLUE");
			_night.setStyle("-fx-background-color: SEAGREEN");
			_day.setStyle("-fx-background-color: VIOLET");
			_myLabel.setStyle("-fx-background-color: YELLOWGREEN");

		}
	}

}