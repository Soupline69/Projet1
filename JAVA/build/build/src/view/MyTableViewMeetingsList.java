package view;

import java.lang.reflect.Method;

import controller.Controller;
import javafx.collections.FXCollections;
import listeners.DeleteListener;
import model.Meeting;
import model.MeetingDB;
import objects.MyButton;
import objects.MyButtonPane;
import objects.MyTable;

public class MyTableViewMeetingsList extends MyTable<Meeting> {

	public MyTableViewMeetingsList(MyPaneMenu paneMenu, Controller controller) {
		super(paneMenu, controller);
		
		try {
			addColumn("Date", "date", 150);
			addColumn("Heure", "time", 120);
			addColumn("Client", "client", 250);
			addColumn("Description", "description", 441);
			addButtonColumn(MyTableViewMeetingsList.class.getMethod("getMyButtonUpdate", Meeting.class), MyButtonPane.class);
			addButtonColumn(MyTableViewMeetingsList.class.getMethod("getMyButtonDelete", Meeting.class), MyButton.class);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void refresh(String text) {
		super.refresh(text);
		datas = FXCollections.observableArrayList(controller.getModel().getMeetings(text));
		setItems(datas);
	}

	@Override
	public Object updateConcreteItem(Method method, Meeting meeting) throws Exception {
		return method.invoke(this, meeting);
	}
	
	public MyButtonPane getMyButtonUpdate(Meeting meeting) {
		return new MyButtonPane("update.png", new MyPaneUpdateMeeting(meeting, controller), paneMenu);
	}
	
	public MyButton getMyButtonDelete(Meeting meeting) {
		return new MyButton("delete.png", new DeleteListener<Meeting>(new MeetingDB(meeting.getId()), datas, datas.indexOf(meeting)));
	}

}