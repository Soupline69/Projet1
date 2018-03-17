package listeners;

import interfaces.GetPaneInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import panes.MyPaneMenu;

public class ChangeContainerViewListener implements EventHandler<ActionEvent> {
	private MyPaneMenu paneMenu;
	
	public ChangeContainerViewListener(MyPaneMenu paneMenu) {
		this.paneMenu = paneMenu;
	}
	
	@Override
	public void handle(ActionEvent e) {
		paneMenu.setContentContainer(((GetPaneInterface) e.getSource()).getPane());
	}
	
}