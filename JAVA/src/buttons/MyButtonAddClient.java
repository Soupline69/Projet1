package buttons;

import controller.Controller;
import javafx.scene.layout.Pane;
import objects.MyButtonMenu;
import panes.MyPaneAddClient;
import panes.MyPaneMenu;

public class MyButtonAddClient extends MyButtonMenu {

	public MyButtonAddClient(MyPaneMenu paneMenu, Controller controller) {
		super("+.png", paneMenu, controller);
	}

	@Override
	public Pane getPane() {
		return new MyPaneAddClient("Ajouter", 0, "create/Insertion", paneMenu, controller);
	}

}
