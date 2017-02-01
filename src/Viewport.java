import javax.swing.JPanel;

public abstract class Viewport extends JPanel{
	private final int HEIGHT;
	private final int WIDTH;
	
	protected Player player;
	
	public Viewport(Player player, int width, int height){
		this.player=player;
		HEIGHT=height;
		WIDTH=width;
	}
	
	public abstract void updateView();
}
