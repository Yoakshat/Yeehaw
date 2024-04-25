package Character;

import java.awt.image.BufferedImage;


public class Bullet extends Motion  {
	
	public Bullet(int x, int y, BufferedImage sprite) {
		super(x, y, 0.1, sprite);
		System.out.println("created bullet");
		flip();
		disableGrav();
	}
	
	

}
