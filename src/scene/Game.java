package scene;


import entity.MySubmarine;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import resloader.Resloader;


public class Game {
	private AnchorPane gamePane;
	private Scene gameScene;
	public static Stage gameStage;

	public static AnimationTimer GAMETIMER;
	public static MySubmarine SUBMARINE;
	public static boolean isPressJump, isGodMode, isAlive, trigger;
	
	public Game() {
		Resloader.Load();
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
				SUBMARINE.checkIfOutOfBorder();
				if (event.getCode() == KeyCode.RIGHT ) {
					if(!SUBMARINE.isOutOfBorderRight()) {
						SUBMARINE.moveRight();
						SUBMARINE.getSubmarinMoving_Aniamtion().play();;
					}
				}
				if (event.getCode() == KeyCode.LEFT) {
					if(!SUBMARINE.isOutOfBorderLeft()) {
						SUBMARINE.moveLeft();
						SUBMARINE.getSubmarinMoving_Aniamtion().play();
					}
				}
				if (event.getCode() == KeyCode.UP) {
					if(!SUBMARINE.isOutOfBorderOn()) {
						SUBMARINE.moveUp();
						SUBMARINE.getSubmarinMoving_Aniamtion().play();
					}
				}
				if (event.getCode() == KeyCode.DOWN) {
					if(!SUBMARINE.isOutOfBorderUnder()) {
						SUBMARINE.moveDown();
						SUBMARINE.getSubmarinMoving_Aniamtion().play();
					}
				}
				
			}
		});
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				SUBMARINE.getSubmarinMoving_Aniamtion().stop();
			}
		});
	}
}
