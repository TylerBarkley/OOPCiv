import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class AreaViewport extends Viewport{
	private Map map;
	private int width, height;
	private Graphics2D g2d;
	private Decal[] decals;
	
	public AreaViewport(int height, int width, Map map){
		super(height, width);
		this.height=height;
		this.width=width;
		this.map=map;
		g2d=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB).createGraphics();
	}
	
	public void updateView(){
		
	}
	
	public void placeDecal(Decal decal){
		
	}
	
	private void gerateMapView(){
		TileViewFactory tileViewFactory=new TileViewFactory();
		
		g2d.clearRect(0, 0, width, height);
		
		for(int i=0; i<map.map.length; i++){
			Tile[] row=map.map[i];
			for(int j=0; j<row.length; j++){
				Tile tile=row[j];
				Terrain terrain=tile.terrainType;
				TileView view=tileViewFactory.getTileView(terrain);
				
				g2d.drawImage(view.getImage(), i*TileView.SIZE, j*TileView.SIZE, TileView.SIZE, TileView.SIZE, null);
			}
		}
	}
	
	public void paintComponent(Graphics g) {
	    super.paint(g);
	    g.drawImage(g2d, 0, 0, null);
	}
}
