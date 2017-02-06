import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class View {
	private BufferedImage image;
	
	public View(BufferedImage image){
		this.image=image;
	}
	
	public BufferedImage getImage(){
		return image;
	}
	
	public BufferedImage getImage(Map.MapDirection direction){
		AffineTransform tx = new AffineTransform();

		tx.translate(image.getHeight() / 2,image.getWidth() / 2);
		
		double theta=Math.PI/4;
		switch(direction){
		case NORTH:
			theta*=0;
			break;
		case NORTHWEST:
			theta*=1;
			break;
		case WEST:
			theta*=2;
			break;
		case SOUTHWEST:
			theta*=3;
			break;
		case SOUTH:
			theta*=4;
			break;
		case SOUTHEAST:
			theta*=5;
			break;
		case EAST:
			theta*=6;
			break;
		case NORTHEAST:
			theta*=7;
			break;
		}
		tx.rotate(theta);
		
		tx.translate(-image.getWidth() / 2,-image.getHeight() / 2);

		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		BufferedImage newImage =new BufferedImage(image.getHeight(), image.getWidth(), image.getType());
		op.filter(image, newImage);
		
		return image;
	}
}
