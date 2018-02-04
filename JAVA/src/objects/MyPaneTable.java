package objects;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import panes.MyPaneMenu;
import smartsearchs.SmartSearch;

public abstract class MyPaneTable extends MyPane {
	protected MyButtonMenu add;
	protected SmartSearch smartSearch;
	protected MyTable<?> table;
	protected MyPaneMenu paneMenu;
	
	public MyPaneTable(MyTable<?> table, int space, boolean display, MyPaneMenu paneMenu, Controller controller) {
		setPadding(new Insets(55, 0, 0, 0));
		this.table = table;
		this.paneMenu = paneMenu;
		
		if(display) {
			createSmartSearch(controller);
			add = getMyButtonAdd(controller);
			HBox box = new HBox(space);
		    box.getStyleClass().add("smartBox");
		    box.getChildren().addAll(add, smartSearch.getSearch());
			setTop(box);
		}
		
		setCenter(table);
	}
	
	public SmartSearch getSmartSearch() {
		return smartSearch;
	}
	
	public MyTable<?> getTable() {
		return table;
	}
	
	protected abstract void createSmartSearch(Controller controller);
	protected abstract MyButtonMenu getMyButtonAdd(Controller controller);

}