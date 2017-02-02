import java.awt.HeadlessException;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	private Player player;
	private Map map;
	private int width;
	private int height;

	public GameWindow(Player player, Map map, int width, int height) {
		this.player = player;
		this.map = map;
		this.width = width;
		this.height = height;
	}
	
	public void openWindow(){
		
	}
	
	public void closeWindow(){
		
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
