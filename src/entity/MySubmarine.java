package entity;

import entity.base.Submarine;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import resloader.Resloader;

public class MySubmarine extends Submarine  {
	
	private static final int MAX_HEALTH = 3;
	public static Timeline SUBMARINEMOVING_ANIMATION;
	private static final int VELOCITY = 10;
	private Thread moveThread ;
	private boolean isOutOfBorderRight;
	private boolean isOutOfBorderLeft;
	private boolean isOutOfBorderOn;
	private boolean isOutOfBorderUnder;
	
	
	
	public MySubmarine() {
		this.currentHealth = 1;
		this.isCanGetItem = true;
		setSUBMARINEMOVING_ANIMATION();
	}
	
	
	public void checkIfOutOfBorder() {
		if(submarineGroup.getLayoutX() > 1100) {
			isOutOfBorderRight = true;
		}
		else {
			isOutOfBorderRight = false;
		}
		if(submarineGroup.getLayoutX() < 0) {
			isOutOfBorderLeft = true;
		}
		else {
			isOutOfBorderLeft = false;
		}
		if(submarineGroup.getLayoutY() < 0 ) {
			isOutOfBorderOn = true;
		}
		else {
			isOutOfBorderOn = false;
		}
		if(submarineGroup.getLayoutY() > 600) {
			isOutOfBorderUnder = true;
		}
		else {
			isOutOfBorderUnder = false;
		}
	}
	

	@Override
	public void setGc() {
		
		normalSubmarine = Resloader.normalSubmarine;
		movingSubmarine1 = Resloader.movingSubmarine1;
		movingSubmarine2 = Resloader.movingSubmarine2;
		movingSubmarine3 = Resloader.movingSubmarine3;
		movingSubmarine4 = Resloader.movingSubmarine4;
		submarineGroup = new Group(normalSubmarine);
		
	}
	

	public void setSUBMARINEMOVING_ANIMATION() {
		SUBMARINEMOVING_ANIMATION = new Timeline();
		SUBMARINEMOVING_ANIMATION.setCycleCount(Timeline.INDEFINITE);
		SUBMARINEMOVING_ANIMATION.getKeyFrames().add(new KeyFrame(Duration.millis(200),(ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine1);
		}));
		SUBMARINEMOVING_ANIMATION.getKeyFrames().add(new KeyFrame(Duration.millis(400),(ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine2);
		}));
		SUBMARINEMOVING_ANIMATION.getKeyFrames().add(new KeyFrame(Duration.millis(600),(ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine3);
		}));
		SUBMARINEMOVING_ANIMATION.getKeyFrames().add(new KeyFrame(Duration.millis(800),(ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine4);
		}));
	
	}


	@Override
	public void setSpawnPosition() {
		submarineGroup.setLayoutX(300);
		submarineGroup.setLayoutY(225);
	}
	
	@Override
	public void moveUp() {
		moveThread = new Thread(new Runnable() {

			@Override
			public void run() {
					try {
						for(int i = 0; i < 5;i++) {
							submarineGroup.setLayoutY(submarineGroup.getLayoutY()-VELOCITY);
							Thread.sleep(15);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		});
		moveThread.start();
	}
	
	@Override
	public void moveDown() {
		moveThread = new Thread(new Runnable() {

			@Override
			public void run() {
					try {
						for(int i = 0; i < 5;i++) {
							submarineGroup.setLayoutY(submarineGroup.getLayoutY()+VELOCITY);
							Thread.sleep(15);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		});
		moveThread.start();
	}
		
	
	@Override
	public void moveLeft() {
		moveThread = new Thread(new Runnable() {

			@Override
			public void run() {
					try {
						for(int i = 0; i < 5;i++) {
							submarineGroup.setLayoutX(submarineGroup.getLayoutX()-VELOCITY);
							Thread.sleep(15);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		});
		moveThread.start();
		
	}
	
	@Override
	public void moveRight() {
		moveThread = new Thread(new Runnable() {

			@Override
			public void run() {
					try {
						for(int i = 0; i < 5;i++) {
							submarineGroup.setLayoutX(submarineGroup.getLayoutX()+VELOCITY);
							Thread.sleep(15);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		});
		moveThread.start();
		
	}
	
	public static Timeline getSUBMARINEMOVING_ANIMATION() {
		return SUBMARINEMOVING_ANIMATION;
	}


	public boolean isOutOfBorderRight() {
		return isOutOfBorderRight;
	}


	public boolean isOutOfBorderLeft() {
		return isOutOfBorderLeft;
	}


	public boolean isOutOfBorderOn() {
		return isOutOfBorderOn;
	}


	public boolean isOutOfBorderUnder() {
		return isOutOfBorderUnder;
	}


	
	
	

	

}
