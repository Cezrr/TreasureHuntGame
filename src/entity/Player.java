package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	
	GamePanel gp;
	KeyHandler KeyH;
	
	public int screenX;
	public int screenY;
	
	public Player(GamePanel gp, KeyHandler KeyH) {
		this.gp = gp;
		this.KeyH = KeyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		collisionArea = new Rectangle(8, 16, 32, 32);
		
		collisionAreaDefaultX = collisionArea.x;
		collisionAreaDefaultY = collisionArea.y;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void getPlayerImage() {
		
		try {
			
			downStat1 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenDownStat1.png"));
			downStat2 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenDownStat2.png"));
			upStat1 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenUpStat1.png"));
			upStat2 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenUpStat2.png"));
			leftStat1 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenLeftStat1.png"));
			leftStat2 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenLeftStat2.png"));
			rightStat1 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenRightStat1.png"));
			rightStat2 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenRightStat2.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenUp1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenUp2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenDown1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenDown2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenRight1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenRight2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenLeft1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/Archer-GreenLeft2.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setDefaultValues() {
		worldX = 600;
		worldY = 600; 
		entitySpeed = 4;
		direction = "down";
		lastDir = "down";
	}
	
	public void update() {
		
		if (KeyH.upPressed == true) {
			direction = "up";
			lastDir = "up";
			
		} else if (KeyH.downPressed == true) {
			direction = "down";
			lastDir = "down";
			
		} else if (KeyH.leftPressed) {
			direction = "left";
			lastDir = "left";
			
		} else if (KeyH.rightPressed) {
			direction = "right";
			lastDir = "right";
			
		} else {
			if (lastDir == "down") {
				direction = "downStat";
			} else if (lastDir == "up") {
				direction = "upStat";
			} else if (lastDir == "left") {
				direction = "leftStat";
			} else if (lastDir == "right") {
				direction = "rightStat";
			}
		}
		
		if (worldY < 0) {
			worldY = 0;
		}
		
		if (worldY > (gp.maxWorldRow - 1) * gp.tileSize)
			worldY = (gp.maxWorldRow - 1) * gp.tileSize;
			
		if (worldX < 0) {
			worldX = 0;
		}
		
		if (worldX > (gp.maxWorldCol - 1) * gp.tileSize)
			worldX = (gp.maxWorldCol - 1) * gp.tileSize;
		
		collisionOn = false;
		gp.collisionDetect.checkTile(this);
		
		int objIndex = gp.collisionDetect.checkObject(this, true);
		
		if (collisionOn == false) {
			if (direction == "up") {
				worldY -= entitySpeed;
			}
			if (direction == "down") {
				worldY += entitySpeed;
			}
			if (direction == "left") {
				worldX -= entitySpeed;
			}
			if (direction == "right") {
				worldX += entitySpeed;
			}
			
		}
		
		spriteCounter ++;
			if (spriteCounter > 15) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
			
	
	public void draw(Graphics2D g2) {
		
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		if (direction == "up") {
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			} 
		
		} else if (direction == "down") {
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			} 
		} else if (direction == "left") {
			if (spriteNum == 1) {
				image = left1;
			}
			if (spriteNum == 2) {
				image = left2;
			} 
		} else if (direction == "right") {
			if (spriteNum == 1) {
				image = right1;
			}
			if (spriteNum == 2) {
				image = right2;
			} 
		} else if (direction == "downStat") {
			if (spriteNum == 1) {
				image = downStat1;
			}
			if (spriteNum == 2) {
				image = downStat2;
			} 
		} else if (direction == "upStat") {
			if (spriteNum == 1) {
				image = upStat1;
			}
			if (spriteNum == 2) {
				image = upStat2;
			} 
		} else if (direction == "leftStat") {
			if (spriteNum == 1) {
				image = leftStat1;
			}
			if (spriteNum == 2) {
				image = leftStat2;
			} 
		} else if (direction == "rightStat") {
			if (spriteNum == 1) {
				image = rightStat1;
			}
			if (spriteNum == 2) {
				image = rightStat2;
			} 
		}
		
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		
	}
	
	
}
