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
		MainScreen main=new MainScreen(player,opponent,map,1275,850);
		JFrame frame = new JFrame();
		frame.setSize(1275, 850);
		frame.add(main);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.placeDecal(new Decal(ImageIO.read(new File("RedCross.jpg"))), 1, 2);
		main.placeDecal(new Decal(ImageIO.read(new File("SkullCrossBones.jpg"))), 4, 4);
		
		main.focusOn(new Location(0,0));
		main.focusOn(new Location(0,1));
		main.focusOn(new Location(0,2));
		main.focusOn(new Location(0,3));
		main.focusOn(new Location(0,4));
		main.focusOn(new Location(0,5));
		main.focusOn(new Location(0,6));
		main.focusOn(new Location(1,6));
		main.focusOn(new Location(2,6));
		main.focusOn(new Location(3,6));
		main.focusOn(new Location(4,6));
		main.focusOn(new Location(5,6));
		main.focusOn(new Location(6,6));
		main.focusOn(new Location(7,6));
		main.focusOn(new Location(8,6));
		main.focusOn(new Location(9,6));
		main.focusOn(new Location(9,7));
		main.focusOn(new Location(9,8));
		main.focusOn(new Location(9,9));
		main.focusOn(new Location(8,9));
		main.focusOn(new Location(7,9));
		main.focusOn(new Location(7,8));
		main.focusOn(new Location(7,7));
		main.focusOn(new Location(7,6));
		main.focusOn(new Location(7,5));
		main.focusOn(new Location(7,4));
		main.focusOn(new Location(7,3));
		main.focusOn(new Location(7,2));
		main.focusOn(new Location(7,1));
	}
	
}
