 package Keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Character.Cowboy;

public class JumpDuck implements KeyListener {

	private Cowboy cowboy; 

	public JumpDuck(Cowboy cowboy) {
		this.cowboy = cowboy; 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: 
			System.out.println("pressed up");
			cowboy.jump(); 
			break; 
		}
		
	}
	
	// just automate this with every frame
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN: 
			cowboy.duck(); 
			break; 
		}
	}
}