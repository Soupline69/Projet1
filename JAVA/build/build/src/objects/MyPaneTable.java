package objects;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import smartsearchs.SmartSearch;
import view.MyPaneMenu;

public abstract class MyPaneTable extends MyPane {
	protected MyButtonPane add;
	protected SmartSearch smartSearch;
	protected MyTable<?> table;
	
	public MyPaneTable(MyTable<?> table, int space, boolean display, MyPaneMenu paneMenu, Controller controller) {
		setPadding(new Insets(55, 0, 0, 0));
		this.table = table;
		
		if(display) {
			createSmartSearch(controller);
			add = new MyButtonPane("+.png", createPaneAdd(controller), paneMenu);
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
	
	protected abstract void createSmartSearch(Controller controller);
	protected abstract MyPaneAdd createPaneAdd(Controller controller);

}