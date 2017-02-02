import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TileViewFactory {
	private BufferedImage waterImage;
	private BufferedImage groundImage;
	private BufferedImage mountainImage;
	
	public TileViewFactory(){
		try {
			waterImage=ImageIO.read(new File("Water.jpg"));
			groundImage=ImageIO.read(new File("Ground.jpg"));
			mountainImage=ImageIO.read(new File("Mountain.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public TileView getTileView(Terrain terrain){
		if(terrain instanceof Water){
			return new TileView(waterImage);
		}
		if(terrain instanceof Water){
			return new TileView(groundImage);
		}
		if(terrain instanceof Water){
			return new TileView(mountainImage);
		}
		return null;
	}
}
