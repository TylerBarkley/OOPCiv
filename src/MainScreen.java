import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class MainScreen extends Overview{

	private StatusViewport statusView;
	private AreaViewport areaView;
	
	public MainScreen(Player player, Map map, int width, int height){
		super(player, width, height);
		statusView=new StatusViewport(player, width/3, height);
		areaView=new AreaViewport(player, (2 * width)/3, height, map);
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
	
	public void updateMenu(MenuState menuState) {
		
	}
	
	public static void main(String args[]) throws IOException { //for testing purposes only!
		MainScreen main=new MainScreen(null,new Map(7, 7, true),1200,800);
		JFrame frame = new JFrame();
		frame.setSize(1200, 800);
		frame.add(main);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.placeDecal(new Decal(ImageIO.read(new File("RedCross.jpg"))), 1, 2);
		main.placeDecal(new Decal(ImageIO.read(new File("SkullCrossBones.jpg"))), 4, 4);
	}
}
