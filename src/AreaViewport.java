import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AreaViewport extends Viewport{
	private Player opponentPlayer;
	private Map map;
	private int width, height;
	private ArrayList<Decal> decals;
	private ArrayList<int[]> decalLocations;
	private BufferedImage image;
	private Graphics2D g2d;
	private Location focus;

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
		focus=new Location(width/(2*GameInfo.TILE_SIZE), height/(2*GameInfo.TILE_SIZE));
		
		if(map != null) displayView(); // if statement for testing purposes only 
		else {
			g2d.setColor(Color.green);   		//For testing only 
			g2d.fillRect(0, 0, width, height);
		}
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
		g2d.clearRect(0, 0, width, height);
		displayMap();
		displayUnits();
		displayStructures();
		displayDecals();
		repaint();
	}

	private void displayMap(){
		TileViewFactory tileViewFactory=new TileViewFactory();
		
		int mapWidth=map.tileMatrix.length;
		int mapHeight=map.tileMatrix[0].length;
		
		int mapDisplayWidth=width/GameInfo.TILE_SIZE;
		int mapDisplayHeight=height/GameInfo.TILE_SIZE;
		
		int minX=Math.max(0, focus.x-mapDisplayWidth/2);
		int minY=Math.max(0, focus.y-mapDisplayHeight/2);
		
		int maxX=Math.min(minX+mapDisplayWidth, mapWidth);
		int maxY=Math.min(minY+mapDisplayWidth, mapHeight);
		
		if(maxX==mapWidth){
			minX=Math.max(0, maxX-mapDisplayWidth);
		}
		
		if(maxY==mapHeight){
			minY=Math.max(0, maxY-mapDisplayHeight);
		}
		
		for(int i=minX; i<maxX; i++){
			Tile[] row=map.tileMatrix[i];
			for(int j=minY; j<maxY; j++){
				Tile tile=row[j];
				Terrain terrain=tile.terrainType;
				TileView view=tileViewFactory.getTileView(terrain);

				g2d.drawImage(view.getImage(), (i-minX)*GameInfo.TILE_SIZE, (j-minY)*GameInfo.TILE_SIZE, null);
			}
		}
		Stroke s=g2d.getStroke();
		Color c=g2d.getColor();
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.RED);
		g2d.drawRect((focus.x-minX)*GameInfo.TILE_SIZE, (focus.y-minY)*GameInfo.TILE_SIZE, GameInfo.TILE_SIZE, GameInfo.TILE_SIZE);
		g2d.setStroke(s);
		g2d.setColor(c);
	}
	
	private void displayUnits(){
		for(ArrayList<Unit> units: player.getUnits()){
			for(Unit unit: units){
				displayUnit(unit, false);
			}
		}
		
		for(ArrayList<Unit> units: opponentPlayer.getUnits()){
			for(Unit unit: units){
				displayUnit(unit, true);
			}
		}
	}
	
	private void displayUnit(Unit unit, boolean opponent) {
		UnitViewFactory unitViewFactory=new UnitViewFactory();
		UnitView view = unitViewFactory.getUnitView(unit, opponent);
		
		int x=unit.getLoc().x;
		int y=unit.getLoc().y;
		
		g2d.drawImage(view.getImage(), (int)((x+0.5)*GameInfo.TILE_SIZE), (int)((y+0.5)*GameInfo.TILE_SIZE), null);
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
		
		g2d.drawImage(view.getImage(), (int)((x+0.5)*GameInfo.TILE_SIZE), (int)((y+0.5)*GameInfo.TILE_SIZE), null);
	}

	private void displayDecals(){
		for(int i=0; i<decals.size(); i++){
			int x=decalLocations.get(i)[0];
			int y=decalLocations.get(i)[1];

			Decal decal=decals.get(i);

			g2d.drawImage(decal.getImage(), x*GameInfo.TILE_SIZE+10, y*GameInfo.TILE_SIZE+10, null);
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

	public void focusOn(Location loc){
		focus = loc;
		updateView();
	}
	
	public void focusOn(Unit unit){
		focus=unit.getLoc();
		updateView();
		displayUnit(unit, false);
	}
	
	public void focusOn(Structure structure){
		focus=structure.getLoc();
		updateView();
		displayStructure(structure, false);
	}
}
