package objects;

import controller.Controller;
import interfaces.GetPaneInterface;
import javafx.scene.layout.Pane;
import listeners.ChangeContainerViewListener;
import panes.MyPaneMenu;

public abstract class MyButtonMenu extends MyButton implements GetPaneInterface {
	protected MyPaneMenu paneMenu;
	protected Controller controller;
	
	public MyButtonMenu(String icon, MyPaneMenu paneMenu, Controller controller) {
		super(icon, new ChangeContainerViewListener(paneMenu));
		this.paneMenu = paneMenu;
		this.controller = controller;
	}
	
	@Override
	public abstract Pane getPane();

}