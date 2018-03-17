package objects;

import java.lang.reflect.Method;

import controller.Controller;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import panes.MyPaneMenu;

public abstract class MyTable<T> extends TableView<T> {
	protected ObservableList<T> datas;
	protected MyPaneMenu paneMenu;
	protected Controller controller;
	
	public MyTable(MyPaneMenu paneMenu, Controller controller) {
		this.paneMenu = paneMenu;
		this.controller = controller;
	}
	
	public void refresh(String text) {
		Label label = new Label("Pas de données trouvées pour \"" + text + "\"");
		label.setStyle("-fx-font-size : 25px;");
		setPlaceholder(label);
	}
	
	protected abstract Object updateConcreteItem(Method method, T t) throws Exception;
	
	protected void addColumn(String name, String propertyValue, int width) {
		TableColumn<T, String> column = new TableColumn<>(name);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyValue));
        column.setPrefWidth(width);
        column.setResizable(false);
        column.setSortable(false);
        column.impl_setReorderable(false);
        
        getColumns().add(column);
	}
	
	protected <S extends MyButton> void addButtonColumn(Method method, Class<S> class1) {
		TableColumn<T, T> button = new TableColumn<>("");
        button.setPrefWidth(60);
        button.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        button.setCellFactory(param -> new TableCell<T, T>() {
            private MyButton button;

            @Override
            protected void updateItem(T t, boolean empty) {                
                if (t != null) {
                    try {
						button = class1.cast(updateConcreteItem(method, t));
	                    setGraphic(button);
					} catch (Exception e) {
						e.printStackTrace();
					}
                } else {
                	setGraphic(null);
                }
            }
        });
        
        getColumns().add(button);
	}
	
}