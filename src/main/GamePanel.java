package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	
	final int originalTileSize = 16;
	final int scale = 4;
	
	public final int tileSize = originalTileSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenHeight = maxScreenRow * tileSize;
	public final int screenWidth = maxScreenCol * tileSize;
	
	TileManager tileMn = new TileManager(this);
	Thread gameThread;
	KeyHandler KeyH = new KeyHandler();
	public CollisionDetector collisionDetect = new CollisionDetector(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public Player player = new Player(this, KeyH);
	public SuperObject obj[] = new SuperObject[10];
	
	
	int FPS = 60;
	
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldRow;
	public final int worldHeight = tileSize * maxWorldCol;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(KeyH);
		this.setFocusable(true);
		
	}
	
	public void setUpGame() {
		
		aSetter.setObject();
		
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while (gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			if (delta >= 1) {
				update();
				repaint();
				delta --;
			}
			
		}
			
	}
	
	public void update() {
		
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;	
		
		tileMn.draw(g2);
		for(int i = 0; i < obj.length; i++) {
			if (obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		player.draw(g2);
		
		g2.dispose();
		
	}
}
