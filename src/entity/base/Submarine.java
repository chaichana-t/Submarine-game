package entity.base;

import entity.Missile;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Submarine extends Entity implements Shootable{
	
	protected boolean isHasShield;
	protected boolean isAlive;
	protected int currentHealth;
	protected boolean isCanGetItem;
	protected ImageView movingSubmarine1;
	protected ImageView movingSubmarine2;
	protected ImageView movingSubmarine3;
	protected ImageView movingSubmarine4;
	protected ImageView normalSubmarine;
	protected Group submarineGroup;

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

	public void setHasShield(boolean isHasShield) {
		this.isHasShield = isHasShield;
	}

	public boolean isHasShield() {
		return isHasShield;
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

	@Override
	public Missile shoot() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Group getSubmarine() {
		return submarineGroup ;
	}

	public void setSize() {
		movingSubmarine1.setFitHeight(30);
		movingSubmarine1.setFitWidth(50);
		movingSubmarine2.setFitHeight(30);
		movingSubmarine2.setFitWidth(50);
		movingSubmarine3.setFitHeight(30);
		movingSubmarine3.setFitWidth(50);
		movingSubmarine4.setFitHeight(30);
		movingSubmarine4.setFitWidth(50);
		
		normalSubmarine.setFitHeight(30);
		normalSubmarine.setFitWidth(50);
		
		
	}

}
