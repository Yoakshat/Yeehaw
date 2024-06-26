package Game;
public class Game implements Runnable {
	private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;

    private final int FPS_SET = 120;
    
    public Game() {
    	gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);

        gamePanel.requestFocus();

        startGameLoop();
    }
    
    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
    	 double timePerFrame = 1000000000.0 / FPS_SET;
    	 long previousTime = System.nanoTime();

    	 
    	 double deltaF = 0; 
    	 
    	 while(true) {
    		 long currentTime = System.nanoTime();
    		 
    		 deltaF += (currentTime - previousTime) / timePerFrame;
    		 previousTime = currentTime;
    		 
    		 if (deltaF >= 1) {
                 gamePanel.update();
                 gamePanel.repaint();
                 deltaF--;
             }
    	 }
    	 
    }
    
    
}
