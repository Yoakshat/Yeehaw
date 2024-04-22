package Game;

import java.awt.Toolkit;

public final class Constants {
	public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width; 
	public static int HEIGHT = WIDTH * 960/1920;
	public static int FLOOR = HEIGHT - 100;
}