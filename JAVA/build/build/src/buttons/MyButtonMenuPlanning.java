package buttons;

import controller.Controller;
import javafx.scene.layout.Pane;
import objects.MyButtonMenu;
import panes.MyPaneMenu;
import panes.MyPanePlanning;

public class MyButtonMenuPlanning extends MyButtonMenu {

	public MyButtonMenuPlanning(MyPaneMenu paneMenu, Controller controller) {
		super("planning.png", paneMenu, controller);
	}
	
	@Override
	public Pane getPane() {
		return new MyPanePlanning(paneMenu, controller);
	}
	
}