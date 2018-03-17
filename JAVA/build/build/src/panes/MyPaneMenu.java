package panes;

import buttons.MyButtonMenuClientsList;
import buttons.MyButtonMenuPlanning;
import controller.Controller;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import objects.MyPane;

public class MyPaneMenu extends BorderPane {
	private HBox menuContainer = new HBox(100);
	private Pane previousContent;
	
	public MyPaneMenu(Controller controller) {
		buildMenu(controller);
		setCenter(new MyPane());
	}
	
	private void buildMenu(Controller controller) {
		menuContainer.getChildren().addAll(new MyButtonMenuClientsList(this, controller), new MyButtonMenuPlanning(this, controller));
		menuContainer.getStyleClass().add("menuContainer");
		setTop(menuContainer);
	}
	
	public Pane getContentContainer() {
		return (Pane) getCenter();
	}
	
	public Pane getPreviousContent() {
		return previousContent;
	}
	
	public void setContentContainer(Pane contentContainer) {		
		previousContent = getContentContainer();
		setCenter(contentContainer);
	}

}