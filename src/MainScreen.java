import javax.swing.BoxLayout;

public class MainScreen extends Overview{

	private StatusViewport statusView;
	private AreaViewport areaView;
	
	public MainScreen(Player player, Map map, int width, int height){
		super(player, width, height);
		statusView=new StatusViewport(player, width/3, height);
		areaView=new AreaViewport(player, (2 * width)/3, height, map);
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
	
	public void placeDecal(){
		
	}
}
