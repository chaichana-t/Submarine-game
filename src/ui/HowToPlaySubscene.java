package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import resloader.Resloader;
import ui.base.MenuButton;
import ui.base.MenuSubscene;

public class HowToPlaySubscene extends MenuSubscene {
	
	private MenuButton backButton;

	public HowToPlaySubscene(int h, int w) {
		super(h, w);
		InfoLabel howTo = new InfoLabel("HOW TO PLAY");
		howTo.setLayoutX(-w/4);
		howTo.setLayoutY(0);
		createBackButton();
		this.getPane().getChildren().addAll(howTo, backButton);
	}
	
	private void createBackButton() {
		backButton = new MenuButton("BACK");
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				moveSubScene();
			}
		});
		backButton.setLayoutX(100);
		backButton.setLayoutY(300);
	}

}
