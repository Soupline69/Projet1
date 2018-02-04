package tables;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import panes.MyPaneMenu;

public class MyTableViewMeetingsClientList extends MyTableViewMeetingsList {

	public MyTableViewMeetingsClientList(String name, int id, MyPaneMenu paneMenu, Controller controller) {
		super(paneMenu, controller);
		setPlaceholder(new Label("Pas de données trouvées pour \"" + name + "\""));
		refresh(String.valueOf(id));
	}
	
	@Override
	public void refresh(String text) {
		datas = FXCollections.observableArrayList(controller.getModel().getClientMeetings(Integer.valueOf(text)));
		setItems(datas);
	}

}