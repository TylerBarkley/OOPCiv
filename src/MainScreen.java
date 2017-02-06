import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class MainScreen extends Overview{

	private StatusViewport statusView;
	private AreaViewport areaView;
	private Player opponent;
	
	public MainScreen(Player player, Player opponent, Map map, int width, int height){
		super(player, width, height);
		statusView=new StatusViewport(player, width/3, height);
		areaView=new AreaViewport(player, opponent, (2 * width)/3, height, map);
		this.opponent=opponent;
		displayView();
	}
	
	public void updateView() {
		statusView.updateView();
		areaView.updateView();
	}

	public void updateAreaView() {
		areaView.updateView();
	}
	
	public void updateSatusView() {
		statusView.updateView();
	}
	
	public void displayView() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(areaView);
		this.add(statusView);
	}
	
	public void placeDecal(Decal decal, int x, int y){
		areaView.placeDecal(decal, x, y);
	}
	
	public void focusOn(Location loc){
		areaView.focusOn(loc);
	}
	
	public void focusOn(Controllable c){
		areaView.focusOn(c);
	}
	
	public void updateMenu() {
		
	}

	public void swapTurn(Player player) {
		statusView.swapTurn(player);
		areaView.swapTurn();
	}
}
