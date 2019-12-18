package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import resloader.Resloader;
import scene.Menu;

public class Main extends Application {
	public static Stage MAIN_WINDOW;
	
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		Resloader.LOAD();
		MAIN_WINDOW = primaryStage;
		MAIN_WINDOW = new Stage();
		new Menu();
		MAIN_WINDOW.setTitle("Submarine");
		MAIN_WINDOW.setResizable(false);
		MAIN_WINDOW.setScene(Menu.menuScene);
		MAIN_WINDOW.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void stop() throws Exception {
		Platform.exit();
		System.exit(0);
	}
}
