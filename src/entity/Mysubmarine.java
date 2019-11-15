package entity;

import entity.base.Entity;
import entity.base.Shootable;
import entity.base.Submarine;

public class Mysubmarine extends Submarine{
	private static final int MYSUBMARINE_HIGHT = 50;
	private static final int MYSUBMARINE = 100;
	private static final int MAX_HEALTH = 5;
	private int currentHealth ;
	private boolean isHasShield ;
	private boolean isFacingRight;
	
	public Mysubmarine() {
		super();
		this.currentHealth = MAX_HEALTH;
	}
	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setSpawnPosition() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	

	

}
