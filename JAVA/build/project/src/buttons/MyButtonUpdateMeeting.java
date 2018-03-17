package buttons;

import controller.Controller;
import javafx.scene.layout.Pane;
import model.Meeting;
import objects.MyButtonMenu;
import panes.MyPaneMenu;
import panes.MyPaneUpdateMeeting;

public class MyButtonUpdateMeeting extends MyButtonMenu {
	private Meeting meeting;

	public MyButtonUpdateMeeting(Meeting meeting, MyPaneMenu paneMenu, Controller controller) {
		super("update.png", paneMenu, controller);
		this.meeting = meeting;
	}

	@Override
	public Pane getPane() {
		return new MyPaneUpdateMeeting(meeting, paneMenu, controller);
	}

}
