package objects;

import buttons.MyButtonPrevious;
import controller.Controller;
import javafx.scene.layout.VBox;
import panes.MyPaneMenu;

public class MyPanePrevious extends MyPane {
	
	public MyPanePrevious(String title, MyPaneMenu paneMenu, Controller controller) {
		super(title);
		
		VBox box = new VBox();
		MyButtonMenu previous = new MyButtonPrevious(paneMenu, controller);
		box.getChildren().add(previous);
		box.setStyle("-fx-padding : -50px 0px 0px 30px;");
		
		setLeft(box);
	}

}
