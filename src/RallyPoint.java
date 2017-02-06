import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hankerins on 1/31/17.
 */

public class RallyPoint extends Controllable {

    Army army;

    Map.MapDirection[][] paths;

    public void generatePaths(){
        Queue<Location> bfsQueue = new LinkedList<Location>();
        bfsQueue.add(this.getLoc());

        paths[this.getLoc().y][this.getLoc().x] = null;

        while(!bfsQueue.isEmpty()){

            Location nextLoc = bfsQueue.poll();

            HashMap<Location, Map.MapDirection> adjacency = nextLoc.getAllAdjacent();

            for(Location loc : adjacency.keySet()){

                if(loc.x>=0 && loc.y >=0 && loc.x < GameInfo.MAP_SIZE && loc.y < GameInfo.MAP_SIZE && paths[loc.y][loc.x] == null && !this.getLoc().equals(loc) && getMap().getTile(loc).isTraversable(null) && getMap().getTile(loc).openTile(getPlayer())){
                    paths[loc.y][loc.x] = adjacency.get(loc);
                    bfsQueue.add(loc);
                }

            }
        }
    }

    public void givePathCommands(Unit target){
        ArrayList<Map.MapDirection> path;

        path = givePath(target.getLoc());

        for(Map.MapDirection md : path){
            target.giveCommand(new MoveCommand(target, md));
        }
    }

    public void redoPaths(){
        for(Unit target : this.army.getEntireArmy()){
            target.clearCommands();
        }
        moveRallyPoint(this.getLoc());
    }

    public void moveRallyPoint(Location loc){
        this.setLoc(loc);
        generatePaths();

        ArrayList<Map.MapDirection> path = null;

        if(!army.getBattleGroup().isEmpty()){

            for(Unit target : army.getBattleGroup()) {
                if (path == null && target.getLoc().isValid()) {
                    path = givePath(target.getLoc());
                }
                for(Map.MapDirection md : path){
                    target.giveCommand(new MoveCommand(target, md));
                }
            }

            for(Unit target : army.getReinforcements()) {
                this.givePathCommands(target);
            }
        }
    }

    public ArrayList<Map.MapDirection> givePath(Location loc){
        ArrayList<Map.MapDirection> path = new ArrayList<Map.MapDirection>();

        Map.MapDirection nextMove;

        while(loc != null && loc.isValid()){
            nextMove = getPath(loc);
            path.add(nextMove);
            loc = loc.getAdjacent(nextMove);
        }

        return path;
    }

    Map.MapDirection getPath(Location loc){
        return paths[loc.y][loc.x];
    }

    RallyPoint(Army army){
        super(army.getPlayer(), army.getLoc(), army.getMap());
        this.getCID().modeID = GameInfo.RALLYPOINTMODE;
        this.army = army;
        paths = new Map.MapDirection[GameInfo.MAP_SIZE][GameInfo.MAP_SIZE];
        }

    @Override
    void endTurn() {

    }

    @Override
    void clearCommands() {

    }

    @Override
    void doTurn() {

    }
    
    public int getTypeID(){
    	return GameInfo.RALLYPOINT;
    }
}
