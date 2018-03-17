package panes;

import java.util.Arrays;

import controller.Controller;
import interfaces.CRUD;
import javafx.scene.control.TextField;
import model.ClientDB;
import objects.Element;
import objects.MyMaskTextField;
import objects.MyPaneAdd;
import objects.MyTextField;

public class MyPaneAddClient extends MyPaneAdd {
	
	public MyPaneAddClient(String title, int id, String method, MyPaneMenu paneMenu, Controller controller) {
		super(title + " un client", id, method, paneMenu, controller);
	}

	@Override
	protected void init() {
		elements = Arrays.asList(
			new Element("Nom : ", new MyTextField(50), true),
			new Element("Prenom : ", new MyTextField(50), true),
			new Element("Adresse : ", new MyTextField(100), false),
			new Element("Code postal : ", new MyMaskTextField("9999"), false),
			new Element("Ville : ", new MyTextField(50), false),
			new Element("Téléphone : ", new MyMaskTextField("9999/99.99.99"), false)
		);
	}

	@Override
	protected CRUD get(int id) {
		String lastName = ((TextField) elements.get(0).getComponent()).getText().trim();
		String firstName = ((TextField) elements.get(1).getComponent()).getText().trim();
		String adress = ((TextField) elements.get(2).getComponent()).getText();
		String postal = ((TextField) elements.get(3).getComponent()).getText();
		String city = ((TextField) elements.get(4).getComponent()).getText();
		String phoneNumber = ((TextField) elements.get(5).getComponent()).getText();
		
		return new ClientDB(id, lastName, firstName, adress, postal, city, phoneNumber);
	}
	
}