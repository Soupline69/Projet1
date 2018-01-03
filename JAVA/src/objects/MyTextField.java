package objects;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class MyTextField extends TextField {
	
	public MyTextField(int limit) {
		super();
		addLimitProperty(limit);
	}
	
	private void addLimitProperty(int limit) {
		textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
			    if (newValue != null && newValue.length() > limit) {
			        setText(oldValue);
			    } 
			}
		});
	}
}