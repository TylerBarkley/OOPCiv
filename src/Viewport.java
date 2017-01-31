import javax.swing.JPanel;

public abstract class Viewport extends JPanel{
	private final int HEIGHT;
	private final int WIDTH;
	
	protected Player player;
	
	public Viewport(int height, int width){
		HEIGHT=height;
		WIDTH=width;
	}
	
	public abstract void updateView();
}
