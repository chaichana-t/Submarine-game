package application;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.Game;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		new Game();
		
		primaryStage = Game.gameStage;
		primaryStage.setTitle("Submarine");
		primaryStage.show();
			
	}
	public static void main(String[] args) {
		launch(args);
	}

}
