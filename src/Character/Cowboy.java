package Character;

import java.awt.image.BufferedImage;

public class Cowboy extends Motion {
	
	private double jumpVelo = -5;
	private Enemy enemy;
	private BufferedImage cowboyFrames; 
	private int animFrame = 0;
	private int runTicks = 0; 
	private int runFrames = 10;
	
	
	public Cowboy(BufferedImage cowboyFrames, Enemy enemy) {
		super(100, 500, 64, 80, null);
		this.cowboyFrames = cowboyFrames;
		this.sprite = getFrame(0);
		this.enemy = enemy;
		noBackMove();
	}
	
	private BufferedImage getFrame(int idx) {
		int WIDTH = 75; 
		int HEIGHT = 101;
		return cowboyFrames.getSubimage(WIDTH*idx, 0, WIDTH, HEIGHT);
	}
	
	public void update() {
		super.update();
		bulletCollision();
		runningAnim();
		
	}
	
	private void runningAnim() {
		
		if(onGround) {
			runTicks++; 
			if(runTicks >= runFrames) {
				animFrame++; 
				if(animFrame == 3) {
					animFrame = 0;
				}
				
				this.sprite = getFrame(animFrame);
				runTicks = 0;
			}
		}
		
	}
	
	private void bulletCollision() {
		if (!enemy.getBullets().isEmpty()) {
			// check if collides with bomb
			Bullet near = enemy.getBullets().get(0);
			Collision bullBox = near.getHitbox();
			// for debugging
			near.highlight();
			
			if (collides(near)) {
				gameOver();
				
				// destroy bullet after animation 
				enemy.destroyBullet(near);
			} else if (x >= bullBox.getX() + bullBox.getWidth()) {
				enemy.destroyBullet(near);
			}
			
			
		}
	}
	
	private void gameOver() {
		System.out.println("Game over");
		
	}
	
	public void jump() {
		yvelo = jumpVelo;
	}
	
	public void duck() {
		
	}
	
	
	
}
