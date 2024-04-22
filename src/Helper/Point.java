package Helper;

import java.awt.Graphics;

import Character.Collision;

public class Point {
	
	private double x; 
	private double y; 
	
	public Point(double x, double y) {
		this.x = x; 
		this.y = y; 
	}
	
	public boolean isInside(Collision other) { 
		if(x >= other.getX() && x <= other.getX() + other.getWidth()) {
			if(y >= other.getY() && y <= other.getY() + other.getHeight()) {
				return true;
			}
		}
		
		return false;
	}
	
	public void render(Graphics g) {
		g.drawOval((int)x, (int)y, 10, 10);
	}
}
