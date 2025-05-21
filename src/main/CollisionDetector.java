package main;

import entity.Entity;

public class CollisionDetector {
	
	GamePanel gp;
	
	public CollisionDetector(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		
		int entityLeftWorldX = entity.worldX + entity.collisionArea.x;
		int entityRightWorldX = entity.worldX + entity.collisionArea.x + entity.collisionArea.width;
		int entityTopWorldY = entity.worldY + entity.collisionArea.y;
		int entityBottomWorldY = entity.worldY + entity.collisionArea.y + entity.collisionArea.height;
		
		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		int tileNum1, tileNum2;
		
		if (entity.direction == "up") {
			entityTopRow = (entityTopWorldY - entity.entitySpeed) / gp.tileSize;
			tileNum1 = gp.tileMn.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileMn.mapTileNum[entityRightCol][entityTopRow];
			
			if (gp.tileMn.tile[tileNum1].collision == true || gp.tileMn.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				
			}
		}		
		
		if (entity.direction == "down") {
			entityBottomRow = (entityBottomWorldY + entity.entitySpeed) / gp.tileSize;
			tileNum1 = gp.tileMn.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileMn.mapTileNum[entityRightCol][entityBottomRow];
			
			if (gp.tileMn.tile[tileNum1].collision == true || gp.tileMn.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			
		}
		
		if (entity.direction == "left") {
			entityLeftCol = (entityLeftWorldX - entity.entitySpeed) / gp.tileSize;
			tileNum1 = gp.tileMn.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileMn.mapTileNum[entityLeftCol][entityBottomRow];
			
			if (gp.tileMn.tile[tileNum1].collision == true || gp.tileMn.tile[tileNum2].collision) {
				entity.collisionOn = true;
			}
			
		}
		
		if (entity.direction == "right") {
			entityRightCol = (entityRightWorldX + entity.entitySpeed) / gp.tileSize;
			tileNum1 = gp.tileMn.mapTileNum[entityRightCol][entityBottomRow];
			tileNum2 = gp.tileMn.mapTileNum[entityRightCol][entityTopRow];
			
			if (gp.tileMn.tile[tileNum1].collision == true || gp.tileMn.tile[tileNum2].collision) {
				entity.collisionOn = true;
			}
			
		}
		
	}
	
	public int checkObject(Entity entity, boolean player) {
		
		int index = 999;
		
		for (int i = 0; i < gp.obj.length; i++) {
			
			if (gp.obj[i] != null) {
				
				entity.collisionArea.x = entity.worldX + entity.collisionArea.x;
				entity.collisionArea.y = entity.worldY + entity.collisionArea.y;
				
				gp.obj[i].collisionArea.x = gp.obj[i].worldX + gp.obj[i].collisionArea.x;
				gp.obj[i].collisionArea.y = gp.obj[i].worldY + gp.obj[i].collisionArea.y;
				
				if (entity.direction == "up") {
					entity.collisionArea.y -= entity.entitySpeed;
					if (entity.collisionArea.intersects(gp.obj[i].collisionArea)) {
						System.out.println("up");
						
					}
				}
				
				if (entity.direction == "down") {
					entity.collisionArea.y += entity.entitySpeed;
					if (entity.collisionArea.intersects(gp.obj[i].collisionArea)) {
						System.out.println("down");
						
					}
					
				}
				
				if (entity.direction == "left") {
					entity.collisionArea.x -= entity.entitySpeed;
					if (entity.collisionArea.intersects(gp.obj[i].collisionArea)) {
						System.out.println("left");
						
					}
				}
				
				if (entity.direction == "right") {
					entity.collisionArea.x += entity.entitySpeed;
					if (entity.collisionArea.intersects(gp.obj[i].collisionArea)) {
						System.out.println("right");
						
					}
				}
				
			entity.collisionArea.x = entity.collisionAreaDefaultX;
			entity.collisionArea.y = entity.collisionAreaDefaultY;
				
			gp.obj[i].collisionArea.x = gp.obj[i].collisionAreaDefaultX;
			gp.obj[i].collisionArea.y = gp.obj[i].collisionAreaDefaultY;
				
			}
		}
		
		return index;
		
	}
}

