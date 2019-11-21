package ui;

import entity.base.Entity;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import resloader.Resloader;

public class BackgroundPane extends Entity {

	private Rectangle[] rects;

	public BackgroundPane() {

	}

	@Override
	public void setGc() {
		// TODO Auto-generated method stub
		rects = new Rectangle[2];
		rects[0] = new Rectangle(1000, 550);
		rects[1] = new Rectangle(1000, 550);
		rects[0].setFill(new ImagePattern(Resloader.background));
		rects[1].setFill(new ImagePattern(Resloader.background));

	}

	@Override
	public void setPosition() {
		// TODO Auto-generated method stub
		rects[0].setLayoutX(0 * 1000);
		rects[1].setLayoutX(1 * 1000);

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		rects[0].setLayoutX(rects[0].getLayoutX() - 4);
		rects[1].setLayoutX(rects[1].getLayoutX() - 4);
		for (int i = 0; i <= 1; i++) {
			if (rects[i].getLayoutX() <= -1000) {
				rects[i].setLayoutX(1000);
			}
		}
	}

	public Rectangle[] getRects() {
		return rects;
	}

}
