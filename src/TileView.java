import java.awt.Image;

public class TileView {
	public static final int SIZE=100;
	
	private Image image;
	
	public TileView(Image image){
		this.image=image;
	}
	
	public Image getImage(){
		return image;
	}
}
