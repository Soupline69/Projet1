package tables;

import java.lang.reflect.Method;

import buttons.MyButtonUpdateMeeting;
import controller.Controller;
import javafx.collections.FXCollections;
import listeners.DeleteListener;
import model.Meeting;
import model.MeetingDB;
import objects.MyButton;
import objects.MyButtonMenu;
import objects.MyTable;
import panes.MyPaneMenu;

public class MyTableViewMeetingsList extends MyTable<Meeting> {

	public MyTableViewMeetingsList(MyPaneMenu paneMenu, Controller controller, int widthDescription, boolean display) {
		super(paneMenu, controller);
		
		try {
			addColumn("Date", "dateFormat", 150);
			if(display) addColumn("Heure", "time", 120);
			addColumn("Client", "client", 250);
			addColumn("Description", "description", widthDescription);
			addButtonColumn(MyTableViewMeetingsList.class.getMethod("getMyButtonUpdate", Meeting.class), MyButtonMenu.class);
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
	
	public MyButtonMenu getMyButtonUpdate(Meeting meeting) {
		return new MyButtonUpdateMeeting(meeting, paneMenu, controller);
	}
	
	public MyButton getMyButtonDelete(Meeting meeting) {
		return new MyButton("delete.png", new DeleteListener<Meeting>(new MeetingDB(meeting.getId()), datas, datas.indexOf(meeting)));
	}

}