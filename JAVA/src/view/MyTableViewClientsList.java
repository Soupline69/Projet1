package view;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import controller.Controller;
import javafx.collections.FXCollections;
import listeners.DeleteListener;
import model.Client;
import model.ClientDB;
import objects.MyButton;
import objects.MyButtonPane;
import objects.MyTable;

public class MyTableViewClientsList extends MyTable<Client> {

	public MyTableViewClientsList(MyPaneMenu paneMenu, Controller controller) {
		super(paneMenu, controller);

	    try {
	    	addButtonColumn(MyTableViewClientsList.class.getMethod("getMyButtonInfo", Client.class), MyButtonPane.class);
	    	addColumn("Nom", "lastName", 167);
	        addColumn("Prénom", "firstName", 166);
	        addColumn("Adresse", "adress", 300);    
	        addColumn("Postal", "postal", 90);
	        addColumn("Ville", "city", 170);
	        addColumn("Téléphone", "phoneNumber", 140);
			addButtonColumn(MyTableViewClientsList.class.getMethod("getMyButtonUpdate", Client.class), MyButtonPane.class);
        	addButtonColumn(MyTableViewClientsList.class.getMethod("getMyButtonAddRDV", Client.class), MyButtonPane.class);
			addButtonColumn(MyTableViewClientsList.class.getMethod("getMyButtonDelete", Client.class), MyButton.class);
        } catch (Exception e) {
			e.printStackTrace();
		} 
    }
	
	@Override
	public void refresh(String text) {
		super.refresh(text);
		datas = FXCollections.observableArrayList(controller.getModel().getClients(text));
		setItems(datas);
	}
	
	@Override
	public Object updateConcreteItem(Method method, Client client) throws Exception {
		return method.invoke(this, client);
	}
	
	public MyButtonPane getMyButtonInfo(Client client) {
		return new MyButtonPane("folder.png", new MyPaneInfoClient(client.getName(), client.getId(), paneMenu, controller), paneMenu);
	}
	
	public MyButtonPane getMyButtonUpdate(Client client) {
		return new MyButtonPane("update.png", new MyPaneUpdateClient(client, controller), paneMenu);
	}
	
	public MyButtonPane getMyButtonAddRDV(Client client) {
		return new MyButtonPane("addRDV.png", new MyPaneAddMeeting("Ajouter", 0, "create/Insertion", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), client.getId(), controller), paneMenu);
	}
	
	public MyButton getMyButtonDelete(Client client) {
		return new MyButton("delete.png", new DeleteListener<Client>(new ClientDB(client.getId()), datas, datas.indexOf(client)));
	}

}