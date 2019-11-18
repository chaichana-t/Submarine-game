package entity.base;

import entity.base.Entity;
import entity.base.Hitable;
import entity.base.Submarine;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Missile extends Entity implements Hitable,MovableinXaxis{
	
	protected int startX;
	protected int startY;
	protected static final int VELOCITY = 2;
	protected boolean isHit;
	protected boolean isFacingRight;
	
	protected Thread moveThread;
	
	protected ImageView missile1;
	protected ImageView missile2;
	protected ImageView missile3;
	protected Group missileGroup;
	
	
	public Missile(int x,int y,boolean isFacingRight) {
		super();
		this.startX = x;
		this.startY = y;
		isHit = false;
	}
	

	
	@Override
	public void checkIfCollide(Hitable x) throws Exception {
		// TODO Auto-generated method stub
		
		
	}
	
	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		moveThread = new Thread(new Runnable() {

			@Override
			public void run() {
					try {
						for(int i = 0; i < 5;i++) {
							missileGroup.setLayoutX(missileGroup.getLayoutX()+VELOCITY);
							Thread.sleep(15);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		});
		moveThread.start();
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		moveThread = new Thread(new Runnable() {
			@Override
			public void run() {
					try {
						for(int i = 0; i < 5;i++) {
							missileGroup.setLayoutX(missileGroup.getLayoutX()-VELOCITY);
							Thread.sleep(15);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		});
		moveThread.start();
	}

}
