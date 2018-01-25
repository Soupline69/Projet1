package controller;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.List;

import interfaces.CRUD;
import javafx.scene.Node;
import javafx.scene.control.TextInputControl;
import model.ClientDB;
import model.MeetingDB;
import model.Model;
import objects.Element;

public class Controller {
	private Model model;

	public Controller(Model model) {
		this.model = model;
		connect();
	}
	
	public boolean applyCU(CRUD db, Method method, List<Element> elements) {
		boolean hasError = checkFieldsIsRequired(elements);

		if(!hasError) {
			try {
				method.invoke(db, new Object[0]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		
		return hasError;
	}
	
	private boolean checkFieldsIsRequired(List<Element> elements) {
		boolean hasError = false;
		
		int i = 0;
		while(i < elements.size() && !hasError) {
			if(elements.get(i).isRequired()) {
				hasError = componentIsRequired(elements.get(i).getComponent());
			}
			
			i++;
		}
		
		return hasError;
	}
	
	private boolean componentIsRequired(Node component) {
		if(component instanceof TextInputControl) {
			return !isValid(((TextInputControl) component).getText());
		} else {
			return false;
		}
	}
		
	private boolean isValid(String text) {
		return text != null && !text.trim().isEmpty() && !("  /  /    ").equals(text) && !("  :  ").equals(text);
	}
	
	private void connect() {
		Connection dbConnect = model.getDbConnect();
		ClientDB.setConnection(dbConnect);
		MeetingDB.setConnection(dbConnect);
    }
	
	public void disconnect() {
		try {
			model.getDbConnect().close();
		} catch (Exception e) {}
	}
	
	public Model getModel() {
		return model;
	}

}