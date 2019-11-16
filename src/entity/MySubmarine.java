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
	
	
	
	private boolean isHasShield;
	private boolean isOutOfBorderRight;
	private boolean isOutOfBorderLeft;
	private boolean isOutOfBorderOn;
	private boolean isOutOfBorderUnder;
	
	
	
	public MySubmarine() {
		setSize();
		this.velocity = 10;
		this.currentHealth = 1;
		this.isCanGetItem = true;
		this.isFacingRight = true;
		setSubmarine_Animation();
	}
	
	
	public void checkIfOutOfBorder() {
		if(submarineGroup.getLayoutX() > 1150) {
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
	
	@Override
	public void setSpawnPosition() {
		submarineGroup.setLayoutX(575);
		submarineGroup.setLayoutY(300);
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

	@Override
	public Missile shoot() {
		// TODO Auto-generated method stub
		return new Missile(0,0);
	}



	
	
	

	

}
