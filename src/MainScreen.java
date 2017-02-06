import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class MainScreen extends Overview{

	private StatusViewport statusView;
	private AreaViewport areaView;
	
	public MainScreen(Player player, Player opponent, Map map, int width, int height){
		super(player, width, height);
		statusView=new StatusViewport(player, width/3, height);
		areaView=new AreaViewport(player, opponent, (2 * width)/3, height, map);
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
	
	public void focusOn(Unit unit){
		areaView.focusOn(unit);
	}
	
	public void focusOn(Structure structure){
		areaView.focusOn(structure);
	}
	
	public void updateMenu() {
		
	}
	
	public static void main(String args[]) throws IOException { //for testing purposes only!
		Map map=new Map(10, 10, false);
		Player player=new Player(map);
		Player opponent=new Player(map);
		MainScreen main=new MainScreen(player,opponent,map,1200,800);
		ViewFactory factory=ViewFactory.getFactory();
		JFrame frame = new JFrame();
		frame.setSize(1200, 800);
		frame.add(main);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.placeDecal(new RedCross(), 1, 2);
		main.placeDecal(new SkullCrossBones(), 4, 4);
		
		main.focusOn(new Location(0,0));
		main.focusOn(new Location(0,1));
		main.focusOn(new Location(0,2));
		main.focusOn(new Location(0,3));
		main.focusOn(new Location(0,4));
		main.focusOn(new Location(0,5));

	}
	
}
