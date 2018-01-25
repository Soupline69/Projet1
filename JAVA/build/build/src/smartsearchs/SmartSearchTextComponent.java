package smartsearchs;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import objects.MyTable;
import objects.MyTextField;

public class SmartSearchTextComponent extends SmartSearch {
	
	public SmartSearchTextComponent(MyTable<?> table) {
		super(new MyTextField(50), table);
		
		((TextField) search).setPromptText("Entrez votre recherche     ...");
		search.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
            	if (ke.getCode().equals(KeyCode.ENTER)) {
					table.refresh(getText());
            	}
            }
        });
	}
	
	public String getText() {
		return ((TextField) search).getText().trim();
	}

	@Override
	public void setText(String text) {
		((TextField) search).setText(text);
	}

}