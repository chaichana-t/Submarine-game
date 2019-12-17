
package scene;

import application.Main;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import resloader.Resloader;
import ui.BackgroundPane;
import ui.HowToPlaySubscene;
import ui.base.MenuButton;

public class Menu {
	

	private static AnchorPane menuPane;

	public static Scene menuScene;
	
	private MenuButton startButton;
	private MenuButton exitButton;
	private MenuButton howtoButton;
	
	private BackgroundPane background;
	
	private AnimationTimer animation;
	private ImageView logo;

	public final static int MENU_BUTTONS_START_X = 400;
	public final static int MENU_BUTTONS_START_Y = 450;
	
	private HowToPlaySubscene howTo;
	
	public Menu() {
		Resloader.menuBackgroundMusic.play();
		setScene();
		createLoop();
		createButton();
		createLogo();
		createHowtoSubscene();
		
	
	}
	
	private void setScene() {
		menuPane = new AnchorPane();
		background = new BackgroundPane();
		menuPane.getChildren().addAll(background.getRects()[0], background.getRects()[1]);
		menuScene = new Scene(menuPane, Setting.GAME_WIDTH, Setting.GAME_HEIGHT);
	}
	
	private void createLoop() {
		animation = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				background.move();
			}
		};
		animation.start();
	}
	
	private void createHowtoSubscene() {
		howTo = new HowToPlaySubscene(400, 400);
	
		menuPane.getChildren().add(howTo);
		
	}
	
	private void createLogo() {
		logo = Resloader.logo;
		logo.setFitWidth(500);
		logo.setFitHeight(300);
		logo.setLayoutX(Setting.GAME_WIDTH/4);
		logo.setLayoutY(Setting.GAME_HEIGHT/6);
		menuPane.getChildren().add(logo);
	}
	
	private void createButton() {
		createHowToButton();
		createStartButton();
		createExitButton();
	}
	
	private void createHowToButton() {
		howtoButton = new MenuButton("HOW TO PLAY");
		howtoButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				howTo.moveSubScene();
				System.out.println("HowToPlaySubscene");
				
			}
			
		});
		howtoButton.setLayoutX(MENU_BUTTONS_START_X - 300);
		howtoButton.setLayoutY(MENU_BUTTONS_START_Y);
		menuPane.getChildren().add(howtoButton);
	}
	
	private void createStartButton() {
		startButton = new MenuButton("START");
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(howTo.isHidden()) {
					Resloader.menuBackgroundMusic.stop();
					new Game();
					Main.MAIN_WINDOW.setScene(Game.gameScene);
					animation.stop();
					System.out.println("GameStart");
				}
			}
		});
		startButton.setLayoutX(MENU_BUTTONS_START_X);
		startButton.setLayoutY(MENU_BUTTONS_START_Y);
		menuPane.getChildren().add(startButton);
		
	}
	
	private void createExitButton() {
		exitButton = new MenuButton("EXIT");
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Exit");
				System.exit(0);
			}
		});
		exitButton.setLayoutX(MENU_BUTTONS_START_X + 300);
		exitButton.setLayoutY(MENU_BUTTONS_START_Y);
		menuPane.getChildren().add(exitButton);
	}	
	
}
