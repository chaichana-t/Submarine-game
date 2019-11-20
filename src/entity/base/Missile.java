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

public abstract class Missile extends Entity implements Hitable{
	
	protected double startX;
	protected double startY;
	protected static final int VELOCITY = 15;
	protected boolean isHit;
	protected boolean isShooting;
	

	
	public Rectangle missile;
	
	
	public Missile(double x,double y) {
		super();
		this.startX = x;
		this.startY = y;
		setPosition();
		
	}
		
	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		missile = new Rectangle(40,20,Color.BLACK);
	}



	@Override
	public void setPosition() {
		// TODO Auto-generated method stub
		missile.setLayoutX(startX);
		missile.setLayoutY(startY);
	}






	public void moveRight() {
		missile.setLayoutX(missile.getLayoutX()+VELOCITY);
	}
	
	

	public void moveLeft() {
		missile.setLayoutX(missile.getLayoutX()-VELOCITY);
	}
	
	
	
	

}
