package entity.base;

import entity.base.Entity;
import entity.base.Hitable;
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
		Submarine submarine = (Submarine) x;
		if(submarine.isCanGetItem) {
			if(true) {
				
			}
		}
	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpawnPosition() {
		// TODO Auto-generated method stub
		
	}


}
