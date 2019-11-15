package entity.base;

import javafx.scene.shape.Rectangle;

public abstract class Item extends Entity implements Hitable{
	private static final int ITEM_HEIGHT = 50;
	private boolean isCalled;
	private boolean isActivated;
	private Rectangle item;
	
	
	public Item() {
		super();
		this.isCalled = false;
		this.isActivated = false;
	}
	
	@Override
	public void checkIfCollide(Hitable x) {
		// TODO Auto-generated method stub
		
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
