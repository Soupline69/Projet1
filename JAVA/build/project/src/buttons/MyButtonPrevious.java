package buttons;

import controller.Controller;
import javafx.scene.layout.Pane;
import objects.MyButtonMenu;
import panes.MyPaneMenu;

public class MyButtonPrevious extends MyButtonMenu {

	public MyButtonPrevious(MyPaneMenu paneMenu, Controller controller) {
		super("previous.png", paneMenu, controller);
	}
	
	@Override
	public Pane getPane() {
		return paneMenu.getPreviousContent();
	}

}
