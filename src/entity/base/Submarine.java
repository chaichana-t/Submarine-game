package entity.base;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Submarine extends Entity implements Shootable,MovableinXaxis,MovableinYaxis{
	
	
	protected boolean isAlive;
	protected int currentHealth;
	protected boolean isCanGetItem;
	protected int velocity;
	
	protected ImageView movingSubmarine1;
	protected ImageView movingSubmarine2;
	protected ImageView movingSubmarine3;
	protected ImageView movingSubmarine4;
	protected ImageView normalSubmarine;
	protected Group submarineGroup;
	
	protected Timeline submarineMovingAnimation;
	protected Thread moveThread;
	protected boolean isFacingRight;

	public Submarine() {
		super();
		this.isAlive = true;
		
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		if(this.currentHealth == 0) {
			this.isAlive = false;
		}
	}

	public boolean isCanGetItem() {
		return isCanGetItem;
	}

	
	public Group getSubmarine() {
		return submarineGroup ;
	}

	public void setSize() {
		movingSubmarine1.setFitHeight(160);
		movingSubmarine1.setFitWidth(250);
		movingSubmarine2.setFitHeight(160);
		movingSubmarine2.setFitWidth(250);
		movingSubmarine3.setFitHeight(160);
		movingSubmarine3.setFitWidth(250);
		movingSubmarine4.setFitHeight(160);
		movingSubmarine4.setFitWidth(250);
		
		normalSubmarine.setFitHeight(160);
		normalSubmarine.setFitWidth(250);	
	}
	
	public void setSubmarine_Animation() {
		submarineMovingAnimation = new Timeline();
		submarineMovingAnimation.setCycleCount(Timeline.INDEFINITE);
		submarineMovingAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(200),(ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine1);
		}));
		submarineMovingAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(400),(ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine2);
		}));
		submarineMovingAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(600),(ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine3);
		}));
		submarineMovingAnimation.getKeyFrames().add(new KeyFrame(Duration.millis(800),(ActionEvent event) -> {
			submarineGroup.getChildren().setAll(movingSubmarine4);
		}));
		submarineMovingAnimation.play();
	}
	
	public Timeline getSubmarinMoving_Aniamtion() {
		return submarineMovingAnimation;
	}

	@Override
	public void moveUp() {
			moveThread = new Thread(new Runnable() {
				@Override
				public void run() {
						try {
							for(int i = 0; i < 5;i++) {
								submarineGroup.setLayoutY(submarineGroup.getLayoutY()-velocity);
								Thread.sleep(15);
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			});
			moveThread.start();
	}
		
	@Override
	public void MoveDown() {
		moveThread = new Thread(new Runnable() {
		@Override
		public void run() {
				try {
					for(int i = 0; i < 5;i++) {
						submarineGroup.setLayoutY(submarineGroup.getLayoutY()+velocity);
						Thread.sleep(15);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		moveThread.start();
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		moveThread = new Thread(new Runnable() {

			@Override
			public void run() {
					try {
						for(int i = 0; i < 5;i++) {
							submarineGroup.setLayoutX(submarineGroup.getLayoutX()+velocity);
							Thread.sleep(15);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		});
		moveThread.start();
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		moveThread = new Thread(new Runnable() {
			@Override
			public void run() {
					try {
						for(int i = 0; i < 5;i++) {
							submarineGroup.setLayoutX(submarineGroup.getLayoutX()-velocity);
							Thread.sleep(15);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		});
		moveThread.start();
	}
}
