package entity;

import entity.base.Entity;
import entity.base.Hitable;
import entity.base.Submarine;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class Missile extends Entity implements Hitable{
	
	private int startX;
	private int startY;
	private int velocity = 2;
	private boolean isHit;
	private boolean isFacingRight;
	
	private Thread moveThread;
	
	private ImageView missile1;
	private ImageView missile2;
	private ImageView missile3;
	private Group missileGroup;
	
	
	public Missile(int x,int y,boolean isFacingRight) {
		super();
		this.startX = x;
		this.startY = y;
		isHit = false;
	}
	
	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		
		
		
		
	}
	
	@Override
	public void setSpawnPosition() {
		// TODO Auto-generated method stub
		
	}

	public void move() {
		if(isFacingRight) {
			moveThread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						for(int i = 0; i < 5;i++) {
							missileGroup.setLayoutY(missileGroup.getLayoutX()-velocity);
							Thread.sleep(15);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			moveThread.start();
		}else
			moveThread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						for(int i = 0; i < 5;i++) {
							missileGroup.setLayoutY(missileGroup.getLayoutX()+velocity);
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
	public void checkIfCollide(Hitable x) {
		// TODO Auto-generated method stub
		Submarine submarine = (Submarine) x;
		
	}


}
