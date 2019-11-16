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
		Resloader.Load();
		AnchorPane gamePane = new AnchorPane();
		MySubmarine SUBMARINE = new MySubmarine();
		gamePane.getChildren().add(SUBMARINE.getSubmarine());
		Scene gameScene = new Scene(gamePane,1600,900);
		
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			public void handle(KeyEvent event) {
				SUBMARINE.checkIfOutOfBorder();
				/*if(!SUBMARINE.isOutOfBorderRight()) {
					if (event.getCode() == KeyCode.RIGHT ) {
						SUBMARINE.moveRight();
						SUBMARINE.getSubmarinMoving_Aniamtion().play();
					}
				}
				if(!SUBMARINE.isOutOfBorderLeft()) {
					if (event.getCode() == KeyCode.LEFT) {
						SUBMARINE.moveLeft();
						SUBMARINE.getSubmarinMoving_Aniamtion().play();;
					}
				}*/
				if(!SUBMARINE.isOutOfBorderOn()) {
					if (event.getCode() == KeyCode.UP) {
						SUBMARINE.moveUp();
						//SUBMARINE.getSubmarinMoving_Aniamtion().play();
					}
				}
				if(!SUBMARINE.isOutOfBorderUnder()) {
					if (event.getCode() == KeyCode.DOWN) {
						SUBMARINE.moveDown();
						//SUBMARINE.getSubmarinMoving_Aniamtion().play();
					}
				}
			
			}
		});
		
		/*gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				SUBMARINE.getSubmarinMoving_Aniamtion().;
				
			}
		});*/
		
		primaryStage = new Stage();
		primaryStage.setTitle("Submarine");
		primaryStage.setScene(gameScene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}	
}
	
	

