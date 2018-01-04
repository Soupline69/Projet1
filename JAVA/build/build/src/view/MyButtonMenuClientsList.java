package view;

import controller.Controller;
import javafx.scene.layout.Pane;
import objects.MyButtonMenu;

public class MyButtonMenuClientsList extends MyButtonMenu {
	
	protected MyButtonMenuClientsList(MyPaneMenu paneMenu, Controller controller) {
		super("client.png", paneMenu, controller);
	}
	
	@Override
	public Pane getPane() {
		return new MyPaneClientsList(paneMenu, controller);
	}

}