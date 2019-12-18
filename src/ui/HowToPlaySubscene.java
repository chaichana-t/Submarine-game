package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import resloader.Resloader;
import ui.base.MenuButton;
import ui.base.MenuSubscene;

public class HowToPlaySubscene extends MenuSubscene {
	
	private Button backButton;
	private ImageView howtoPlayImg;

	public HowToPlaySubscene(int h, int w) {
		super(h, w);
		InfoLabel howTo = new InfoLabel("HOW TO PLAY");
		howTo.setLayoutX(-w/4);
		howTo.setLayoutY(0);
		createBackButton();
		createHowtoPlay();
		this.getPane().getChildren().addAll(howTo, backButton,howtoPlayImg);
	}
	
	private void createHowtoPlay() {
		howtoPlayImg = Resloader.howtoPlay;
		howtoPlayImg.setFitWidth(350);
		howtoPlayImg.setFitHeight(300);
		howtoPlayImg.setLayoutX(25);
		howtoPlayImg.setLayoutY(50);
		
		
	}
	
	private void createBackButton() {
		Resloader.exitButtonImg.setFitHeight(32);
		Resloader.exitButtonImg.setFitWidth(32);
		backButton = new Button("",Resloader.exitButtonImg);
		backButton.setAlignment(Pos.TOP_LEFT);
		backButton.setStyle(" -fx-background-color: transparent; -fx-background-image: url('"+ ClassLoader.getSystemResource("grey_button12.png").toString() + "');");
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				moveSubScene();
			}
		});
		backButton.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					backButton.setStyle(" -fx-background-color: transparent; -fx-background-image: url('"+ ClassLoader.getSystemResource("grey_button13.png").toString() + "');");
					backButton.setPrefHeight(45);
					setLayoutY(getLayoutY() + 4);
					
				}
			}
		});
		backButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					backButton.setStyle(" -fx-background-color: transparent; -fx-background-image: url('"+ ClassLoader.getSystemResource("grey_button12.png").toString() + "');");
					backButton.setPrefHeight(49);;
					setLayoutY(getLayoutY() - 4);
				}
			}
		});
		backButton.setPrefSize(49, 49);
		backButton.setLayoutX(0);
		backButton.setLayoutY(0);
	}

}
