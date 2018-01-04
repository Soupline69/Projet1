package view;

import controller.Controller;
import objects.MyPaneAdd;
import objects.MyPaneTable;
import smartsearchs.SmartSearchTextComponent;

public class PaneTableClients extends MyPaneTable {

	public PaneTableClients(MyPaneMenu paneMenu, Controller controller) {
		super(new MyTableViewClientsList(paneMenu, controller), 340, true, paneMenu, controller);
	}

	@Override
	public void createSmartSearch(Controller controller) {
		smartSearch = new SmartSearchTextComponent(table);
	}

	@Override
	public MyPaneAdd createPaneAdd(Controller controller) {
		return new MyPaneAddClient("Ajouter", 0, "create/Insertion", controller);
	}

}