package panes;

import controller.Controller;
import javafx.scene.control.TextField;
import model.Client;

public class MyPaneUpdateClient extends MyPaneAddClient {

	public MyPaneUpdateClient(Client client, MyPaneMenu paneMenu, Controller controller) {
		super("Modifier", client.getId(), "update/Modification", paneMenu, controller);
		fillTextField(client);
	}
	
	private void fillTextField(Client client) {
		((TextField) elements.get(0).getComponent()).setText(client.getLastName());
		((TextField) elements.get(1).getComponent()).setText(client.getFirstName());
		((TextField) elements.get(2).getComponent()).setText(client.getAdress());
		((TextField) elements.get(3).getComponent()).setText(client.getPostal());
		((TextField) elements.get(4).getComponent()).setText(client.getCity());
		((TextField) elements.get(5).getComponent()).setText(client.getPhoneNumber());
	}
	
}