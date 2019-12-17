package resloader;



import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;


public class Resloader {

	public static ImageView movingSubmarine1;
	public static ImageView movingSubmarine2;
	public static ImageView movingSubmarine3;
	public static ImageView movingSubmarine4;
	public static ImageView normalSubmarine;
	
	public static Image redShark;
	public static Image pinkShark;
	public static Image blueShark;
	public static Image yellowShark;
	public static Image greenShark;

	public static Image missile;

	public static Image background;
	
	public static ImageView exitButtonImg;
	
	public static ImageView logo;
	public static ImageView howtoPlay;
	
	public static AudioClip missileExplosion;
	public static AudioClip menuBackgroundMusic;
	public static AudioClip bombSound;

	public static void LOAD() {
		movingSubmarine1 = new ImageView(ClassLoader.getSystemResource("idle1.png").toString());
		movingSubmarine2 = new ImageView(ClassLoader.getSystemResource("idle2.png").toString());
		movingSubmarine3 = new ImageView(ClassLoader.getSystemResource("idle3.png").toString());
		movingSubmarine4 = new ImageView(ClassLoader.getSystemResource("idle4.png").toString());
		
		exitButtonImg = new ImageView(ClassLoader.getSystemResource("blue_boxCross.png").toString());
		
		missile = new Image(ClassLoader.getSystemResource("missile.png").toString());
		
		redShark = new Image(ClassLoader.getSystemResource("red_shark.png").toString());
		pinkShark = new Image(ClassLoader.getSystemResource("pink_shark.png").toString());
		blueShark = new Image(ClassLoader.getSystemResource("blue_shark.png").toString());
		yellowShark = new Image(ClassLoader.getSystemResource("yellow_shark.png").toString());
		greenShark = new Image(ClassLoader.getSystemResource("green_shark.png").toString());
		
		logo = new ImageView(ClassLoader.getSystemResource("logo.png").toString());
		howtoPlay = new ImageView(ClassLoader.getSystemResource("howtoplay.png").toString());
		
		background = new Image(ClassLoader.getSystemResource("bg.jpg").toString());
		menuBackgroundMusic = new AudioClip(ClassLoader.getSystemResource("backgroundMusic1.mp3").toString());
		missileExplosion = new AudioClip();
	}

}
