package entity.submarine;

import entity.base.shark;
import entity.base.Entity;
import entity.base.Hitable;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;
import scene.Game;
import scene.Setting;
import ui.PointsPane;

public class Missile extends Entity implements Hitable {

	protected double startX;
	protected double startY;
	protected static final int VELOCITY = 10;
	protected boolean isHit;

	private Rectangle missile;
	public AnimationTimer TIMER;

	public Missile(double x, double y) {
		super();
		this.startX = x;
		this.startY = y;
		setPosition();
		move();

	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		missile = new Rectangle(40, 20, Color.BLACK);
		missile.setFill(new ImagePattern(Resloader.missile));
	}

	@Override
	public void setPosition() {
		// TODO Auto-generated method stub
		missile.setLayoutX(startX);
		missile.setLayoutY(startY);
	}
	@Override
	public void checkIfCollide(Hitable object) {
		// TODO Auto-generated method stub
		Game.enemies.checkIfCollide(this);
	}

	@Override
	public void move() {
		TIMER = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				checkIfCollide(Game.enemies);
				missile.setLayoutX(missile.getLayoutX() + VELOCITY);
				if(missile.getLayoutX() > Setting.GAME_WIDTH) {
					Game.gamePane.getChildren().remove(missile);
					stop();
				}
				if(!Game.isAlive) Game.gamePane.getChildren().remove(missile);
				
				
			}
		};
		TIMER.start();
	}

	public Rectangle getMissile() {
		return missile;
	}


}
