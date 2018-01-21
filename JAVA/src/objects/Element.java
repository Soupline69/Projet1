package objects;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.HBox;

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
	
	public HBox getGroup() {
		HBox box = new HBox(30);
		box.setAlignment(Pos.CENTER);
		
		Label labelLabel = new Label(label);
		
		if(isRequired) 
			component.setStyle("-fx-border-color : red");
		
		box.getChildren().addAll(labelLabel, component);
		
		return box;
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