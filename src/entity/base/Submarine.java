package entity.base;

import exception.OutOfBorderException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Submarine extends Entity implements Shootable,MovableinXaxis,MovableinYaxis{
	
	
	protected boolean isAlive;
	protected int velocity;
	
	protected ImageView movingSubmarine1;
	protected ImageView movingSubmarine2;
	protected ImageView movingSubmarine3;
	protected ImageView movingSubmarine4;
	protected ImageView normalSubmarine;
	protected Group submarineGroup;
	
	protected Timeline submarineMovingAnimation;
	

	public Submarine() {
		super();
		this.isAlive = true;
		setSize();
		setSubmarine_Animation();
		
	}
	

	public Group getSubmarine() {
		return submarineGroup ;
	}

	public void setSize() {
		movingSubmarine1.setFitHeight(80);
		movingSubmarine1.setFitWidth(125);
		movingSubmarine2.setFitHeight(80);
		movingSubmarine2.setFitWidth(125);
		movingSubmarine3.setFitHeight(80);
		movingSubmarine3.setFitWidth(125);
		movingSubmarine4.setFitHeight(80);
		movingSubmarine4.setFitWidth(125);	
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


	
	@Override
	public void moveUp() {
		submarineGroup.setLayoutY(submarineGroup.getLayoutY()-velocity);
	}
		
	@Override
	public void moveDown() {
		submarineGroup.setLayoutY(submarineGroup.getLayoutY()+velocity);
	}

	@Override
	public void moveRight() {
		submarineGroup.setLayoutX(submarineGroup.getLayoutX()+velocity);
	}

	@Override
	public void moveLeft() {
		submarineGroup.setLayoutX(submarineGroup.getLayoutX()-velocity);

	}
}
