package Game;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Character.Bullet;
import Character.Cowboy;
import Character.Enemy;
import Keyboard.JumpDuck;


public class GamePanel extends JPanel {
	
	// background now moves!
	private int xOffset = 0; 
	private Cowboy cowboy;
	private Enemy enemy; 
	
	public GamePanel() {
		BufferedImage cowboySprite = loadImage("/cowboysmall.png", -1, -1, false);
		BufferedImage bulletSprite = loadImage("/bullet.png", -1, -1, false);
		
		enemy = new Enemy(bulletSprite);
		cowboy = new Cowboy(cowboySprite, enemy);
		
		
		addKeyListener(new JumpDuck(cowboy));
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		BufferedImage king = loadImage("/Attack (78x58).png", 78, 58, true);
		g.drawImage(king,  500 - xOffset, 500, null);
		
		cowboy.render(g);
		cowboy.drawFloor(g);
		
		enemy.render(g);
		
		
	}
	
	private BufferedImage loadImage(String path, int width, int height, boolean subimage) {
		InputStream is = getClass().getResourceAsStream(path); 

		try {
			BufferedImage img = ImageIO.read(is); 
			if(subimage) {
				img = img.getSubimage(0, 0, width, height);
			}
			return img;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public void update() {
		// shift origin's x-value left
		xOffset += 1; 
		cowboy.update();
		enemy.update();
	}

}
