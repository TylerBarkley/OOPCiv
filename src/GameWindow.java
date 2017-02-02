import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame{
	private Player player;
	private Map map;
	private int width;
	private int height;

	private MainScreen mainScreen;
	private UnitOverview unitOverview;
	private StatusViewport statusOverview;

	public GameWindow(Player player, Map map, int width, int height) {
		this.player = player;
		this.map = map;
		this.width = width;
		this.height = height;
		this.mainScreen=new MainScreen(null,null,width,height);
		this.unitOverview=new UnitOverview(player, width, height);
		this.statusOverview=new StatusViewport(player, width, height);
	}
	
	public GameWindow(Player player, Map map) {
		this.player = player;
		this.map = map;
		this.width = 1080;
		this.height = 720;
		this.mainScreen=new MainScreen(null,null,width,height);
		this.unitOverview=new UnitOverview(player, width, height);
		this.statusOverview=new StatusViewport(player, width, height);
	}
	
	public void openWindow(){
		this.setSize(width, height);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void closeWindow(){
		this.closeWindow();
	}
	
	public void switchToUnitOverview(){
		
	}
	
	public void switchToStructureOverview(){
		
	}
	
	public void switchToMainScreen(){
		
	}
	
	//If map is visible, updates the map
	public void updateMapView(){ 
		
	}
	
	//If unit overview or main screen are visible, updates unit stats
	public void updateUnitViews(){  
		
	}
	
	//If structure overview or main screen are visible, update structure stats
	public void updateStructureViews(){ 
		
	}
	
	//updates everything in the current view that is visible
	public void updateView(){
		
	}
}
