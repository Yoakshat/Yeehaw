package Character;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Game.Constants;

public class Motion {
	
	protected double x; 
	protected double y; 
	protected double xvelo = 0; 
	protected double yvelo = 0; 
	
	private double grv = 0.1;
	private boolean flip = false;
	
	protected boolean onGround = true; 
	protected BufferedImage sprite; 
	
	protected int width; 
	protected int height; 
	
	private int xOffset = 1; 
	
	private Collision hitBox;
	
	protected boolean highlight = false; 

	
	public Motion(double x, double y, double scale, BufferedImage sprite) {
		
		this.x = x; 
		this.y = y;
		
		this.sprite = sprite;
		if(sprite != null) {
			this.width = (int)(sprite.getWidth() * scale);
			this.height = (int)(sprite.getHeight() * scale);
		}
		
		this.hitBox = new Collision(x, y, width, height);
		
	}
	
	public double getX() {
		return this.x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void highlight() {
		highlight = true;
	}
	
	public void flip(){
		flip = true;
	}
	
	public boolean collides(Motion other) {
		return (this.hitBox.boxInside(other.getHitbox()) || other.getHitbox().boxInside(this.hitBox));
	}
	
	public void noBackMove() {
		xOffset = 0;
	}
	
	public void disableGrav() {
		grv = 0;
	}
	
	private void updateHitbox() {
		this.hitBox = new Collision(x, y, width, height);
	}
	
	public void update() {
		
		yvelo += grv; 
		groundCheck();
		
		
		if(onGround && yvelo >= 0) {
			yvelo = 0; 
		}
		
		// xOffset: move with background
		this.x += xvelo - xOffset; 
		this.y += yvelo; 
		
		updateHitbox();
	}
	
	
	
	public void groundCheck() {
		if(this.y + height >= Constants.FLOOR) {
			onGround = true;
		} else {
			onGround = false; 
		}
	}
	
	// draw floor for now
	public void drawFloor(Graphics g) {
		g.drawLine(0, Constants.FLOOR, 5000, Constants.FLOOR);
	}
	
	public void render(Graphics g) {
		if(!flip) {
			g.drawImage(sprite, (int)(x), (int)(y), width, height, null);
		} else {
			g.drawImage(sprite, (int)(x + width), (int)(y), -1 * width, height, null);
		}
		
		if(highlight) {
			g.setColor(Color.red);
		}
		
		// g.drawRect((int)x, (int)y, width, height);
		// reset
		g.setColor(Color.black);
	}
	
	public Collision getHitbox() {
		return this.hitBox;
	}
	
}
