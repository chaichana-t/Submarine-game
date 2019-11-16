package application;

import entity.MySubmarine;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import resloader.Resloader;
import scene.Game;

public class Main extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		new Game();
		
	
		primaryStage = Game.gameStage;
		primaryStage.setTitle("Submarine");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}	
}
	
	

