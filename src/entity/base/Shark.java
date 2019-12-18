package entity.base;

import java.util.Random;

import entity.submarine.Missile;
import entity.submarine.Submarine;
import exception.OutOfBorderException;
import javafx.scene.Node;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;
import scene.Game;
import scene.Setting;
import ui.PointsPane;

public class Shark extends Entity implements Hitable{
	
	private Random randomGenerator;
	private static int randomNumber;
	private Rectangle[] enemies;
	
	private int velocity;
	
	public Shark() {
		super();
		this.velocity = 5;
		
	}
	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		enemies = new Rectangle[Setting.ENEMY_NUMBER];
		randomGenerator = new Random();
		enemies[0] = new Rectangle(125,80);
		enemies[0].setFill(new ImagePattern(Resloader.blueShark));
		enemies[1] = new Rectangle(125,80);
		enemies[1].setFill(new ImagePattern(Resloader.greenShark));
		enemies[2] = new Rectangle(125,80);
		enemies[2].setFill(new ImagePattern(Resloader.pinkShark));
		enemies[3] = new Rectangle(125,80);
		enemies[3].setFill(new ImagePattern(Resloader.redShark));
		enemies[4] = new Rectangle(125,80);
		enemies[4].setFill(new ImagePattern(Resloader.yellowShark));
	}

	@Override  
	public void setPosition() {
		// TODO Auto-generated method stub
		for(int i = 0;i < Setting.ENEMY_NUMBER;i++) {
			randomNumber = randomGenerator.nextInt(20) * 20;
			enemies[i].setLayoutX(Setting.GAME_WIDTH+100 + randomNumber);
			enemies[i].setLayoutY(randomNumber+80);
			System.out.println("setPosition:"+i +" "+randomNumber/20);
		}

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if(Game.isClockActivated) {
			for(int i = 0; i < Setting.ENEMY_NUMBER;i++) {
				enemies[i].setLayoutX(enemies[i].getLayoutX()-(i*velocity)/10-velocity);
				try {
					checkIfOutOfBorder(enemies[i]);
				} catch (OutOfBorderException e) {
					// TODO Auto-generated catch block
					relocate(i);
				}
			}
			
		}else{
			for(int i = 0; i < Setting.ENEMY_NUMBER;i++) {
				enemies[i].setLayoutX(enemies[i].getLayoutX()-(i*velocity)/2-velocity);
				try {
					checkIfOutOfBorder(enemies[i]);
				} catch (OutOfBorderException e) {
					// TODO Auto-generated catch block
					relocate(i);
				}
			}
		}
	}

	private void checkIfOutOfBorder(Rectangle enemy) throws OutOfBorderException{
		if(enemy.getLayoutX() < -125 || enemy.getLayoutY() < 100) {
				throw new OutOfBorderException("Out Of bound");
			}
	}
	
	public void relocate(int i) {
		// TODO Auto-generated method stub
		randomNumber = randomGenerator.nextInt(20) * 20;
		enemies[i].setLayoutX(1100 + randomNumber);
		enemies[i].setLayoutY(randomNumber+80);
	}
	
	public Rectangle[] getEnemies() {
		return enemies;
	}
	
	@Override
	public void checkIfCollide(Hitable object) {
		// TODO Auto-generated method stub
		if(object instanceof Submarine) {
			for(int i = 0;i < Setting.ENEMY_NUMBER;i++) {
				if(enemies[i].getBoundsInParent().intersects(((Submarine) object).getSubmarine().getBoundsInParent())) {
					Game.submarine.getSubmarinMoving_Aniamtion().stop();
					Game.submarine.getSubmarine().getChildren().setAll(Resloader.bombingSubmarine);
					Game.isAlive = false;
				}
			}
		}else if(object instanceof Missile) {
			for(int i = 0;i < Setting.ENEMY_NUMBER;i++) {
				if(enemies[i].getBoundsInParent().intersects(((Missile) object).getMissile().getBoundsInParent())) {
					relocate(i);
					
					((Missile)object).TIMER.stop();
					PointsPane.points++;
					PointsPane.updateScore();
				}
			}
		}
	}
	
	
	

}
