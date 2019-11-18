package entity.base;

import entity.base.Entity;
import entity.base.Hitable;
import entity.base.Submarine;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;

public abstract class Missile extends Entity implements Hitable,MovableinXaxis{
	
	protected double startX;
	protected double startY;
	protected static final int VELOCITY = 10;
	protected boolean isHit;
	protected boolean isShooting;
	private AnimationTimer TIMER;

	
	public Rectangle missile;
	
	
	public Missile(double x,double y) {
		super();
		this.startX = x;
		this.startY = y;
		setPosition();
		TIMER = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				moveRight();
			}
		};
		TIMER.start();
	}
		
	





	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		missile = new Rectangle(20,20,Color.BLACK);
	}



	@Override
	public void setPosition() {
		// TODO Auto-generated method stub
		missile.setLayoutX(startX);
		missile.setLayoutY(startY);
	}





	@Override
	public void moveRight() {
		missile.setLayoutX(missile.getLayoutX()+VELOCITY);
	}
	
	

	@Override
	public void moveLeft() {
	}

}
