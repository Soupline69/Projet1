package view;

import controller.Controller;
import objects.MyPane;

public class MyPaneClientsList extends MyPane {
	
	public MyPaneClientsList(MyPaneMenu paneMenu, Controller controller) {
		super("Liste des clients");
		setCenter(new PaneTableClients(paneMenu, controller));
	}
	
}