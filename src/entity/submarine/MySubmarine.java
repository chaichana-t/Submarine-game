package entity.submarine;



import java.util.ArrayList;
import java.util.List;

import entity.base.Submarine;
import javafx.scene.Group;
import resloader.Resloader;

public class MySubmarine extends Submarine {
	
	
	private List<MyMissile> missiles = new ArrayList<MyMissile>();
	
	private boolean isPressedUp ;
	private boolean isPressedDown;
	private boolean isPressedRight;
	private boolean isPressedLeft;
	private boolean isShooting;
	
	private boolean isCanUp;
	private boolean isCanDown;
	private boolean isCanRight;
	private boolean isCanLeft;
	
	
	
	public MySubmarine() {
		super();
		this.velocity = 5;
		isCanUp = isCanDown = isCanRight = isCanLeft = true;
		isPressedUp = isPressedDown = isPressedRight = isPressedLeft = isShooting = false;
	}
	
	
	
	@Override
	public void shoot(MyMissile m) {
		m.move();
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

	
	

	public boolean isShooting() {
		return isShooting;
	}

	public void setShooting(boolean isShooting) {
		this.isShooting = isShooting;
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
		if(isPressedUp && isCanUp) {
			moveUp();
		}
		if(isPressedDown && isCanDown) {
			moveDown();
			
		}
		if(isPressedLeft && isCanLeft) {
			moveLeft();
			
		}
		if(isPressedRight && isCanRight) {
			moveRight();
			
		}
		
	}
	
	public void checkIsCanMove() {
		if(submarineGroup.getLayoutX() < 0) {
			isCanLeft =  false;
		}else {
			isCanLeft = true;
		}
		if(submarineGroup.getLayoutX() > 850) {
			isCanRight =  false;
		}else {
			isCanRight = true;
		}
		if(submarineGroup.getLayoutY() > 450) {
			isCanDown =  false;
		}else {
			isCanDown = true;
		}
		if(submarineGroup.getLayoutY() < 100) {
			isCanUp =  false;
		}else {
			isCanUp = true;
		}
		
	}
	
	

	
	

}
