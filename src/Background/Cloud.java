package Background;

import java.awt.image.BufferedImage;

import Character.Motion;

public class Cloud extends Motion {
	
	public Cloud(double x, double y, double scale, BufferedImage sprite) {
		super(x, y, scale, sprite);
		disableGrav();
		// TODO Auto-generated constructor stub
	}

}
