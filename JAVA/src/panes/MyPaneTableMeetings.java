package panes; 

import buttons.MyButtonAddMeeting;
import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import objects.MyButtonMenu;
import objects.MyPaneTable;
import objects.MyTable;
import smartsearchs.SmartSearchDatePicker;

public class MyPaneTableMeetings extends MyPaneTable {

	public MyPaneTableMeetings(MyTable<?> table, boolean display, MyPaneMenu paneMenu, Controller controller) {
		super(table, 388, display, paneMenu, controller);
	}

	@Override
	public void createSmartSearch(Controller controller) {
		smartSearch = new SmartSearchDatePicker(table);
		
		((DatePicker) smartSearch.getSearch()).addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
		    public void handle(ActionEvent t) {
				((MyButtonAddMeeting) add).setDate(smartSearch.getText());
		    }
		});
	}

	@Override
	public MyButtonMenu getMyButtonAdd(Controller controller) {
		return new MyButtonAddMeeting("+.png", smartSearch.getText(), -1, paneMenu, controller);
	}

}