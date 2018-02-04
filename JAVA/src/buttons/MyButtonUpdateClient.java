package buttons;

import controller.Controller;
import javafx.scene.layout.Pane;
import model.Client;
import objects.MyButtonMenu;
import panes.MyPaneMenu;
import panes.MyPaneUpdateClient;

public class MyButtonUpdateClient extends MyButtonMenu {
	private Client client;
	
	public MyButtonUpdateClient(Client client, MyPaneMenu paneMenu, Controller controller) {
		super("update.png", paneMenu, controller);
		this.client = client;
	}

	@Override
	public Pane getPane() {
		return new MyPaneUpdateClient(client, paneMenu, controller);
	}

}
