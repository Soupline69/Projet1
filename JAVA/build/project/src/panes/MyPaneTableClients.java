package panes;

import buttons.MyButtonAddClient;
import controller.Controller;
import objects.MyButtonMenu;
import objects.MyPaneTable;
import smartsearchs.SmartSearchTextComponent;
import tables.MyTableViewClientsList;

public class MyPaneTableClients extends MyPaneTable {

	public MyPaneTableClients(MyPaneMenu paneMenu, Controller controller) {
		super(new MyTableViewClientsList(paneMenu, controller), 450, true, paneMenu, controller);
	}

	@Override
	public void createSmartSearch(Controller controller) {
		smartSearch = new SmartSearchTextComponent(table);
	}

	@Override
	public MyButtonMenu getMyButtonAdd(Controller controller) {
		return new MyButtonAddClient(paneMenu, controller);
	}

}