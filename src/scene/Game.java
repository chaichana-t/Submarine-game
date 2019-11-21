package scene;

import java.util.concurrent.TimeUnit;

import entity.submarine.MyMissile;
import entity.submarine.MySubmarine;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import resloader.Resloader;
import ui.BackgroundPane;

public class Game {

	private static AnchorPane gamePane;
	private Scene gameScene;
	public static Stage gameStage;

	private boolean isAlive;

	private BackgroundPane background;
	public MySubmarine submarine;

	private AnimationTimer animation;
	private boolean clock;

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
		gamePane.getChildren().addAll(background.getRects()[0], background.getRects()[1], submarine.getSubmarine());
		gameScene = new Scene(gamePane, 1000, 550);
		gameStage = new Stage();
		gameStage.setTitle("Submarine");
		gameStage.setScene(gameScene);
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
				if (event.getCode() == KeyCode.SPACE) {

					submarine.setShooting(true);
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
					submarine.setShooting(false);
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
						TimeUnit.SECONDS.sleep(20);
						clock = false;
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
				submarine.move();
				background.move();
				if (submarine.isShooting() && clock) {
					MyMissile m = new MyMissile(submarine.getSubmarine().getLayoutX() + 120,
							submarine.getSubmarine().getLayoutY() + 45);
					submarine.shoot(m);
					gamePane.getChildren().add(m.missile);
				}

			}
		};
		animation.start();
	}

}
