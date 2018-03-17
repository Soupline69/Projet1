package panes;

import controller.Controller;
import objects.MyPanePrevious;
import objects.MyPaneTable;
import tables.MyTableViewMeetingsClientList;

public class MyPaneInfoClient extends MyPanePrevious {
	
	public MyPaneInfoClient(String clientName, int clientId, MyPaneMenu paneMenu, Controller controller) {
		super("Informations de " + clientName, paneMenu, controller);
		MyPaneTable paneTable = new MyPaneTableMeetings(new MyTableViewMeetingsClientList(clientName, clientId, paneMenu, controller), false, paneMenu, controller);
		paneTable.setStyle("-fx-padding : 50px 0px 0px -50px;");
		paneTable.setMaxWidth(1100);
		setCenter(paneTable);
	}

}