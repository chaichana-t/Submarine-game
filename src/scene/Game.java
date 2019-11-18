package scene;


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


public class Game {
	private AnchorPane gamePane;
	private Scene gameScene;
	public static Stage gameStage;

	public static MySubmarine SUBMARINE;
	private AnimationTimer TIMER;
	private boolean up ;
	private boolean down;
	private boolean right;
	private boolean left;
	
	public Game() {
		Resloader.LOAD();
		setScene();
		up= down =right =left = false;
		createKeyListener();
		TIMER = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				if(up) {
					SUBMARINE.moveUp();
				}
				if(down) {
					SUBMARINE.moveDown();
					
				}
				if(left) {
					SUBMARINE.moveLeft();
					
				}
				if(right) {
					SUBMARINE.moveRight();
					
				}
			}
		};
		TIMER.start();
	}
	
	private void setScene() {
		gamePane = new AnchorPane();
		BackgroundImage bg = new BackgroundImage(new Image(ClassLoader.getSystemResource("bg.jpg").toString(),1000,550, false, true), null, null, null, null);
		gamePane.setBackground(new Background(bg));
		SUBMARINE = new MySubmarine();
		gamePane.getChildren().add(SUBMARINE.getSubmarine());
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
						right = true;
				}
				if (event.getCode() == KeyCode.LEFT) {
					left = true;
				}
				if (event.getCode() == KeyCode.UP) {
					up = true;
				}
				if (event.getCode() == KeyCode.DOWN) {
					down = true;
				}
				
			}
		});
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getCode() == KeyCode.RIGHT ) {
					right = false;
			}
			if (event.getCode() == KeyCode.LEFT) {
				left = false;
			}
			if (event.getCode() == KeyCode.UP) {
				up = false;
			}
			if (event.getCode() == KeyCode.DOWN) {
				down = false;
			}
				
			}
			
		});
	}
}
