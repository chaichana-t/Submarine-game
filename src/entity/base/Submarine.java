package entity.base;

import entity.Missile;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public abstract class Submarine extends Entity implements Shootable{
	
	
	protected boolean isAlive;
	protected int currentHealth;
	protected boolean isCanGetItem;
	protected ImageView movingSubmarine1;
	protected ImageView movingSubmarine2;
	protected ImageView movingSubmarine3;
	protected ImageView movingSubmarine4;
	protected ImageView normalSubmarine;
	protected Group submarineGroup;
	protected Timeline submarineMovingAnimation;
	protected Thread moveThread ;

	public Submarine() {
		super();
		this.isAlive = true;
		
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		if(this.currentHealth == 0) {
			this.isAlive = false;
		}
	}

	public boolean isCanGetItem() {
		return isCanGetItem;
	}

	
	public Group getSubmarine() {
		return submarineGroup ;
	}

	public void setSize() {
		movingSubmarine1.setFitHeight(160);
		movingSubmarine1.setFitWidth(250);
		movingSubmarine2.setFitHeight(160);
		movingSubmarine2.setFitWidth(250);
		movingSubmarine3.setFitHeight(160);
		movingSubmarine3.setFitWidth(250);
		movingSubmarine4.setFitHeight(160);
		movingSubmarine4.setFitWidth(250);
		
		//normalSubmarine.setFitHeight(160);
		//normalSubmarine.setFitWidth(250);	
	}
	
	public void setSubmarine_Animation() {
		submarineMovingAnimation = new Timeline();
		submarineMovingAnimation.setCycleCount(Timeline.INDEFINITE);
		submarineMovingAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(200),(ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine1);
		}));
		submarineMovingAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(400),(ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine2);
		}));
		submarineMovingAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(600),(ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine3);
		}));
		submarineMovingAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(800),(ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine4);
		}));
		submarineMovingAnimation.play();
	}
	
	public Timeline getSubmarinMoving_Aniamtion() {
		return submarineMovingAnimation;
	}
	
	public abstract void moveUp();
	
	public abstract void moveDown();
	
	public abstract void moveLeft();
	
	public abstract void moveRight();

}