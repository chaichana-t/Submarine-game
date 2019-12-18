package ui;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import scene.Game;

public class TimerPane{

	private Thread Timer;
	private Label timerLabel;
	private int times;

	public TimerPane() {
		timerLabel = new Label();
		times = 0;
		timerLabel.setAlignment(Pos.TOP_CENTER);
		timerLabel.setLayoutX(300);
		timerLabel.setPrefHeight(800);
		timerLabel.setPrefWidth(400);
		timerLabel.setStyle("-fx-background-color: transparent;");
		timerLabel.setPadding(new Insets(10, 10, 10, 10));
		timerLabel.setText("00");
		timerLabel.setLayoutY(1000);
		setFont();
		threadInitialize();
	}

	private void setFont() {
		timerLabel.setFont(Font.loadFont(ClassLoader.getSystemResource("kenvector_future.ttf").toString(), 70));
	}

	private void threadInitialize() {
		Timer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 5; i++) {
						if (Game.isAlive) {
							Thread.sleep(1000);
							times--;
							updateTimeGUI();
							System.out.println(i);
						}
					}
					System.out.println("Gem times out!");
				} catch (InterruptedException e) {
				}
			}
		});
	}
	public void updateTimer() {
		times = 5;
		updateTimeGUI();	
		threadInitialize();
		Timer.start();
	}

	private void updateTimeGUI() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				String textToSet = "0";
				timerLabel.setText(textToSet + times);
			}
		});
	}

	public void showTimerPane() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				timerLabel.setLayoutY(0);
			}
		});
	}

	public void hideTimerPane() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				timerLabel.setLayoutY(1000);
			}
		});
	}

	public Label getTimerLabel() {
		return timerLabel;
	}

	public Thread getTimer() {
		return Timer;
	}

}
