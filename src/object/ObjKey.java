package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjKey extends SuperObject{
	
	public ObjKey() {
		
		name = "Key";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/Key.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
		
}
