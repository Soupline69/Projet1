package panes;

import controller.Controller;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Meeting;

public class MyPaneUpdateMeeting extends MyPaneAddMeeting {

	public MyPaneUpdateMeeting(Meeting meeting, MyPaneMenu paneMenu, Controller controller) {
		super("Modifier", meeting.getId(), "update/Modification", meeting.getDate(), meeting.getTime(), meeting.getFkClient(), paneMenu, controller);
		fillTextField(meeting);
	}
	
	private void fillTextField(Meeting meeting) {
		((TextField) elements.get(2).getComponent()).setText(meeting.getClient());
		((TextArea) elements.get(3).getComponent()).setText(meeting.getDescription().replaceAll(" ; ", "\n"));
	}

}