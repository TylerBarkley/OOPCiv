import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GameWindow extends JFrame{
	private Player player;
	private Player opponent;
	private Map map;
	private int width;
	private int height;

	private JTabbedPane tabbedPane;
	
	private MainScreen mainScreen;
	private UnitOverview unitOverview;
	private StructureOverview structureOverview;

	public GameWindow(Player player, Player opponent, Map map, int width, int height) {
		this.player = player;
		this.opponent=opponent;
		this.map = map;
		this.width = width;
		this.height = height;
		
		this.tabbedPane=new JTabbedPane();
		
		this.mainScreen=new MainScreen(player,opponent,map,width,height);
		this.unitOverview=new UnitOverview(player, width, height);
		this.structureOverview=new StructureOverview(player, width, height);
		
		setUpTabbedPane();
	}

	public GameWindow(Player player, Player opponent, Map map) {
		this(player, opponent, map, 1080, 720);
	}
	
	private void setUpTabbedPane() {
		tabbedPane.addTab("Main Screen", mainScreen);
		tabbedPane.addTab("Structure Overview", mainScreen);
		tabbedPane.addTab("Unit Overview", mainScreen);
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
		tabbedPane.setSelectedComponent(unitOverview);
	}
	
	public void switchToStructureOverview(){
		tabbedPane.setSelectedComponent(structureOverview);
	}
	
	public void switchToMainScreen(){
		tabbedPane.setSelectedComponent(mainScreen);
	}
	
	public void updateMapView(){ 
		mainScreen.updateAreaView();
	}
	
	public void updateUnitViews(){  
		mainScreen.updateSatusView();
		unitOverview.updateView();
	}
	
	public void updateStructureViews(){ 
		mainScreen.updateSatusView();
		structureOverview.updateView();
	}
	
	public void updateView(){
		mainScreen.updateSatusView();
		unitOverview.updateView();
		structureOverview.updateView();
	}
	
	public void updateMenu(MenuState menuState){
		mainScreen.updateMenu(menuState);
		unitOverview.updateMenu(menuState);
		structureOverview.updateMenu(menuState);
	}
}
