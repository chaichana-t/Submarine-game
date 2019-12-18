package ui;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import resloader.Resloader;
import scene.Game;
import scene.Menu;
import ui.base.HeaderLabel;
import ui.base.MenuButton;
import ui.base.MenuSubscene;

public class DeadSubscene extends MenuSubscene{
	
	//private ImageView gameOver;
	private MenuButton backButton;
	private MenuButton retryButton;
	private HeaderLabel highestScoreLabel;
	private HeaderLabel scoreLabel;
	
	public DeadSubscene() {
		super(500,500);
		setLayoutY(25);
		createBackButton();
		createRetryButton();
		//createGameover();
		this.getPane().getChildren().addAll(backButton,retryButton/*,gameOver*/);
		createHighestScoreLabel();
		createCurrentScoreLabel();
	}
	
	/*private void createGameover() {
		gameOver = Resloader.gameOverImg;
		gameOver.setLayoutX(0);
		gameOver.setLayoutY(0);
	}*/
	
	
	private void createBackButton() {
		backButton = new MenuButton("BACK");
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Resloader.menuBackgroundMusic.play();
				new Menu();
				Main.MAIN_WINDOW.setScene(Menu.menuScene);
			}
		});
		backButton.setLayoutX(50);
		backButton.setLayoutY(400);
	}
	
	private void createRetryButton() {
		retryButton = new MenuButton("RETRY");
		retryButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new Game();
				Main.MAIN_WINDOW.setScene(Game.gameScene);
			}
		});
		retryButton.setLayoutX(250);
		retryButton.setLayoutY(400);
	}
	
	private void createHighestScoreLabel() {
		highestScoreLabel = new HeaderLabel("BEST");
		highestScoreLabel.setLayoutX(150);
		highestScoreLabel.setLayoutY(140);
		InfoLabel highestScore = new InfoLabel(String.valueOf(PointsPane.highestPoints));
		highestScore.setFont(Font.loadFont(ClassLoader.getSystemResource("kenvector_future.ttf").toString(), 35));
		highestScore.setPrefHeight(49);
		highestScore.setPrefWidth(190);
		highestScore.setLayoutX(150);
		highestScore.setLayoutY(170);
		this.getPane().getChildren().addAll(highestScoreLabel, highestScore);
	}
	
	private void createCurrentScoreLabel() {
		scoreLabel = new HeaderLabel("SCORE");
		scoreLabel.setLayoutX(150);
		scoreLabel.setLayoutY(270);
		InfoLabel score = new InfoLabel(String.valueOf(PointsPane.points));
		score.setFont(Font.loadFont(ClassLoader.getSystemResource("kenvector_future.ttf").toString(), 30));
		score.setPrefHeight(49);
		score.setPrefWidth(190);
		score.setLayoutX(150);
		score.setLayoutY(300);
		this.getPane().getChildren().addAll(scoreLabel, score);
	}
}
