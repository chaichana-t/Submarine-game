package entity.submarine;

import entity.base.Entity;
import entity.base.Hitable;
import entity.base.Shootable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import resloader.Resloader;

public class Submarine extends Entity implements Shootable,Hitable {

	protected boolean isAlive;
	protected int velocity;

	protected ImageView movingSubmarine1;
	protected ImageView movingSubmarine2;
	protected ImageView movingSubmarine3;
	protected ImageView movingSubmarine4;

	private boolean isPressedUp;
	private boolean isPressedDown;
	private boolean isPressedRight;
	private boolean isPressedLeft;
	private boolean isShooting;

	private Group submarineGroup;

	private boolean isCanUp;
	private boolean isCanDown;
	private boolean isCanRight;
	private boolean isCanLeft;
	

	protected Timeline submarineMovingAnimation;

	public Submarine() {
		super();
		setSize();
		this.velocity = 5;
		isCanUp = isCanDown = isCanRight = isCanLeft = true;
		isPressedUp = isPressedDown = isPressedRight = isPressedLeft = isShooting = false;
		setSubmarine_Animation();

	}
	
	@Override
	public void shoot(Missile m) {
		if (m.getMissile().getLayoutX() < 1000) {
			m.move();
		}
	}
	
	@Override
	public void setGc() {
		movingSubmarine1 = Resloader.movingSubmarine1;
		movingSubmarine2 = Resloader.movingSubmarine2;
		movingSubmarine3 = Resloader.movingSubmarine3;
		movingSubmarine4 = Resloader.movingSubmarine4;
		submarineGroup = new Group(movingSubmarine1);
	}
	
	@Override
	public void setPosition() {
		// TODO Auto-generated method stub
		submarineGroup.setLayoutX(0);
		submarineGroup.setLayoutY(250);

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


	public Timeline getSubmarinMoving_Aniamtion() {
		return submarineMovingAnimation;
	}

	
	public void setPressedUp(boolean isPressedUp) {
		this.isPressedUp = isPressedUp;
	}

	public void setPressedDown(boolean isPressedDown) {
		this.isPressedDown = isPressedDown;
	}

	public void setPressedRight(boolean isPressedRight) {
		this.isPressedRight = isPressedRight;
	}

	public void setPressedLeft(boolean isPressedLeft) {
		this.isPressedLeft = isPressedLeft;
	}
	

	@Override
	public void move() {
		// TODO Auto-generated method stub
		checkIsCanMove();
		if (isPressedUp && isCanUp) {
			moveUp();
		}
		if (isPressedDown && isCanDown) {
			moveDown();

		}
		if (isPressedLeft && isCanLeft) {
			moveLeft();

		}
		if (isPressedRight && isCanRight) {
			moveRight();

		}

	}
	
	public void checkIsCanMove() {
		if (submarineGroup.getLayoutX() < 0) {
			isCanLeft = false;
		} else {
			isCanLeft = true;
		}
		if (submarineGroup.getLayoutX() > 850) {
			isCanRight = false;
		} else {
			isCanRight = true;
		}
		if (submarineGroup.getLayoutY() > 450) {
			isCanDown = false;
		} else {
			isCanDown = true;
		}
		if (submarineGroup.getLayoutY() < 100) {
			isCanUp = false;
		} else {
			isCanUp = true;
		}
	}
	public void setSubmarine_Animation() {
		submarineMovingAnimation = new Timeline();
		submarineMovingAnimation.setCycleCount(Timeline.INDEFINITE);
		submarineMovingAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(200), (ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine1);
		}));
		submarineMovingAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(400), (ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine2);
		}));
		submarineMovingAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(600), (ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine3);
		}));
		submarineMovingAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(800), (ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine4);
		}));
		submarineMovingAnimation.play();
	}
	
	public Group getSubmarine() {
		return submarineGroup;
	}
	public void moveUp() {
		submarineGroup.setLayoutY(submarineGroup.getLayoutY() - velocity);
	}

	public void moveDown() {
		submarineGroup.setLayoutY(submarineGroup.getLayoutY() + velocity);
	}

	public void moveRight() {
		submarineGroup.setLayoutX(submarineGroup.getLayoutX() + velocity);
	}

	public void moveLeft() {
		submarineGroup.setLayoutX(submarineGroup.getLayoutX() - velocity);

	}

	public boolean isShooting() {
		return isShooting;
	}

	public void setShooting(boolean isShooting) {
		// TODO Auto-generated method stub
		this.isShooting = isShooting;

	}

	@Override
	public void checkIfCollide(Hitable object) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
