import java.awt.Image;

public class StructureView {
	public static final int SIZE=80;
	
	private Image image;
	
	public StructureView(Image image){
		this.image=image;
	}
	
	public Image getImage(){
		return image;
	}
}
