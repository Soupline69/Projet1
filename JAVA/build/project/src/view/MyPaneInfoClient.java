package view;

import controller.Controller;
import objects.MyPane;
import objects.MyPaneTable;

public class MyPaneInfoClient extends MyPane {
	
	public MyPaneInfoClient(String clientName, int clientId, MyPaneMenu paneMenu, Controller controller) {
		super("Informations de " + clientName);
		MyPaneTable paneTable = new PaneTableMeetings(new MyTableViewMeetingsClientList(clientName, clientId, paneMenu, controller), false, paneMenu, controller);
		paneTable.setMaxWidth(900);
		setCenter(paneTable);
	}

}