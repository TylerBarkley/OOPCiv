import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StructureViewFactory {
	private BufferedImage base;
	private BufferedImage baseEnemy;
	
	public StructureViewFactory(){
		try {
			base=ImageIO.read(new File("Base.jpg"));
			baseEnemy=ImageIO.read(new File("EnemyBase.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public StructureView getStructureView(Structure Structure, boolean opponent){
		if(opponent){
			if(Structure instanceof Base){
				return new StructureView(baseEnemy);
			}
		}
		if(Structure instanceof Base){
			return new StructureView(base);
		}

		return null;
	}
}
