package resloader;



import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Resloader {

	public static ImageView movingSubmarine1;
	public static ImageView movingSubmarine2;
	public static ImageView movingSubmarine3;
	public static ImageView movingSubmarine4;
	public static ImageView bombingSubmarine;
	
	public static Image redShark;
	public static Image pinkShark;
	public static Image blueShark;
	public static Image yellowShark;
	public static Image greenShark;
	public static Image bombShark;
	
	public static Image clockImg;

	public static Image missile;

	public static Image background;
	
	public static ImageView exitButtonImg;
	
	public static ImageView gameOverImg;
	
	public static ImageView logo;
	public static ImageView howtoPlay;
	
	public static AudioClip missileExplosion;
	public static MediaPlayer menuBackgroundMusic;
	public static MediaPlayer bombSound;
	public static AudioClip powerSound;

	public static void LOAD() {
		movingSubmarine1 = new ImageView(ClassLoader.getSystemResource("idle1.png").toString());
		movingSubmarine2 = new ImageView(ClassLoader.getSystemResource("idle2.png").toString());
		movingSubmarine3 = new ImageView(ClassLoader.getSystemResource("idle3.png").toString());
		movingSubmarine4 = new ImageView(ClassLoader.getSystemResource("idle4.png").toString());
		bombingSubmarine = new ImageView(ClassLoader.getSystemResource("boom_sub.png").toString());
		bombingSubmarine.setFitHeight(80);
		bombingSubmarine.setFitWidth(125);
		
		exitButtonImg = new ImageView(ClassLoader.getSystemResource("blue_boxCross.png").toString());
		
		missile = new Image(ClassLoader.getSystemResource("missile.png").toString());
		
		clockImg = new Image(ClassLoader.getSystemResource("gem_slow.png").toString());
		gameOverImg = new ImageView(ClassLoader.getSystemResource("textGameOver.png").toString());
		
		redShark = new Image(ClassLoader.getSystemResource("red_shark.png").toString());
		pinkShark = new Image(ClassLoader.getSystemResource("pink_shark.png").toString());
		blueShark = new Image(ClassLoader.getSystemResource("blue_shark.png").toString());
		yellowShark = new Image(ClassLoader.getSystemResource("yellow_shark.png").toString());
		greenShark = new Image(ClassLoader.getSystemResource("green_shark.png").toString());
		bombShark = new Image(ClassLoader.getSystemResource("boom_shark.png").toString());
		
		logo = new ImageView(ClassLoader.getSystemResource("logo.png").toString());
		howtoPlay = new ImageView(ClassLoader.getSystemResource("howtoplay.png").toString());
		
		background = new Image(ClassLoader.getSystemResource("bg.jpg").toString());
		//System.out.println(ClassLoader.getSystemResource("backgroundMusic1.mp3").toString());
		
		menuBackgroundMusic = new MediaPlayer(new Media(ClassLoader.getSystemResource("backgroundmusic.mp3").toString()));
		bombSound = new MediaPlayer(new Media(ClassLoader.getSystemResource("bombEx.wav").toString()));
		missileExplosion = new AudioClip(ClassLoader.getSystemResource("cannon-fire-single-shot-blast.mp3").toString());
		powerSound = new AudioClip(ClassLoader.getSystemResource("The Slow Mo Guys slow motion sound effect.mp3").toString());
		
	}

}
