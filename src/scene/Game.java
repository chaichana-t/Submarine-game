package scene;



import java.util.List;

import entity.base.shark;
import entity.submarine.Missile;
import entity.submarine.Submarine;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;
import ui.BackgroundPane;
import ui.DeadSubscene;
import ui.PointsPane;

public class Game {

	public static AnchorPane gamePane;
	public static Scene gameScene;

	public static boolean isAlive;

	private BackgroundPane background;
	public static Submarine submarine;
	public static PointsPane pointsLabel;
	public static shark enemies;
	
	private boolean trigger;

	private AnimationTimer animation;
	private boolean clock;
	
	public Game() {
		isAlive = true;
		trigger = false;
		Resloader.LOAD();
		setScene();
		createKeyListener();
		createGameLoop();

	}
	

	private void setScene() {
		gamePane = new AnchorPane();
		background = new BackgroundPane();
		submarine = new Submarine();
		pointsLabel = new PointsPane();
		
		gamePane.getChildren().addAll(background.getRects()[0], background.getRects()[1], submarine.getSubmarine(),pointsLabel.getPointsLabel());
		enemies = new shark();
		for(int i = 0;i<Setting.ENEMY_NUMBER;i++) {
			gamePane.getChildren().addAll(enemies.getEnemies()[i]);
		}
		gameScene = new Scene(gamePane, 1000, 550);
		
	}

	private void createKeyListener() {
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.RIGHT) {

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
				if (event.getCode() == KeyCode.SPACE && trigger == false && isAlive) {
					trigger = true;
					submarine.shoot();
				}
			}
		});
		gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getCode() == KeyCode.RIGHT) {
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
					trigger = false;
				}
			}
		});
	}
	
	

	public void createGameLoop() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (true) {
						clock = true;
						Thread.sleep(20);
						clock = false;
						Thread.sleep(100);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		thread.start();

		animation = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				if(isAlive) {
					submarine.move();
					background.move();
					enemies.checkIfCollide(submarine);
					enemies.move();
				}else
					Dead();
			}

			
		};
		animation.start();
	}
	
	private void Dead() {
		// TODO Auto-generated method stub
		Resloader.bombSound.play();
		gamePane.getChildren().removeAll(/*submarine.getSubmarine(),*/pointsLabel.getPointsLabel());
		for(int i = 0;i<Setting.ENEMY_NUMBER;i++) {
			gamePane.getChildren().remove(enemies.getEnemies()[i]);
		}
		animation.stop();
		PointsPane.updateHighScore();
		DeadSubscene deadSubScene = new DeadSubscene();
		gamePane.getChildren().add(deadSubScene);
		deadSubScene.moveSubScene();
		
	}
}
