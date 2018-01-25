package smartsearchs;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import objects.MyTable;

public abstract class SmartSearch extends Pane {
	protected Node search;
	
	public SmartSearch(Node search, MyTable<?> table) {
		this.search = search;
		table.refresh(getText());
	}
	
	public abstract String getText();
	public abstract void setText(String text);
	
	public Node getSearch() {
		return search;
	}

}