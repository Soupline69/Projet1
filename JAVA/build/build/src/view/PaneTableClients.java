package view;

import controller.Controller;
import objects.MyPaneAdd;
import objects.MyPaneTable;
import smartsearchs.SmartSearchTextComponent;

public class PaneTableClients extends MyPaneTable {

	public PaneTableClients(MyPaneMenu paneMenu, Controller controller) {
		super(new MyTableViewClientsList(paneMenu, controller), 450, true, paneMenu, controller); // REGLER ICI 
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