package Game;


import javax.swing.JFrame;

public class GameWindow {
	
	private JFrame jframe;
	
    public GameWindow(GamePanel gamePanel) {
    	// 1920 x 960 background
        jframe = new JFrame();
        
        jframe.setSize(Constants.WIDTH, Constants.HEIGHT);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setLocationRelativeTo(null); // at bottom
        jframe.setVisible(true);
    }

}
