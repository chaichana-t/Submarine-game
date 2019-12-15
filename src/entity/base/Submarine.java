package entity.base;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Submarine extends Entity implements Shootable {

	protected boolean isAlive;
	protected int velocity;

	protected ImageView movingSubmarine1;
	protected ImageView movingSubmarine2;
	protected ImageView movingSubmarine3;
	protected ImageView movingSubmarine4;
	protected Group submarineGroup;

	protected Timeline submarineMovingAnimation;

	public Submarine() {
		super();
		this.isAlive = true;
		setSize();
		setSubmarine_Animation();

	}

	public Group getSubmarine() {
		return submarineGroup;
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

	public abstract void setSubmarine_Animation(); 

	public Timeline getSubmarinMoving_Aniamtion() {
		return submarineMovingAnimation;
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
}
