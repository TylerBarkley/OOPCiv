import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class AreaViewport extends Viewport{
	private Map map;
	private int width, height;
	private ArrayList<Decal> decals;
	private ArrayList<int[]> decalLocations;
	private BufferedImage image;
	private Graphics2D g2d;
	public AreaViewport(Player player, int width, int height, Map map){
		super(player, width, height);
		this.height=height;
		this.width=width;
		this.map=map;
		image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g2d=image.createGraphics();
		
		displayView();
	}
	
	public void displayView(){
		this.add(new JScrollPane (new JLabel( new ImageIcon (image))));
		this.validate();
	}
	
	public void updateView(){
		TileViewFactory tileViewFactory=new TileViewFactory();
		
		for(int i=0; i<map.tileMatrix.length; i++){
			Tile[] row=map.tileMatrix[i];
			for(int j=0; j<row.length; j++){
				Tile tile=row[j];
				Terrain terrain=tile.terrainType;
				TileView view=tileViewFactory.getTileView(terrain);
				
				g2d.drawImage(view.getImage(), i*TileView.SIZE, j*TileView.SIZE, null);
			}
		}
		
		for(int i=0; i<decals.size(); i++){
			int x=decalLocations.get(i)[0];
			int y=decalLocations.get(i)[1];
			
			Decal decal=decals.get(i);
			
			g2d.drawImage(decal.getImage(), (int)((x+0.5)*TileView.SIZE), (int)((y+0.5)*TileView.SIZE), null);
		}
	}
	
	public void placeDecal(Decal decal, int x, int y){
		decals.add(decal);
		decalLocations.add(new int[]{x, y});
		updateView();
	}

	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(image,0,0,null);
	}
}
