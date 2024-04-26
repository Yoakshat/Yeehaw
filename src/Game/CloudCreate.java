package Game;

import java.awt.image.BufferedImage;
import Character.Motion;

public class CloudCreate extends ObjectGen{

	public CloudCreate(BufferedImage sprite) {
		super(sprite, 0.4, 400);
	}
	
	@Override 
	public void addObj(double x) {
		int maxHeight = (int)(Constants.HEIGHT * 1.0/6);
		int randHeight = (int)(Math.random() * maxHeight);
		
		Motion mot = new Motion(x, randHeight, scale, sprite);
		mot.disableGrav();
		objs.add(mot);
	}

}
