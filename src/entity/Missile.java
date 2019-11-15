package entity;

import entity.base.Entity;
import entity.base.Hitable;
import entity.base.Submarine;

public class Missile extends Entity implements Hitable{
	
	public Missile() {
		super();
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
	public void checkIfCollide(Hitable x) {
		// TODO Auto-generated method stub
		Submarine submarine = (Submarine) x;
		
	}

	@Override
	public void moveUp() {

	}

	@Override
	public void moveDown() {
			
	}

	@Override
	public void moveLeft() {}

	@Override
	public void moveRight() {}

}
