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
		setBackground(Color.BLACK);
		updateView();
	}

	public void updateView(){
		width=getWidth();
		height=getHeight();
		image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g2d=image.createGraphics();
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

		int mapDisplayWidth=width/GameInfo.TILE_SIZE*4/5;
		int mapDisplayHeight=height/GameInfo.TILE_SIZE*2;

		if(player.location != null){
			minX=Math.max(0, player.location.x-mapDisplayWidth/2);
			minY=Math.max(0, player.location.y-mapDisplayHeight/2);
		} else{
			minX=0;
			minY=0;
		}

		maxX=Math.min(minX+mapDisplayWidth, mapWidth);
		maxY=Math.min(minY+mapDisplayHeight, mapHeight);

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

				Location loc=new Location(i,j);
				
				g2d.drawImage(view.getImage(), getMapPositionX(loc),
						getMapPositionY(loc), null);
			}
		}

		if(player.location != null){
			ensureLocationOnMap();
			Stroke s=g2d.getStroke();
			Color c=g2d.getColor();
			g2d.setStroke(new BasicStroke(5));
			g2d.setColor(Color.RED);
			g2d.drawRect(getMapPositionX(player.location), getMapPositionY(player.location), 
					GameInfo.TILE_SIZE, GameInfo.TILE_SIZE);
			g2d.setStroke(s);
			g2d.setColor(c);
		}
	}

	private void displayUnits(){
		for(ArrayList<Unit> units: player.getUnits()){
			for(Unit unit: units){

				if(unit != null) { display(unit, false); }
			}
		}

		for(ArrayList<Unit> units: opponentPlayer.getUnits()){
			for(Unit unit: units){
				if(unit != null) { display(unit, true); }
			}
		}
	}

	private void displayStructures(){
		for(ArrayList<Structure> structures: player.getStructures()){
			for(Structure structure: structures){
				if(structure != null) {
					display(structure, false);
				}
			}
		}

		for(ArrayList<Structure> structures: opponentPlayer.getStructures()){
			for(Structure structure: structures){
				if(structure != null) {
					display(structure, true);
				}
			}
		}
	}

	private void display(Controllable con, boolean opponent) {
		View view = viewFactory.getView(con, opponent);

		int x=con.getLoc().x;
		int y=con.getLoc().y;
		
		Location loc=new Location(x,y);
		
		if(con instanceof Structure){
			if(x > minX && x < maxX && y > minY && y < maxY){
				g2d.drawImage(view.getImage(), (int)(getMapPositionX(loc)-GameInfo.STRUCTURE_SIZE/2.0), 
						(int)(getMapPositionY(loc)-GameInfo.STRUCTURE_SIZE/2.0), null);
			}
		}
		else{
			if(x > minX && x < maxX && y > minY && y < maxY){
				g2d.drawImage(view.getImage(), (int)(getMapPositionX(loc)-GameInfo.UNIT_SIZE/2.0), 
						(int)(getMapPositionY(loc)-GameInfo.UNIT_SIZE/2.0), null);
			}
		}
	}

	private void displayDecals(){
		for(int i=0; i<decals.size(); i++){
			int x=decalLocations.get(i)[0];
			int y=decalLocations.get(i)[1];

			Location loc=new Location(x,y);
			
			View view=viewFactory.getView(decals.get(i));
			if(x > minX && x < maxX && y > minY && y < maxY){
				g2d.drawImage(view.getImage(), getMapPositionX(loc), 
						getMapPositionY(loc), null);
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
		
		Location loc=new Location(x,y);
		
		if(x > minX && x < maxX && y > minY && y < maxY){
			g2d.drawImage(view.getImage(), getMapPositionX(loc) + GameInfo.RALLYPOINT_SIZE, 
					getMapPositionY(loc), null);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image,0,0,null);
	}

	public void focusOn(Location loc){
		player.location = loc;
		ensureLocationOnMap();
		updateView();
	}

	public void focusOn(Controllable controllable){
		focusOn(controllable.getLoc());
		display(controllable, false);
	}

	public void swapTurn() {
		Player p=player;
		player=opponentPlayer;
		opponentPlayer=p;
	}
	
	private void ensureLocationOnMap(){
		int x=player.location.x % map.mapXSize;
		int y=player.location.y % map.mapYSize;

		while(x<0){
			x+=map.mapXSize;
		}

		while(y<0){
			y+=map.mapYSize;
		}

		player.location = new Location(x, y);
	}
	
	private int getMapPositionX(Location loc){
		return (int)((1.5*(loc.x-minX)+(0.75*(loc.y%2)))*GameInfo.TILE_SIZE);
	}
	
	private int getMapPositionY(Location loc){
		return (loc.y-minY)*GameInfo.TILE_SIZE/2;
	}
}
