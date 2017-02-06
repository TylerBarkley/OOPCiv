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
	private int minX, minY, maxX, maxY;
	private ArrayList<Decal> decals;
	private ArrayList<int[]> decalLocations;
	private BufferedImage image;
	private Graphics2D g2d;
	private Location focus;
	private ViewFactory viewFactory;

	public AreaViewport(Player player, Player opponent, int width, int height, Map map){
		super(player, width, height);
		this.opponentPlayer=opponent;
		this.height=height;
		this.width=width;
		this.map=map;
		this.decals=new ArrayList<Decal>();
		this.decalLocations= new ArrayList<int[]>();

		this.viewFactory=ViewFactory.getFactory();

		image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g2d=image.createGraphics();

		displayView();
	}

	public void displayView(){
		this.setBackground(Color.BLUE);
		updateView();
	}

	public void updateView(){
		g2d.clearRect(0, 0, width, height);
		centerMapDisplay();
		displayMap();
		displayUnits();
		displayStructures();
		displayDecals();
		displayRallyPoints();
		repaint();
	}

	private void centerMapDisplay() {
		int mapWidth=map.tileMatrix.length;
		int mapHeight=map.tileMatrix[0].length;

		int mapDisplayWidth=width/GameInfo.TILE_SIZE;
		int mapDisplayHeight=height/GameInfo.TILE_SIZE;

		if(focus != null){
			minX=Math.max(0, focus.x-mapDisplayWidth/2  + 1);
			minY=Math.max(0, focus.y-mapDisplayHeight/2 + 1);
		} else{
			minX=0;
			minY=0;
		}

		maxX=Math.min(minX+mapDisplayWidth, mapWidth);
		maxY=Math.min(minY+mapDisplayWidth, mapHeight);

		if(maxX==mapWidth){
			minX=Math.max(0, maxX-mapDisplayWidth);
		}

		if(maxY==mapHeight){
			minY=Math.max(0, maxY-mapDisplayHeight);
		}
	}

	private void displayMap(){
		for(int i=minX; i<maxX; i++){
			Tile[] row=map.tileMatrix[i];
			for(int j=minY; j<maxY; j++){
				Tile tile=row[j];
				Terrain terrain=tile.terrainType;
				View view=viewFactory.getView(terrain);

				g2d.drawImage(view.getImage(), (i-minX)*GameInfo.TILE_SIZE, (j-minY)*GameInfo.TILE_SIZE, null);
			}
		}

		if(focus != null){
			Stroke s=g2d.getStroke();
			Color c=g2d.getColor();
			g2d.setStroke(new BasicStroke(5));
			g2d.setColor(Color.RED);
			g2d.drawRect((focus.x-minX)*GameInfo.TILE_SIZE, (focus.y-minY)*GameInfo.TILE_SIZE, GameInfo.TILE_SIZE, 				GameInfo.TILE_SIZE);
			g2d.setStroke(s);
			g2d.setColor(c);
		}
	}

	private void displayUnits(){
		for(ArrayList<Unit> units: player.getUnits()){
			for(Unit unit: units){

				if(unit != null) { displayUnit(unit, false); }
			}
		}

		for(ArrayList<Unit> units: opponentPlayer.getUnits()){
			for(Unit unit: units){
				if(unit != null) { displayUnit(unit, true); }
			}
		}
	}

	private void displayUnit(Unit unit, boolean opponent) {
		View view = viewFactory.getView(unit, opponent);

		int x=unit.getLoc().x;
		int y=unit.getLoc().y;

		if(x >= minX && x <= maxX && y >= minY && y <= maxY){
			g2d.drawImage(view.getImage(unit.facingDirection), (int)((x+0.5-minX)*GameInfo.TILE_SIZE-GameInfo.UNIT_SIZE/2.0), 
					(int)((y+0.5-minY)*GameInfo.TILE_SIZE-GameInfo.UNIT_SIZE/2.0), null);
		}
	}

	private void displayStructures(){
		for(ArrayList<Structure> structures: player.getStructures()){
			for(Structure structure: structures){
				if(structure != null) {
					displayStructure(structure, false);
				}
			}
		}

		for(ArrayList<Structure> structures: opponentPlayer.getStructures()){
			for(Structure structure: structures){
				if(structure != null) {
					displayStructure(structure, true);
				}
			}
		}
	}

	private void displayStructure(Structure structure, boolean opponent) {
		View view = viewFactory.getView(structure, opponent);

		int x=structure.getLoc().x;
		int y=structure.getLoc().y;
		if(x > minX && x < maxX && y > minY && y < maxY){
			g2d.drawImage(view.getImage(), (int)((x+0.5-minX)*GameInfo.TILE_SIZE-GameInfo.STRUCTURE_SIZE/2.0), 
					(int)((y+0.5-minY)*GameInfo.TILE_SIZE-GameInfo.STRUCTURE_SIZE/2.0), null);
		}
	}

	private void displayDecals(){
		for(int i=0; i<decals.size(); i++){
			int x=decalLocations.get(i)[0];
			int y=decalLocations.get(i)[1];

			View view=viewFactory.getView(decals.get(i));
			if(x > minX && x < maxX && y > minY && y < maxY){
				g2d.drawImage(view.getImage(), (x-minX)*GameInfo.TILE_SIZE, (y-minY)*GameInfo.TILE_SIZE, null);
			}
		}
	}

	public void placeDecal(Decal decal, int x, int y){
		decals.add(decal);
		decalLocations.add(new int[]{x, y});
		updateView();
	}

	private void displayRallyPoints(){
		for(RallyPoint rally: player.getRallyPoints()){
			if(rally != null){
				displayRallyPoint(rally);
			}
		}
	}

	private void displayRallyPoint(RallyPoint rally) {
		View view = viewFactory.getView(rally);

		int x=rally.getLoc().x;
		int y=rally.getLoc().y;

		g2d.drawImage(view.getImage(), (int)(x*GameInfo.TILE_SIZE-GameInfo.RALLYPOINT_SIZE), 
				(int)(y*GameInfo.TILE_SIZE), null);
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
