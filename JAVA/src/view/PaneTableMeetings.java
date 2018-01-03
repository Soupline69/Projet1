package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import objects.MyPaneAdd;
import objects.MyPaneTable;
import objects.MyTable;
import smartsearchs.SmartSearchDatePicker;

public class PaneTableMeetings extends MyPaneTable {

	public PaneTableMeetings(MyTable<?> table, boolean display, MyPaneMenu paneMenu, Controller controller) {
		super(table, 275, display, paneMenu, controller);
	}

	@Override
	public void createSmartSearch(Controller controller) {
		smartSearch = new SmartSearchDatePicker(table);
		
		((DatePicker) smartSearch.getSearch()).addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent t) {
				add.setPane(createPaneAdd(controller));
		    }
		});
	}

	@Override
	public MyPaneAdd createPaneAdd(Controller controller) {
		return new MyPaneAddMeeting("Ajouter", 0, "create/Insertion", smartSearch.getText(), -1, controller);
	}

}