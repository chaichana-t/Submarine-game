package entity.base;

import java.util.Random;

import entity.submarine.Submarine;
import exception.OutOfBorderException;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;
import scene.Game;
import scene.Setting;

public class SlowClock extends Entity implements Hitable{
	
	private static final int CLOCK_HEIGHT = 50,CLOCK_WIDTH = 50;
	private Rectangle clock;
	private boolean isActivated;
	private boolean isCalled;
	
	private Thread Timer;
	private Random randomGenerator;
	private static int randomNumber;
	private int velocity;
	
	
	public SlowClock() {
		super();
		velocity = 5;
		isActivated = false;
		isCalled = true;
		threadInitialize();
	}
	

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		randomGenerator = new Random();
		clock = new Rectangle(CLOCK_HEIGHT,CLOCK_WIDTH,Color.BLACK);
		clock.setFill(new ImagePattern(Resloader.clockImg));
	}

	@Override
	public void setPosition() {
		// TODO Auto-generated method stub
		randomNumber = randomGenerator.nextInt(20) * 40;
		clock.setLayoutX(Setting.GAME_WIDTH+100);
		clock.setLayoutY(randomNumber+80);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

		
			if(isCalled) {
				clock.setLayoutX(clock.getLayoutX() - velocity);
				try {
					checkIfOutOfBorder();
				} catch (OutOfBorderException e) {
				// TODO Auto-generated catch block
					relocated();
				}
				checkIfCollide(Game.submarine);
			}
			
	}
	@Override
	public void checkIfCollide(Hitable object) {
		if(object instanceof Submarine) {
			if(((Submarine) object).getSubmarine().getBoundsInParent().intersects(clock.getBoundsInParent())) {
				//relocated();
				isCalled = false;
				isActivated = true;
				Game.isClockActivated = true;
			}
		}
		
	}
	
	public void checkIfOutOfBorder() throws OutOfBorderException{
		if(clock.getLayoutX() < -50|| clock.getLayoutY() < 100) {
			 throw new OutOfBorderException("Out Of bound");
		}
	}

	private void relocated() {
		// TODO Auto-generated method stub
		this.setPosition();	
	}
	
	private void threadInitialize() {
		Timer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					updateRelocate();
					Game.timerLabel.updateTimer();
					Thread.sleep(5000);
					Game.timerLabel.hideTimerPane();
					Game.isClockActivated = false;
					Thread.sleep(10000);
					isCalled = true;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Game.isClockActivated = false;
					Game.timerLabel.hideTimerPane();
					isCalled = true;
				}	
			}
		});
		
	}

	public void isSkillActivated() {
		if(isActivated) {
			isActivated = false;
			randomNumber = randomGenerator.nextInt(10)+5;
			Game.timerLabel.showTimerPane();
			randomNumber = randomGenerator.nextInt(10);
			System.out.println(randomNumber);
			threadInitialize();
			Timer.start();
		}
	}
	

	
	public void updateRelocate() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				relocated();
			}
		});
	}
	
	public void updateIsCalled() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					
					Thread.sleep(randomNumber*1000);
					isCalled = true;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public Rectangle getClock() {
		return clock;
	}


	public Thread getTimer() {
		// TODO Auto-generated method stub
		return Timer;
	}
	
	

}
