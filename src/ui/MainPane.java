package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import resloader.Resloader;

public class MainPane {

	private Button playButton;
	private Button howToPlayButton;
	private Button exitButton;
	
	public  MainPane() {

		playButton = new Button("Play");
		playButton.setGraphic(Resloader.play);
		
		howToPlayButton = new Button("How To Play");
		howToPlayButton.setGraphic(Resloader.howToPlay);
		
		exitButton = new Button("Exit");
		exitButton.setGraphic(Resloader.exit);
		
	}

}
