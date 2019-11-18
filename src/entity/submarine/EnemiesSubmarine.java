package entity.submarine;

import java.util.Random;

import entity.base.Hitable;
import entity.base.Missile;
import entity.base.Submarine;
import javafx.scene.Group;

public class EnemiesSubmarine extends Submarine implements Hitable  {
	
	private Group[] enemySubmarine;
	private Random randomGenerator;
	private int randomNumber;
	
	public EnemiesSubmarine() {
		super();
		this.currentHealth = 10;
		this.isCanGetItem = false;
	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void setPosition() {
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
	public void checkIfCollide(Hitable x) throws Exception {
		// TODO Auto-generated method stub
		
	}




	
	

}
