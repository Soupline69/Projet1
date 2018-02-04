package buttons;

import java.util.Calendar;
import java.util.GregorianCalendar;

import controller.Controller;
import javafx.scene.layout.Pane;
import objects.MyButtonMenu;
import panes.MyPaneAddMeeting;
import panes.MyPaneMenu;

public class MyButtonAddMeeting extends MyButtonMenu {
	private String date;
	private int id;

	public MyButtonAddMeeting(String icon, String date, int id, MyPaneMenu paneMenu, Controller controller) {
		super(icon, paneMenu, controller);
		this.date = date;
		this.id = id;
	}

	@Override
	public Pane getPane() {
		Calendar calendar = GregorianCalendar.getInstance();
		String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)).length() == 1 ? "0" + calendar.get(Calendar.HOUR_OF_DAY) : "" + calendar.get(Calendar.HOUR_OF_DAY);
		String minute =  String.valueOf(calendar.get(Calendar.MINUTE)).length() == 1 ? "0" + calendar.get(Calendar.MINUTE) : "" + calendar.get(Calendar.MINUTE);
		String time = hour + ":" + minute;

		return new MyPaneAddMeeting("Ajouter", 0, "create/Insertion", date, time, id, paneMenu, controller);
	}
	
	public void setDate(String date) {
		this.date = date;
	}

}
