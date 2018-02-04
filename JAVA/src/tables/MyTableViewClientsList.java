package tables;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import buttons.MyButtonAddMeeting;
import buttons.MyButtonInfoClient;
import buttons.MyButtonUpdateClient;
import controller.Controller;
import javafx.collections.FXCollections;
import listeners.DeleteListener;
import model.Client;
import model.ClientDB;
import objects.MyButton;
import objects.MyButtonMenu;
import objects.MyTable;
import panes.MyPaneMenu;

public class MyTableViewClientsList extends MyTable<Client> {

	public MyTableViewClientsList(MyPaneMenu paneMenu, Controller controller) {
		super(paneMenu, controller);

	    try {
	    	addButtonColumn(MyTableViewClientsList.class.getMethod("getMyButtonInfo", Client.class), MyButtonMenu.class);
	    	addColumn("Nom", "lastName", 161);
	        addColumn("Prénom", "firstName", 160);
	        addColumn("Adresse", "adress", 300);    
	        addColumn("Postal", "postal", 90);
	        addColumn("Ville", "city", 170);
	        addColumn("Téléphone", "phoneNumber", 140);
			addButtonColumn(MyTableViewClientsList.class.getMethod("getMyButtonUpdate", Client.class), MyButtonMenu.class);
        	addButtonColumn(MyTableViewClientsList.class.getMethod("getMyButtonAddRDV", Client.class), MyButtonMenu.class);
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
	
	public MyButtonMenu getMyButtonInfo(Client client) {
		return new MyButtonInfoClient(client, paneMenu, controller);
	}
	
	public MyButtonMenu getMyButtonUpdate(Client client) {
		return new MyButtonUpdateClient(client, paneMenu, controller);
	}
	
	public MyButtonMenu getMyButtonAddRDV(Client client) {
		return new MyButtonAddMeeting("addRDV.png", new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()), client.getId(), paneMenu, controller);
	}
	
	public MyButton getMyButtonDelete(Client client) {
		return new MyButton("delete.png", new DeleteListener<Client>(new ClientDB(client.getId()), datas, datas.indexOf(client)));
	}

}