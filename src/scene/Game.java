package scene;


import entity.base.Missile;
import entity.submarine.MyMissile;
import entity.submarine.MySubmarine;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import resloader.Resloader;
import ui.BackgroundPane;


public class Game {
	private AnchorPane gamePane;
	private Scene gameScene;
	public static Stage gameStage;
	
	private BackgroundPane background;
	public MySubmarine submarine;
	
	private AnimationTimer animation;
	
	public Game() {
		Resloader.LOAD();
		setScene();
		createKeyListener();
		createGameLoop();
		
	}
	
	private void setScene() {
		gamePane = new AnchorPane();
		
		background = new BackgroundPane();
		submarine = new MySubmarine();
		gamePane.getChildren().addAll(background.getRects()[0],background.getRects()[1],submarine.getSubmarine());
		gameScene = new Scene(gamePane,1000,550);
		gameStage = new Stage();
		gameStage.setTitle("Submarine");
		gameStage.setScene(gameScene);
	}
		
	private void createKeyListener() {
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.RIGHT ) {
					
					submarine.setPressedRight(true);
				}
				if (event.getCode() == KeyCode.LEFT) {
					
					submarine.setPressedLeft(true);
				}
				if (event.getCode() == KeyCode.UP) {
				
					submarine.setPressedUp(true);
				}
				if (event.getCode() == KeyCode.DOWN) {
					
					submarine.setPressedDown(true);
				}
				if (event.getCode() == KeyCode.SPACE) {
					
					submarine.setShooting(true);
				}
			}
		});
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getCode() == KeyCode.RIGHT ) {
					submarine.setPressedRight(false);
				}
				if (event.getCode() == KeyCode.LEFT) {
					submarine.setPressedLeft(false);
				}
				if (event.getCode() == KeyCode.UP) {
					submarine.setPressedUp(false);
				}
				if (event.getCode() == KeyCode.DOWN) {
					submarine.setPressedDown(false);
				}
				if (event.getCode() == KeyCode.SPACE) {
					
					submarine.setShooting(false);
				}
				
			}
			
		});
	}
	
	public void createGameLoop() {
		animation = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				submarine.move();
				background.move();
				if(submarine.isShooting()) {
					submarine.shoot();
					gamePane.getChildren().add(submarine.shoot().missile);
				}
				
			}
		};
		animation.start();
	}
	
}
