package buttons;

import controller.Controller;
import javafx.scene.layout.Pane;
import model.Client;
import objects.MyButtonMenu;
import panes.MyPaneInfoClient;
import panes.MyPaneMenu;

public class MyButtonInfoClient extends MyButtonMenu {
	private Client client;
	
	public MyButtonInfoClient(Client client, MyPaneMenu paneMenu, Controller controller) {
		super("folder.png", paneMenu, controller);
		this.client = client;
	}

	@Override
	public Pane getPane() {
		return new MyPaneInfoClient(client.getName(), client.getId(), paneMenu, controller);
	}

}