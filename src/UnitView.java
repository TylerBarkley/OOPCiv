import java.awt.Image;

public class UnitView {
	public static final int SIZE=50;
	
	private Image image;
	
	public UnitView(Image image){
		this.image=image;
	}
	
	public Image getImage(){
		return image;
	}
}
