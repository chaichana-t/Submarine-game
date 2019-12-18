package scene;

import entity.base.Shark;
import entity.base.SlowClock;
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
import ui.TimerPane;

public class Game {

	public static AnchorPane gamePane;
	public static Scene gameScene;

	public static boolean isAlive;
	public static boolean isClockActivated;

	private BackgroundPane background;
	public static Submarine submarine;
	public static PointsPane pointsLabel;
	public static TimerPane timerLabel;
	public static Shark enemies;
	public static SlowClock clock;
	//public static Thread clockTimer;
	private boolean trigger;

	private AnimationTimer animation;
	
	public Game() {
		isAlive = true;
		trigger = false;
		isClockActivated = false;
		Resloader.LOAD();
		setScene();
		createGameEntites();
		createGameUI();
		createKeyListener();
		createGameLoop();
		//threadInitialize();

	}
	

	private void setScene() {
		gamePane = new AnchorPane();
		background = new BackgroundPane();
		
		
		
		gamePane.getChildren().addAll(background.getRects()[0], background.getRects()[1]);
		gameScene = new Scene(gamePane, 1000, 550);
		
	}
	
	private void createGameUI() {
		pointsLabel = new PointsPane();
		
		timerLabel = new TimerPane();
		
		gamePane.getChildren().addAll(pointsLabel.getPointsLabel(),timerLabel.getTimerLabel());
		
	}
	
	private void createGameEntites() {
		
		submarine = new Submarine();
		gamePane.getChildren().add(submarine.getSubmarine());
		
		clock = new SlowClock();
		gamePane.getChildren().add(clock.getClock());
		
		enemies = new Shark();
		for(int i = 0;i<Setting.ENEMY_NUMBER;i++) {
			gamePane.getChildren().addAll(enemies.getEnemies()[i]);
		}
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
	
	/*public void threadInitialize() {
		
	}*/
	

	public void createGameLoop() {
		animation = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				if(isAlive) {
					submarine.move();
					background.move();
					enemies.checkIfCollide(submarine);
					enemies.move();
					clock.move();
					clock.isSkillActivated();
				}else
					Dead();
			}

			
		};
		animation.start();
	}
	
	private void Dead() {
		// TODO Auto-generated method stub
		Resloader.bombSound.play();
		Resloader.powerSound.stop();
		animation.stop();
		gamePane.getChildren().removeAll(submarine.getSubmarine(),pointsLabel.getPointsLabel());
		for(int i = 0;i<Setting.ENEMY_NUMBER;i++) {
			gamePane.getChildren().remove(enemies.getEnemies()[i]);
		}
		gamePane.getChildren().add(submarine.getBomb());
		PointsPane.updateHighScore();
		DeadSubscene deadSubScene = new DeadSubscene();
		gamePane.getChildren().add(deadSubScene);
		deadSubScene.moveSubScene();
		clock.getTimer().interrupt();
		timerLabel.getTimer().interrupt();
		
	}
}
