import javax.swing.JPanel;

public abstract class Overview extends JPanel{
	protected Player player;
	protected MenuState ms;
	protected int selectedOption;	
	protected int width;
	protected int height;
	
	public abstract void updateView();
	public abstract void displayView();
	
	public Overview(Player player, int width, int height){
		this.player=player;
		if(player != null) ms = player.getMenuState(); //if statement for testing only
		this.width=width;
		this.height=height;
	}
	
	public abstract void updateMenu();
}
