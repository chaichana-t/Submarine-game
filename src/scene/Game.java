package scene;


import entity.MySubmarine;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Game {
	private AnchorPane gamePane;
	private Scene gameScene;
	public static Stage gameStage;

	public static AnimationTimer GAMETIMER;
	public static MySubmarine SUBMARINE;
	public static boolean isPressJump, isGodMode, isAlive, trigger;
	
	public Game() {
		setScene();
		createKeyListener();
		
	}
	
	private void setScene() {
		gamePane = new AnchorPane();
		SUBMARINE = new MySubmarine();
		gamePane.getChildren().add(SUBMARINE.getSubmarine());
		gameScene = new Scene(gamePane,1600,900);
		gameStage = new Stage();
		gameStage.setTitle("Submarine");
		gameStage.setScene(gameScene);
	}
	
	

	
	private void createKeyListener() {
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.RIGHT ) {
					SUBMARINE.moveRight();
					SUBMARINE.getSUBMARINEMOVING_ANIMATION().play();;
				}
				if (event.getCode() == KeyCode.LEFT) {
					SUBMARINE.moveLeft();
					SUBMARINE.getSUBMARINEMOVING_ANIMATION().play();
				}
				if (event.getCode() == KeyCode.UP) {
					SUBMARINE.moveUp();
					SUBMARINE.getSUBMARINEMOVING_ANIMATION().play();
				}
				if (event.getCode() == KeyCode.DOWN) {
					SUBMARINE.moveDown();
					SUBMARINE.getSUBMARINEMOVING_ANIMATION().play();
				}
				
			}
		});
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				isPressJump = false;
				trigger = false;
			}
		});
	}
}
