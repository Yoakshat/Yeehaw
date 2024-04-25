package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Background.Cloud;

public class MapGen {
	
	private GamePanel panel;
	private BufferedImage cloud; 
	private BufferedImage cacti;
	private BufferedImage tnt; 
	
	
	private ArrayList<Cloud> allClouds = new ArrayList<Cloud>();
	private int cloudSpacing = 400; 
	
	
	public MapGen(GamePanel panel) {
		
		this.cloud = panel.loadImage("/cloud.png", -1, -1, false);
		this.cacti = panel.loadImage("/cacti.png", -1, -1, false);
		this.tnt = panel.loadImage("/TNT.png", 0, 0, false);
	}
	
	public void update() {
		updateClouds();
	}
	
	public void updateClouds() {
		for(Cloud cloud: allClouds) {
			// clouds move with background
			cloud.update();
		}
		
		if(allClouds.isEmpty()) {
			// add a cloud at the beginning 
			addCloud(cloudSpacing);
		} else {
			// add from the end until there is empty space
			double xPos = allClouds.get(allClouds.size() - 1).getX();
			
			if(xPos + cloud.getWidth() + cloudSpacing < Constants.WIDTH) {
				addCloud(xPos + cloudSpacing);
			}
		} 
	}
	
	public void addCloud(double x) {
		int maxHeight = (int)(Constants.HEIGHT * 1.0/6);
		int randHeight = (int)(Math.random() * maxHeight);
		
		allClouds.add(new Cloud(x, randHeight, 0.4, cloud));
	}

	
	public void drawMap(Graphics g) {
		// draw cloud
		for(Cloud cloud: allClouds) {
			cloud.render(g);
		}
	}
}
