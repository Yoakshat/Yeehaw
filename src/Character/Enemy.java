package Character;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.Constants;

public class Enemy {
	private BufferedImage bulletSprite; 
	private ArrayList<Bullet> inAction = new ArrayList<Bullet>();
	private boolean rendering = false; 
	
	private int shootFrames = 300; 
	private int shootTick = 0; 
	
	// list of bullets in action
	
	
	public Enemy(BufferedImage bulletSprite) {
		this.bulletSprite = bulletSprite;
	}
	
	public void update() {
		// every frame shoot a new bullet 
		// WARNING: can't render and update at same time
		
		
		if(!rendering) {
			shootTick++; 
			
			if(shootTick >= shootFrames) {
				System.out.println("shooting bullet");
				Bullet bullet = new Bullet(Constants.WIDTH, Constants.FLOOR  - 50, bulletSprite);
				inAction.add(bullet);
				shootTick = 0;
			}
		}
		
		for(Bullet bullet: inAction) {
			bullet.update();
		}
	}
	
	public void destroyBullet(Bullet bullet) {
		System.out.println("destroying bullet");
		inAction.remove(bullet);
	}
	
	public ArrayList<Bullet> getBullets() {
		return inAction;
	}
	
	public void render(Graphics g) {
		rendering = true; 
		for (Bullet bullet: inAction) {
			bullet.render(g);
		}
		rendering = false;
	}
	
	
}
