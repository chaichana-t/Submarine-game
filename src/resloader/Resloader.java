package resloader;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Resloader {

	public static ImageView movingSubmarine1;
	public static ImageView movingSubmarine2;
	public static ImageView movingSubmarine3;
	public static ImageView movingSubmarine4;
	public static ImageView normalSubmarine;
	
	public static Image enemy;

	public static Image missile;

	public static Image background;
	
	public static ImageView play;
	public static ImageView howToPlay;
	public static ImageView exit;
	
	public static MediaPlayer menuBackgroundMusic;

	public static void LOAD() {

		movingSubmarine1 = new ImageView(ClassLoader.getSystemResource("idle1.png").toString());
		movingSubmarine2 = new ImageView(ClassLoader.getSystemResource("idle2.png").toString());
		movingSubmarine3 = new ImageView(ClassLoader.getSystemResource("idle3.png").toString());
		movingSubmarine4 = new ImageView(ClassLoader.getSystemResource("idle4.png").toString());
		missile = new Image(ClassLoader.getSystemResource("missile.png").toString());

		enemy = new Image(ClassLoader.getSystemResource("missile.png").toString());

		background = new Image(ClassLoader.getSystemResource("bg.jpg").toString());
		
		//menuBackgroundMusic = new MediaPlayer(new Media(ClassLoader.getSystemResource("MenuBackgroundMusic.mp3").toString()));

	}

}
