package entity;

import java.util.Random;

import entity.base.Hitable;
import entity.base.Submarine;
import javafx.scene.Group;

public class EnimiesSubmarine extends Submarine implements Hitable  {
	
	private Group[] enemySubmarine;
	private Random randomGenerator;
	private int randomNumber;
	
	public EnimiesSubmarine() {
		super();
		this.currentHealth = 10;
		this.isCanGetItem = false;
	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpawnPosition() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2;i++) {
			randomNumber = randomGenerator.nextInt(20)*20;
			enemySubmarine[i].setLayoutX(1100);
			enemySubmarine[i].setLayoutY(-randomNumber);
			
		}
	}
	
	
		@Override
	public Missile shoot() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void checkIfCollide(Hitable x) {
		// TODO Auto-generated method stub
		
	}


	
	

}
