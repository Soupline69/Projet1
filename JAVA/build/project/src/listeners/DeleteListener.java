package listeners;

import java.util.Optional;

import interfaces.CRUD;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class DeleteListener<T> implements EventHandler<ActionEvent> {
	private CRUD db;
	private ObservableList<T> datas;
	private int index;
	
	public DeleteListener(CRUD db, ObservableList<T> datas, int index) {
		this.db = db;
		this.datas = datas;
		this.index = index;
	}
	
	@Override
	public void handle(ActionEvent e) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Suppression");
		alert.setContentText("Êtes-vous sûr de vouloir supprimer définitivement cette ligne ?");
		
		Optional<ButtonType> result = alert.showAndWait();
		
		if (result.isPresent() && result.get() == ButtonType.OK) {
			datas.remove(index);
	    	db.delete();	
		}			
	}

}
