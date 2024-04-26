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
	
	private CloudCreate cloudCreate;
	
	
	public MapGen(GamePanel panel) {
		
		this.cloud = panel.loadImage("/cloud.png", -1, -1, false);
		this.cacti = panel.loadImage("/cacti.png", -1, -1, false);
		this.tnt = panel.loadImage("/TNT.png", 0, 0, false);
		
		this.cloudCreate = new CloudCreate(this.cloud);
	}
	
	public void update() {
		cloudCreate.update();
	}
	
	public void drawMap(Graphics g) {
		cloudCreate.draw(g);
	}
}
