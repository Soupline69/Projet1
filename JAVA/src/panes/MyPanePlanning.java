package panes;

import java.time.LocalDate;

import controller.Controller;
import interfaces.GetPaneTableInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import objects.MyButton;
import objects.MyPane;
import objects.MyPaneTable;
import tables.MyTableViewMeetingsList;

public class MyPanePlanning extends MyPane implements GetPaneTableInterface {
	private MyPaneTable paneTable;

	public MyPanePlanning(MyPaneMenu paneMenu, Controller controller) {
		super("Planning");
		buildPane(paneMenu, controller);
	}
	
	private void buildPane(MyPaneMenu paneMenu, Controller controller) {
		buildButtons();
		
		paneTable = new MyPaneTableMeetings(new MyTableViewMeetingsList(paneMenu, controller), true, paneMenu, controller);
		paneTable.setMaxWidth(1100);
		setCenter(paneTable);
	}
	
	private void buildButtons() {
		MyButton left = new MyButton("left.png", new SetDateListener(-1));
		left.setPadding(new Insets(0, 0, 275, 0));
		setLeft(left);
		setAlignment(left, Pos.BOTTOM_CENTER);
		
		MyButton right = new MyButton("right.png", new SetDateListener(1));
		right.setPadding(new Insets(0, 0, 275, 0));
		setRight(right);
		setAlignment(right, Pos.BOTTOM_CENTER);
	}
	
	private class SetDateListener implements EventHandler<ActionEvent> {
		private int toAdd;
		
		public SetDateListener(int toAdd) {
			this.toAdd = toAdd;
		}
		
		@Override
		public void handle(ActionEvent e) {
			LocalDate date = ((DatePicker) paneTable.getSmartSearch().getSearch()).getValue().plusDays(toAdd);
			paneTable.getSmartSearch().setText(date.toString());
		}
	}

	@Override
	public MyPaneTable getPaneTable() {
		return paneTable;
	}
	
}