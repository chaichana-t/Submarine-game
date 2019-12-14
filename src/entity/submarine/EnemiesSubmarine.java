package entity.submarine;

import java.util.Random;

import entity.base.Hitable;
import entity.base.Submarine;
import javafx.scene.Group;

public class EnemiesSubmarine extends Submarine implements Hitable {

	private Group[] enemySubmarine;
	private Random randomGenerator;
	private int randomNumber;

	public EnemiesSubmarine() {
		super();

	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void setPosition() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2; i++) {
			randomNumber = randomGenerator.nextInt(20) * 20;
			enemySubmarine[i].setLayoutX(1100);
			enemySubmarine[i].setLayoutY(-randomNumber);
		}
	}

	@Override
	public void checkIfCollide(Hitable x) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shoot(MyMissile m) {
		// TODO Auto-generated method stub

	}

}
