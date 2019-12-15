package entity.submarine;

import java.util.List;
import java.util.Random;

import entity.base.Hitable;
import entity.base.Submarine;
import exception.OutOfBorderException;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;
import scene.Setting;

public class EnemySubmarine extends Submarine implements Hitable {

	private Random randomGenerator;
	private static int randomNumber;

	public EnemySubmarine() {
		super();
		randomNumber = randomGenerator.nextInt(20) * 20;
		this.velocity = 5;
		isAlive = true;
	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		movingSubmarine1 = Resloader.enemySubmarine;
		movingSubmarine2 = Resloader.enemySubmarine;
		movingSubmarine3 = Resloader.enemySubmarine;
		movingSubmarine4 = Resloader.enemySubmarine;
		submarineGroup = new Group(movingSubmarine1);
		randomGenerator = new Random();
	}
	
	@Override
	public void setPosition() {
		// TODO Auto-generated method stub

		randomNumber = randomGenerator.nextInt(20) * 20;
		submarineGroup.setLayoutX(500);
		submarineGroup.setLayoutY(randomNumber);
	}

	@Override
	public void checkIfCollide(Hitable x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		try {
			checkIfOutOfBorder();
			moveLeft();
		} catch (OutOfBorderException e) {
			// TODO Auto-generated catch block
			System.out.println("relocate");
			relocate();
		}
	}

	private void relocate() {
		// TODO Auto-generated method stub
		randomNumber = randomGenerator.nextInt(20) * 20;
		System.out.println(randomNumber);
		submarineGroup.setLayoutX(1100);
		submarineGroup.setLayoutY(randomNumber);
	}

	@Override
	public void shoot(MyMissile m) {
		// TODO Auto-generated method stub
		
	}
	
	private void  checkIfOutOfBorder() throws exception.OutOfBorderException {
		if(submarineGroup.getLayoutX()< 0) {
			throw new exception.OutOfBorderException("Out of bound");
		}
	}

}
