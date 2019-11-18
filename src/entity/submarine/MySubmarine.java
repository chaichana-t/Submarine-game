package entity.submarine;

import entity.base.Missile;
import entity.base.Submarine;
import javafx.scene.Group;
import resloader.Resloader;

public class MySubmarine extends Submarine {
	
	public MySubmarine() {
		super();
		this.velocity = 5;
	}

	@Override
	public Missile shoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		normalSubmarine = Resloader.normalSubmarine;
		movingSubmarine1 = Resloader.movingSubmarine1;
		movingSubmarine2 = Resloader.movingSubmarine2;
		movingSubmarine3 = Resloader.movingSubmarine3;
		movingSubmarine4 = Resloader.movingSubmarine4;
		submarineGroup = new Group(normalSubmarine);

		
	}

	@Override
	public void setPosition() {
		// TODO Auto-generated method stub
		submarineGroup.setLayoutX(575);
		submarineGroup.setLayoutY(300);

		
	}

	public void checkIfOutOfBorder() {
		// TODO Auto-generated method stub
		
		
	}

}
