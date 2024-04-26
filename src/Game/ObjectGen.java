package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Character.Motion;

public class ObjectGen {
	
	protected ArrayList<Motion> objs = new ArrayList<>();
	protected BufferedImage sprite; 
	private int spacing; 
	private int start; 
	protected double scale; 
	
	public ObjectGen(BufferedImage sprite, double scale, int spacing) {
		this.sprite = sprite;
		this.spacing = spacing;
		this.scale = scale;
	}
	
	public void update() {
		for(Motion obj: objs) {
			// clouds move with background
			obj.update();
		}
		
		if(objs.isEmpty()) {
			// add a cloud at start
			addObj(start);
		} else {
			// add from the end until there is empty space
			Motion obj = objs.get(objs.size() - 1);
			double xPos = obj.getX();
			
			if(xPos + sprite.getWidth() + spacing - 300 < Constants.WIDTH) {
				addObj(xPos + spacing);
			}
		} 
	}
	
	// default behavior is place bottom of object on floor
	public void addObj(double x) {
		Motion mot = new Motion(x, 0, scale, sprite);
		mot.setY(Constants.FLOOR - mot.getHeight());
		
		objs.add(mot);
	}
	
	public void draw(Graphics g) {
		for(Motion mot: objs) {
			mot.render(g);
		}
	}
	
	

	
}
