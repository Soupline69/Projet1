package panes;

import controller.Controller;
import interfaces.GetPaneTableInterface;
import objects.MyPane;
import objects.MyPaneTable;

public class MyPaneClientsList extends MyPane implements GetPaneTableInterface {
	private MyPaneTable paneTable;
	
	public MyPaneClientsList(MyPaneMenu paneMenu, Controller controller) {
		super("Liste des clients");
		paneTable = new MyPaneTableClients(paneMenu, controller);
		paneTable.setMaxWidth(1270);
		setCenter(paneTable);
	}

	@Override
	public MyPaneTable getPaneTable() {
		return paneTable;
	}
	
}