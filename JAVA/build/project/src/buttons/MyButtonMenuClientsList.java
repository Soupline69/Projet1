package buttons;

import controller.Controller;
import javafx.scene.layout.Pane;
import objects.MyButtonMenu;
import panes.MyPaneClientsList;
import panes.MyPaneMenu;

public class MyButtonMenuClientsList extends MyButtonMenu {
	
	public MyButtonMenuClientsList(MyPaneMenu paneMenu, Controller controller) {
		super("client.png", paneMenu, controller);
	}
	
	@Override
	public Pane getPane() {
		return new MyPaneClientsList(paneMenu, controller);
	}

}