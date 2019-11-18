package entity.submarine;

import entity.base.Hitable;
import entity.base.Missile;

public class MyMissile extends Missile{
	

	private static boolean isFacingRight;
	private static int startY;
	private static int startX;

	public MyMissile() {
		super(startX, startY, isFacingRight);
		
	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkIfCollide(Hitable object) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
