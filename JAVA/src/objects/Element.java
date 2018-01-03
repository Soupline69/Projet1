package objects;

import javafx.scene.Node;
import javafx.scene.control.TextInputControl;

public class Element {
	private String label;
	private Node component;
	private boolean isRequired;
	
	public Element(String label, Node component, boolean isRequired) {
		this.label = label;
		this.component = component;
		this.isRequired = isRequired;
	}

	public String getLabel() {
		return label;
	}

	public Node getComponent() {
		return component;
	}

	public boolean isRequired() {
		return isRequired;
	}
	
	public void reset() {
		if(component instanceof MyTextField || component instanceof MyTextArea) 
			((TextInputControl) component).setText("");
		else if(component instanceof MyMaskTextField) {
			String mask = ((MyMaskTextField) component).getInputMaskWithSpaces();
			((MyMaskTextField) component).setText(mask);
		}
	}

}