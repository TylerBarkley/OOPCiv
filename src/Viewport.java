import javax.swing.JPanel;

public abstract class Viewport extends JPanel{

	protected Player player;
	
	public Viewport(Player player, int width, int height){
		this.player=player;
		setSize(width, height);
	}
	
	public abstract void updateView();
}
