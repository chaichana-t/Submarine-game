package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import resloader.Resloader;

public class MainPane extends VBox{

	private Button playButton;
	private Button howToPlayButton;
	private Button exitButton;
	
	public  MainPane() {
		
		super();
		this.setPrefWidth(200);
		this.setSpacing(15);
		this.setAlignment(Pos.CENTER);
		playButton = new Button("Play");
		playButton.setGraphic(Resloader.play);
		
		howToPlayButton = new Button("How To Play");
		howToPlayButton.setGraphic(Resloader.howToPlay);
		
		exitButton = new Button("Exit");
		exitButton.setGraphic(Resloader.exit);
		
		this.getChildren().addAll(playButton, howToPlayButton, exitButton);
		
	}

}
