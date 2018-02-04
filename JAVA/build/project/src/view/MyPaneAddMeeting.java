package view;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import controller.Controller;
import interfaces.CRUD;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.ClientDB;
import model.MeetingDB;
import objects.Element;
import objects.MyMaskTextField;
import objects.MyPaneAdd;
import objects.MyTextArea;
import objects.MyTextField;

public class MyPaneAddMeeting extends MyPaneAdd {
	private int fkClient;

	public MyPaneAddMeeting(String title, int id, String method, String date, String time, int fkClient, Controller controller) {
		super(title + " un rendez-vous", id, method, controller);
		this.fkClient = fkClient;
		fillTextField(date, time);
	}
	
	protected void fillTextField(String date, String time) {
		((TextField) elements.get(0).getComponent()).setText(date);
		((TextField) elements.get(1).getComponent()).setText(time);
		
		if(fkClient > -1) {
			ClientDB client = new ClientDB(fkClient);
			client.read();
			((TextField) elements.get(2).getComponent()).setText(client.getName());
			((TextField) elements.get(2).getComponent()).setEditable(false);
		}
	}

	@Override
	protected void init() {
		elements = Arrays.asList(
			new Element("Date : ", new MyMaskTextField("39/19/9999"), true),
			new Element("Heure : ", new MyMaskTextField("29:69"), true),
			new Element("Client : ", new MyTextField(50), true),
			new Element("Description : ", new MyTextArea(250), false)
		);
	}
	
	@Override
	protected CRUD get(int id) {
		String date = ((TextField) elements.get(0).getComponent()).getText().trim();
		String time = ((TextField) elements.get(1).getComponent()).getText().trim();
		String client = ((TextField) elements.get(2).getComponent()).getText().trim();
		String description = ((TextArea) elements.get(3).getComponent()).getText().replaceAll("\n", " ; ");
	
		return new MeetingDB(id, date, time, client, description, fkClient);
	}
	
}