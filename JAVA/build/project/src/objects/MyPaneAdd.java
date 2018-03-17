package objects;

import java.util.List;

import controller.Controller;
import interfaces.CRUD;
import interfaces.GetPaneTableInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import panes.MyPaneMenu;

public abstract class MyPaneAdd extends MyPanePrevious {
	protected List<Element> elements;
	protected Label response = new Label();
	protected Button add;
	protected Button reset;
	protected MyPaneMenu paneMenu;
	protected Controller controller;

	public MyPaneAdd(String string, int id, String method, MyPaneMenu paneMenu, Controller controller) {
		super(string, paneMenu, controller);
		this.paneMenu = paneMenu;
		this.controller = controller;
		add = new MyButton("add.png", new AddListener(id, method));
		reset = new MyButton("reset.png", new ResetListener());
		init();
		buildPanel();
	}
	
	protected abstract void init();
	protected abstract CRUD get(int id);
	
	private void buildPanel() {
		VBox vBox = new VBox(15);
		vBox.setStyle("-fx-padding : 0px 0px 0px -100px;");
		vBox.setAlignment(Pos.BASELINE_CENTER);

		response.setPrefHeight(100);
		vBox.getChildren().add(response);
		
		elements.stream().forEach(element -> vBox.getChildren().add(element.getGroup()));

		HBox buttonsBox = new HBox(75);
		buttonsBox.getChildren().addAll(reset, add);
		buttonsBox.setAlignment(Pos.CENTER);
		vBox.getChildren().add(buttonsBox);
		VBox.setMargin(buttonsBox, new Insets(45, 0, 0, 0));
		
		setCenter(vBox);
	}
	
	protected void displayResult(boolean hasError, String text) {
		if(!hasError) {
			if(paneMenu.getPreviousContent() instanceof GetPaneTableInterface) {
				MyPaneTable paneTable = ((GetPaneTableInterface) paneMenu.getPreviousContent()).getPaneTable();
				String smartText = paneTable.getSmartSearch().getText();
				paneTable.getTable().refresh(smartText);
			}
			
			changeResponse("#28960a", text + " réussi");
			reset();
		} else
			changeResponse("#8b0a50", "Remplir les champs requis");
	}
	
	private void changeResponse(String color, String text) {
		response.setStyle("-fx-font-size : 17px; -fx-text-fill : " + color + ";");
		response.setText(text);
	}
	
	protected void reset() {
		elements.parallelStream().forEach(element -> {
			element.reset();
		});
	}
	
	protected class ResetListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			reset();
			response.setText("");
		}
	}
	
	protected class AddListener implements EventHandler<ActionEvent> {
		private int id;
		private String method;
		
		protected AddListener(int id, String method) {
			this.id = id;
			this.method = method;
		}

		@Override
		public void handle(ActionEvent e) {
			try {
				String[] split = method.split("/");
				displayResult(controller.applyCU(get(id), CRUD.class.getMethod(split[0], new Class[0]), elements), split[1]);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}