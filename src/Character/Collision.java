package Character;
import Helper.Point;

public class Collision {
	private double x; 
	private double y;
	private int width; 
	private int height; 
	
	public Collision(double x, double y, int width, int height) {
		this.x = x; 
		this.y = y;
		this.width = width; 
		this.height = height; 
	}
	
	
	public boolean boxInside(Collision other) {
		// create a point array
		Point[] points = new Point[] {new Point(x, y), 
									  new Point(x, y + height), 
									  new Point(x+width, y), 
									  new Point(x+width, y+height)
									};
		
		
		for (Point p: points) {
			if(p.isInside(other)) {
				return true; 
			}
		}
		
		return false;
		
	}
	
	public double getX() {
		return x; 
	}
	
	public double getY() {
		return y; 
	}
	
	public int getWidth() {
		return width; 
	}
	
	public int getHeight() {
		return height; 
	}
}
