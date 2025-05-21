package main;

import object.ObjChest;
import object.ObjDoor;
import object.ObjKey;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		gp.obj[0] = new ObjKey();
		gp.obj[0].worldX = 20 * gp.tileSize;
		gp.obj[0].worldY = 20 * gp.tileSize;
		
		gp.obj[1] = new ObjKey();
		gp.obj[1].worldX = 21 * gp.tileSize;
		gp.obj[1].worldY = 21 * gp.tileSize;
		
		gp.obj[2] = new ObjDoor();
		gp.obj[2].worldX = 22 * gp.tileSize;
		gp.obj[2].worldY = 22 * gp.tileSize;
		
		gp.obj[3] = new ObjChest();
		gp.obj[3].worldX = 23 * gp.tileSize;
		gp.obj[3].worldY = 23 * gp.tileSize;
	}
	
}
