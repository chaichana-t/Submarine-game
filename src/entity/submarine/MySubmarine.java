package entity.submarine;

import entity.base.Missile;
import entity.base.Submarine;
import exception.OutOfBorderException;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import resloader.Resloader;

public class MySubmarine extends Submarine {
	
	private AnimationTimer TIMER;
	public MyMissile missile;
	
	private boolean isPressedUp ;
	private boolean isPressedDown;
	private boolean isPressedRight;
	private boolean isPressedLeft;
	
	
	
	public MySubmarine() {
		super();
		this.velocity = 5;
		isPressedUp = isPressedDown = isPressedRight = isPressedLeft = false;
		smoothMove();
	}

	@Override
	public Missile shoot() {
		// TODO Auto-generated method stub
		return new MyMissile(submarineGroup.getLayoutX()+62.5,submarineGroup.getLayoutY()+40); 
	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		movingSubmarine1 = Resloader.movingSubmarine1;
		movingSubmarine2 = Resloader.movingSubmarine2;
		movingSubmarine3 = Resloader.movingSubmarine3;
		movingSubmarine4 = Resloader.movingSubmarine4;
		submarineGroup = new Group(movingSubmarine1);

		
	}

	@Override
	public void setPosition() {
		// TODO Auto-generated method stub
		submarineGroup.setLayoutX(575);
		submarineGroup.setLayoutY(300);

		
	}

	public void smoothMove() {
		TIMER = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				if(isPressedUp) {
					moveUp();
				}
				if(isPressedDown) {
					moveDown();
					
				}
				if(isPressedLeft) {
					moveLeft();
					
				}
				if(isPressedRight) {
					moveRight();
					
				}
			}
		};
		TIMER.start();
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

	
	

}
