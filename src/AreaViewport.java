import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class AreaViewport extends Viewport{
	private Player opponentPlayer;
	private Map map;
	private int width, height;
	private ArrayList<Decal> decals;
	private ArrayList<int[]> decalLocations;
	private BufferedImage image;
	private Graphics2D g2d;

	public AreaViewport(Player player, Player opponent, int width, int height, Map map){
		super(player, width, height);
		this.opponentPlayer=opponent;
		this.height=height;
		this.width=width;
		this.map=map;
		this.decals=new ArrayList<Decal>();
		this.decalLocations= new ArrayList<int[]>();

		image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g2d=image.createGraphics();

		displayView();
	}

	public void displayView(){
		this.setBackground(Color.blue);
		updateView();
		//g2d.setColor(Color.green);   		//For testing only 
		//g2d.fillRect(0, 0, width, height);
		//this.add(new JScrollPane (new JLabel( new ImageIcon (image))));
		//this.validate();
	}

	public void updateView(){
		displayMap();
		displayUnits();
		displayStructures();
		displayDecals();
	}

	private void displayMap(){
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
	}
	
	private void displayUnits(){
		for(ArrayList<Unit> units: player.getUnits()){
			for(Unit unit: units){
				displayUnit(unit, false);
			}
		}
		
		for(ArrayList<Unit> units: opponentPlayer.getUnits()){
			for(Unit unit: units){
				displayUnit(unit, false);
			}
		}
	}
	
	private void displayUnit(Unit unit, boolean opponent) {
		UnitViewFactory unitViewFactory=new UnitViewFactory();
		UnitView view = unitViewFactory.getUnitView(unit, opponent);
		
		int x=unit.getLoc().x;
		int y=unit.getLoc().y;
		
		g2d.drawImage(view.getImage(), (int)((x+0.5)*TileView.SIZE), (int)((y+0.5)*TileView.SIZE), null);
	}

	private void displayStructures(){
		for(ArrayList<Structure> structures: player.getStructures()){
			for(Structure structure: structures){
				displayStructure(structure, false);
			}
		}
		
		for(ArrayList<Structure> structures: opponentPlayer.getStructures()){
			for(Structure structure: structures){
				displayStructure(structure, true);
			}
		}
	}
	
	private void displayStructure(Structure structure, boolean opponent) {
		StructureViewFactory unitViewFactory=new StructureViewFactory();
		StructureView view = unitViewFactory.getStructureView(structure, opponent);
		
		int x=structure.getLoc().x;
		int y=structure.getLoc().y;
		
		g2d.drawImage(view.getImage(), (int)((x+0.5)*TileView.SIZE), (int)((y+0.5)*TileView.SIZE), null);
	}

	private void displayDecals(){
		for(int i=0; i<decals.size(); i++){
			int x=decalLocations.get(i)[0];
			int y=decalLocations.get(i)[1];

			Decal decal=decals.get(i);

			g2d.drawImage(decal.getImage(), x*TileView.SIZE+10, y*TileView.SIZE+10, null);
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
