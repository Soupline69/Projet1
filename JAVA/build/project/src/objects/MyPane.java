package objects;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MyPane extends BorderPane {

	public MyPane() {
		super();
		init();
	}
	
	public MyPane(String title) {
		super();
		init();
		addTitle(title);
	}
	
	private void addTitle(String title) {
		Label label = new Label(title);
		label.getStyleClass().add("labelTitle");
		setTop(label);
		setAlignment(label, Pos.CENTER);
	}

	private void init() {
		getStyleClass().add("contentsContainer");
	}

}