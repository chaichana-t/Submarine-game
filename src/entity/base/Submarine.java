package entity.base;

import entity.Missile;

public abstract class Submarine extends Entity implements Shootable{
	
	protected boolean isHasShield;
	protected boolean isAlive;
	protected int currentHealth;
	protected boolean isCanGetItem;
	
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

}
