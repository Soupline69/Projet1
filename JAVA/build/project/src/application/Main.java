package application;

import controller.Controller;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Model;
import panes.MyPaneMenu;

public class Main extends Application {

	@Override
		public void start(Stage primaryStage) {
			try {
				primaryStage.setMaxHeight(767);
				primaryStage.setMaxWidth(1283);
				Controller controller = new Controller(new Model());
				Pane root = new MyPaneMenu(controller);
				Scene scene = new Scene(root, 1283, 767);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				
				primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				    @Override
				    public void handle(WindowEvent event) {
				        controller.disconnect();
				    }
				});
				
				primaryStage.setScene(scene);
				primaryStage.setResizable(false);
				primaryStage.setTitle("Programme de gestion");
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) {
			launch(args);
		}
}
