package objects;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class MyButton extends Button {
	
	public MyButton(String icon, EventHandler<ActionEvent> buttonAction) {
		super();
		Image image = new Image(Thread.currentThread().getContextClassLoader().getResourceAsStream(icon));
		setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		setMinSize(image.getWidth(), image.getHeight());
		setOnAction(buttonAction);
	}

}