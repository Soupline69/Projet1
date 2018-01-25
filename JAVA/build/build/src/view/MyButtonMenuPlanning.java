package view;

import controller.Controller;
import javafx.scene.layout.Pane;
import objects.MyButtonMenu;

public class MyButtonMenuPlanning extends MyButtonMenu {

	protected MyButtonMenuPlanning(MyPaneMenu paneMenu, Controller controller) {
		super("planning.png", paneMenu, controller);
	}
	
	@Override
	public Pane getPane() {
		return new MyPanePlanning(paneMenu, controller);
	}
	
}