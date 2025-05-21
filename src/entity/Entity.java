package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	
	public int worldX, worldY;
	public int entitySpeed;
	
	public BufferedImage upStat1, upStat2 ,downStat1, downStat2, leftStat1, leftStat2, rightStat1, rightStat2, up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	public String lastDir;
	
	public int spriteCounter;
	public int spriteNum = 1;
	
	public Rectangle collisionArea;
	public int collisionAreaDefaultX, collisionAreaDefaultY;
	public boolean collisionOn = false;
	
	
}
