package objects;

import interfaces.GetPaneInterface;
import javafx.scene.layout.Pane;
import listeners.ChangeContainerViewListener;
import panes.MyPaneMenu;

public class MyButtonPane extends MyButton implements GetPaneInterface {
	private Pane pane;

	public MyButtonPane(String icon, Pane pane, MyPaneMenu paneMenu) {
		super(icon, new ChangeContainerViewListener(paneMenu));
		this.pane = pane;
	}
	
	public void setPane(Pane pane) {
		this.pane = pane;
	}
	
	@Override
	public Pane getPane() {
		return pane;
	}

}