package objects;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;

public class MyTextArea extends TextArea {
	
	public MyTextArea(int limit) {
		setWrapText(true);
		
		setTextFormatter(new TextFormatter<String>(change -> 
         	change.getControlNewText().length() <= limit ? change : null)
		);
	}

}