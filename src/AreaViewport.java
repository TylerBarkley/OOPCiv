import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AreaViewport extends Viewport{
	private Map map;
	private int width, height;
	private ArrayList<Decal> decals;
	private ArrayList<int[]> decalLocations;
	
	public AreaViewport(int height, int width, Map map){
		super(height, width);
		this.height=height;
		this.width=width;
		this.map=map;
	}
	
	public void updateView(){
		generateMapView();
	}
	
	public void placeDecal(Decal decal, int x, int y){
		decals.add(decal);
		decalLocations.add(new int[]{x, y});
		generateMapView();
	}
	
	private void generateMapView(){
		Graphics2D g2d=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB).createGraphics();
		paintComponent(g2d);
	}
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
		TileViewFactory tileViewFactory=new TileViewFactory();
		
		for(int i=0; i<map.map.length; i++){
			Tile[] row=map.map[i];
			for(int j=0; j<row.length; j++){
				Tile tile=row[j];
				Terrain terrain=tile.terrainType;
				TileView view=tileViewFactory.getTileView(terrain);
				
				g.drawImage(view.getImage(), i*TileView.SIZE, j*TileView.SIZE, null);
			}
		}
		
		for(int i=0; i<decals.size(); i++){
			int x=decalLocations.get(i)[0];
			int y=decalLocations.get(i)[1];
			
			Decal decal=decals.get(i);
			
			g.drawImage(decal.getImage(), (int)((x+0.5)*TileView.SIZE), (int)((y+0.5)*TileView.SIZE), null);
		}
	}
}
