package entity.submarine;

import entity.base.Hitable;
import entity.base.Missile;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.ImagePattern;
import resloader.Resloader;
import scene.Game;

public class MyMissile extends Missile{
	
	private AnimationTimer TIMER;

	public MyMissile(double x, double y) {
		super(x, y);
		missile.setFill(new ImagePattern(Resloader.missile));
	}



	@Override
	public void checkIfCollide(Hitable object) throws Exception {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void move() {
			TIMER = new AnimationTimer() {
				@Override
				public void handle(long arg0) {
					// TODO Auto-generated method stub
					moveRight();

				}
			};
		TIMER.start();
	}
	
	

}
